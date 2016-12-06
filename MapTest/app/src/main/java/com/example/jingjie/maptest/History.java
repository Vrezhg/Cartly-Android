package com.example.jingjie.maptest;

/**
 * Created by Jingjie on 11/28/2016.
 */

public class History
{
    FileUtil fu;

    public History(String path) throws Exception
    {
        fu=new FileUtil(path);
    }

    public void addHistory(String str) throws Exception
    {
        fu.writeFile(str);
    }

    public String getHistory()throws Exception
    {
        return fu.readFile();
    }

    public void clearHistory() throws Exception
    {
        fu.clearFile();
    }

    public boolean repeated(String str) throws Exception
    {
        if(getHistory()==null){
            return false;
        }
        String[] strArr=getHistory().split(",");

        for(int i=0;i<strArr.length;i++)
        {
            if(strArr[i].equals(str))
            {
                return true;
            }
        }

        return false;
    }

}
