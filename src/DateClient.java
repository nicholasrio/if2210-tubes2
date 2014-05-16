package onlineprinter;

import java.io.*;
import java.net.*;
import java.util.Date;

class DateClient
{
    public static void main(String args[]) throws Exception
    {
        Socket soc=new Socket("localhost",5217);    
       
        DataOutputStream out=new DataOutputStream(soc.getOutputStream());
        out.writeBytes("aryya#password#Mencari cinta di kampus ganesha.pdf");
        
        BufferedReader in=new BufferedReader(
                new InputStreamReader(
                        soc.getInputStream()
                        )
                    );

        System.out.println(in.readLine());
        out.close();
    }    
}