package onlineprinter;

import java.net.*;
import java.io.*;
import java.util.*;

class DateServer
{
    public static void main(String args[]) throws Exception
    {
        ServerSocket s=new ServerSocket(5217);
        while(true)
        {
            System.out.println("Waiting For Connection ...");
            Socket soc=s.accept();
            /* Membaca pesan */
            BufferedReader in=new BufferedReader(
                    new InputStreamReader(
                            soc.getInputStream()
                            )
                        );
            String [] infoUser  =   in.readLine().split("#");
            System.out.println("Request diterima dari:" + infoUser[0]);
            System.out.println("File:" + infoUser[2]);
            System.out.println("Authentivikasi...");            
            
            /* mengirim pesan */
            DataOutputStream out=new DataOutputStream(soc.getOutputStream());
            out.writeBytes("Request sudah diterima oleh server\n");
            out.close();
            soc.close();
        }

    }
}