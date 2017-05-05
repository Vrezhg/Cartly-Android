package com.example.jingjie.carly;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{

    private GoogleMap mMap;
    private GroundOverlay imageOverlay;
    private GroundOverlayOptions newarkMap;
    private String userId=null;
    private DatabaseReference target;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private int positionInLine=0;
    private int currNumOfPeople=0;
    private String prevStation="";
    private boolean inline=false;
    private TextView tv_ui;
    private Button leaveButton;
    private Button refreshButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //get userId
        getUserID();
        getCurrPosition();
        tv_ui=(TextView)findViewById(R.id.tv_ui);
        addButton();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        addOverLay( mMap);
        mMap.getUiSettings().setRotateGesturesEnabled(false);
        AddMarker.addStation();
        AddMarker.addMarkerToMap(mMap);

        AddMarker.drawLine(googleMap);

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
        {
            @Override
            public boolean onMarkerClick(Marker marker)
            {
                numOfPeopleInCurrMarker(marker);
                return true;
            }
        });

        //when user click info window,add user to the queue
        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker arg0)
            {
                //System.out.println();
                if(target==null)
                {
                    prevStation = arg0.getTitle();
                    String detial = prevStation.split(" ")[0] + "-" + prevStation.split(" ")[1];
                    target = mDatabase.child("Queue").child(detial).push();
                    target.setValue(userId);
                    getCurrPosition();
                }
                else
                {
                    if(prevStation.equals(arg0.getTitle()))
                    {
                        getCurrPosition();
                    }
                    else
                    {
                        removeFromQueue();
                        //get reference before add
                        prevStation = arg0.getTitle();
                        String detial = prevStation.split(" ")[0] + "-" + prevStation.split(" ")[1];
                        target = mDatabase.child("Queue").child(detial).push();
                        target.setValue(userId);
                        getCurrPosition();
                    }
                }
                arg0.hideInfoWindow();
            }
        });
    }

    private void addOverLay(GoogleMap mMap)
    {

        LatLngBounds newarkBounds = new LatLngBounds(
                new LatLng(34.235551, -118.533768),       // South west corner
                new LatLng(34.257127, -118.523552));      // North east corner
        newarkMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.map3))
                .positionFromBounds(newarkBounds);

// Add an overlay to the map, retaining a handle to the GroundOverlay object.
        imageOverlay = mMap.addGroundOverlay(newarkMap);
    }

    private void getUserID()
    {
        Intent i = getIntent();
        userId=i.getStringExtra("userID");
    }
    private void removeFromQueue()
    {
        if(target!=null)
        {
            target.removeValue();
            target = null;
            prevStation = "";
            tv_ui.setText("Not in line.\nClick marker to add");
        }
    }
    private void numOfPeopleInCurrMarker(Marker marker)
    {
        final Marker marker2=marker;
        String currStation = marker.getTitle();

        String detial = currStation.split(" ")[0] + "-" + currStation.split(" ")[1];
        DatabaseReference currTarget = mDatabase.child("Queue").child(detial);
        currTarget.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                currNumOfPeople=(int)(dataSnapshot.getChildrenCount());
                marker2.setSnippet((int)(dataSnapshot.getChildrenCount())+" people in the line. Click to add.");
                marker2.showInfoWindow();
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
    }
    private void getCurrPosition()
    {
        target=null;
        inline=false;
        final DatabaseReference temp[]=new DatabaseReference[2];
        final int[] numOfChild=new int[1];
        mDatabase.child("Queue").addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                Iterable<DataSnapshot> ii=dataSnapshot.getChildren();
                for(DataSnapshot snapshot : ii)
                {
                    numOfChild[0]=(int)(snapshot.getChildrenCount());
                    temp[0]=snapshot.getRef();
                    positionInLine=0;

                    for(DataSnapshot snapshotInner: snapshot.getChildren())
                    {
                        positionInLine++;
                        if(snapshotInner.getValue().toString().equals(userId))
                        {
                            inline=true;
                            temp[1]=snapshotInner.getRef();
                            break;
                        }
                        temp[1]=null;

                    }
                    if(inline)
                    {
                        prevStation=snapshot.getKey().split("-")[0]+" "+snapshot.getKey().split("-")[1];
                        break;
                    }
                }
                if(inline)
                    target=temp[1];
                if(inline)
                {
                    Toast.makeText(MapsActivity.this, "position is " + positionInLine + " in " + prevStation, Toast.LENGTH_LONG).show();
                    tv_ui.setText("position is " + positionInLine + " in " + prevStation);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
    }
    private void addButton()
    {
        addLeaveButton();
        addRefreshButton();
    }
    private void addLeaveButton()
    {
        leaveButton=(Button)findViewById(R.id.leave);
        leaveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                removeFromQueue();
            }
        });
    }
    private void addRefreshButton()
    {
        refreshButton=(Button)findViewById(R.id.refresh);
        refreshButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getCurrPosition();
            }
        });
    }
}
