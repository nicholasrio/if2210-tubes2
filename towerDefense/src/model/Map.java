package model;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Map {
    public static int[][] Peta;
    public static int row;
    public static int col;
    
    public static void readFile () throws FileNotFoundException, IOException
    {
        String s = null;
        row = 15;
        col = 20;
        int i = 0; 
        int j = 0; 
       
        Peta = new int [row][col];
        BufferedReader read = new BufferedReader(new FileReader("matriks.txt"));
        String a = null;
        while ((a = read.readLine())    != null)
        {
            String[] parts = a.split("\\s");
            for(String part : parts)
            {
               Peta[i][j] = Integer.valueOf(part);
               j++;
               if (j>19) {
                   j = 0;
               }
            }
            i++;
            j=0;
        }
        read.close();
    }
		
    public static void showMap() {
       for (int i = 0; i < row ; i ++)
       {
            for (int j = 0; j < col; j++)
            {
                if (Peta[i][j]==256) {
                    System.out.print(".");
                }
                else System.out.print("#");
            }
            System.out.println();
       }
    }
		
    /*public void save_matriks () throws IOException {
        try {
            FileWriter f = new FileWriter(new File("outfile.txt"));
            for(int i=0;i<40;++i) {
                    for(int j=0; j < 72; ++j) {
                            f.write(Peta[i][j] + " ");
                    }
                    f.write("\n");
            }
            f.close();
        }
        catch (IOException e) {
        }
    }*/
    
    public static void main(String args[]) {
        Map M = new Map();
        try {
            M.readFile();
        } catch (IOException ex) {
            System.out.println("File not found");
        }
        M.showMap();
    }
}