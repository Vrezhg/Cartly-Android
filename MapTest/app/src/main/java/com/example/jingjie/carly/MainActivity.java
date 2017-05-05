package com.example.jingjie.carly;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.*;


public class MainActivity extends AppCompatActivity
{
    private Button registerBtn;
    private Button testFBBtn;
    private Button LoginBtn;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private String userID=null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        MultiDex.install(this);
        setContentView(R.layout.activity_main);
        addButtonListener();
    }
    private void addButtonListener()
    {
        //addGoToMapBtnListener();
        //addTestFBBtnListener();
        //addUserBtnListener();
        addRegisterBtnListener();
        addLoginBtnListener();
    }

    private void addRegisterBtnListener()
    {
        registerBtn=(Button) findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                EditText etEmail=(EditText)findViewById(R.id.etEmail);
                String email=etEmail.getText().toString();
                EditText etPassword=(EditText)findViewById(R.id.etPassword);
                String pw=etPassword.getText().toString();
                String isDriver="false";
                final User u=new User(isDriver,email);
                //register
                final FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.createUserWithEmailAndPassword(email,pw)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>()
                        {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {
                                Log.d("hasComplete", "createUserWithEmail:onComplete:" + task.isSuccessful());
                                if(!task.isSuccessful())
                                {
                                    Toast.makeText(MainActivity.this, task.getException().getLocalizedMessage(),
                                            Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    userID=task.getResult().getUser().getUid();
                                    //add info to user
                                    mDatabase.child(getString(R.string.Users)).child(userID).setValue(u);

                                    Toast.makeText(MainActivity.this, "User created!",
                                            Toast.LENGTH_SHORT).show();
                                    //go to map with userId
                                    Intent i=new Intent(MainActivity.this,MapsActivity.class);
                                    i.putExtra("userID",userID);
                                    startActivity(i);
                                }
                            }
                        });
            }

        });
    }
    private void addLoginBtnListener()
    {
        Button LoginBtn=(Button)findViewById(R.id.LoginBtn);
        LoginBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                EditText etEmail=(EditText)findViewById(R.id.etEmail);
                String email=etEmail.getText().toString();
                EditText etPassword=(EditText)findViewById(R.id.etPassword);
                String pw=etPassword.getText().toString();
                final FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.signInWithEmailAndPassword(email,pw).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        Log.d("signIn", "signInWithEmail:onComplete:" + task.isSuccessful());
                        if(!task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, task.getException().getLocalizedMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            userID=task.getResult().getUser().getUid();
                            getIsDriver();
                        }
                    }
                });


            }

        });
    }
    private void getIsDriver()
    {
        DatabaseReference dr= mDatabase.child("Users").child(userID).child("isDriver");
        dr.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                //Toast.makeText(MainActivity.this, dataSnapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
                if(dataSnapshot.getValue().toString().equals("true"))
                {
                    Intent i=new Intent(MainActivity.this,DriverMapActivity.class);
                    i.putExtra("userID",userID);
                    startActivity(i);

                }

                else
                {
                    Intent i=new Intent(MainActivity.this,MapsActivity.class);
                    i.putExtra("userID",userID);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
    }

}
