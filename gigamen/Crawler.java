/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gigamen;

import java.io.File;
import java.util.*;

class PathName{
	public String FileName;
	public String Path;
}
/**
 *
 * @author steve
 */
public class Crawler {
    private final String pathInput;
	private final int sumFile;
	private List<PathName> ArrayFileName;
	
	public Crawler(String input){ // Konstruktor
		pathInput = input;
		sumFile = 0; // default
                ArrayFileName = new ArrayList<PathName>();
	}
	public int GetSumMaxFile(){ // Perkiraan banyaknya file di dalam direktori terkait
		return ArrayFileName.size();
	}
	public String GetFileName (int Indeks){ // Dapat Nama Fisik File 
		return ArrayFileName.get(Indeks).FileName;
	}
	public String GetFilePath (int Indeks){ // Dapat path direktori File 
		return ArrayFileName.get(Indeks).Path;
	}
	public String GetInputPath (){ // Dapat direktori input yang hendak ditelusuri isi filenya
		return pathInput;
	}
	
	public boolean IsMusicFile (String pathName){ // cek apakah file berekstensi musik atau bukan
		return (pathName.contains(".mp3"));
	}
	public void ReadDirectory(){ // Lakukan pembacaan dari direktori input ke array of PathName
		// Konstruktor kelas path untuk penelusuran direktori
		File input = new File (pathInput);
		// Masukkan daftar file di direktori pathInput ke array of string
		String[] ArrayFile = input.list();
		
		for (int i = 0; i < ArrayFile.length; i++)
		{
			File childPath = new File (pathInput + "/" + ArrayFile[i]);
			
			if ((childPath.isFile()) && (IsMusicFile(childPath.getName()))) { 
                                PathName temp = new PathName();
                                temp.FileName = ArrayFile[i];
                                temp.Path = pathInput + "/" + ArrayFile[i];
				ArrayFileName.add(temp);
			}
		}
	}
}
