
import java.io.*;
import java.util.*;

public class Map {
	static int[][] Peta;
	int row;
	int col;
    
   public static void baca_input () throws FileNotFoundException, IOException
    {
       BufferedReader baca = new BufferedReader(new FileReader("matriks.txt"));
       String s = null;
       int rows =0;
       int columns =0;
       int i = 0; 
       int j = 0; 
       
        row = 40;
		col = 72;
		Peta = new int [40][72];
        BufferedReader read = new BufferedReader(new FileReader("matriks.txt"));
        String a = null;
        while ((a = read.readLine()) != null)
        {
            String[] parts = a.split("\\s");
            for(String part : parts)
            {
               Peta[i][j] = Integer.valueOf(part);
                j++;
            }
            
            i++;
   
            j=0;
        }
    }
		
		public static void showMap() {
			for(int i=0;i<40;++i) {
				for(int j=0;j<72;++j) {
					if((Peta[i][j] >> 4) == 1) {
						
					}
					else if((Peta[i][j] >> 4) == 2) {
						
					}
					else if((Peta[i][j] >> 4) == 3) {
						
					}
					else if((Peta[i][j] >> 4) == 4) {
						
					}
					else if((Peta[i][j] >> 4) == 5) {
						
					}
					else if((Peta[i][j] >> 4) == 6) {
						
					}
				}
			}
		}
   
	 public static void print_matriks (int [][]matriks)
    {
           for (int i = 0; i < 40 ; i ++)
           {
                for (int j = 0; j < 72; j++)
                {
                    System.out.print(Peta[i][j] + " ");
                    if(j == 71 -1)
                    {
                         System.out.println();
                    }
                }
           }
    }
		
		public void save_matriks () throws IOException {
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
		}
	
    public static void main(String[] args) throws FileNotFoundException, IOException  {
     Map.baca_input();
	 print_matriks(Map.Peta);
		Map.save_matriks();
	 }
	



}