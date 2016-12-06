package com.example.jingjie.maptest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Jingjie on 11/28/2016.
 */

public class FileUtil
{
    public static final String FILE_NAME="/history.txt";
    File file;
    Scanner scr;
    PrintWriter ptr;
    String currContent;



    public FileUtil(String path) throws Exception
    {
        file=new File(path+FILE_NAME);
        if(!file.exists())
        {
            file.createNewFile();
        }
        scr=new Scanner(file);
        currContent=readFile();
        scr.close();

    }

    public void writeFile(String str) throws Exception
    {
        currContent=readFile();
        if(currContent!=null)
        {
            str = currContent + "," + str;
        }
        ptr=new PrintWriter(file);
        ptr.print(str);
        ptr.close();
    }


    public String readFile() throws Exception
    {
        scr=new Scanner(file);
        String returnStr;
        if(scr.hasNext())
        {
            returnStr = scr.nextLine();
        }
        else
        {
            returnStr=null;
        }
        scr.close();
        return returnStr;
    }
    public void clearFile() throws Exception
    {
        ptr=new PrintWriter(file);
        ptr.close();
    }



}

