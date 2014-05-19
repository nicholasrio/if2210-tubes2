package RSSep;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;

/**
 * 
 * @author Capokantil
 *
 */
public class Index {
	
	// Kelas Index adalah kelas yang menyimpan informasi semua kata beserta jumlah
	// kemunculan kata tersebut

    private List<IndexKata> ListKata; // List of IndexKata
    private List<String> ListOfCommonWords = new ArrayList<String>();

    /**
     * Constructor
     */
    public Index() {
        ListKata = new ArrayList<IndexKata>();
            
		try {
			File file = new File("commonWords.txt");
			FileReader fileReader;
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				ListOfCommonWords.add(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }

    /**
     * Constructor with parameter string type
     * @param strSource
     */
    public Index(String strSource) {
        ListKata = new ArrayList<IndexKata>();
        try {
			File file = new File("commonWords.txt");
			FileReader fileReader;
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				ListOfCommonWords.add(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        StringIndexing(strSource);
    }

    /**
     * return List of IndexKata from ListKata attribute
     * @return
     */
    public List<IndexKata> getListKata() {
        return ListKata;
    }

    /**
     * Add Object Class IndexKata to ListKata
     * @param Kata
     */
    public void addIndexKata(IndexKata Kata) {
        ListKata.add(Kata);
    }

    /**
     * Delete IndexKata Object from ListKata
     * @param Kata
     */
    public void delIndexKata(IndexKata Kata) {
        ListKata.remove(Kata);
    }

    /**
     * Show table that result of indexing to window
     */
    public void PrintIndex() {
        for (int i = 0; i < ListKata.size(); i++) {
            ListKata.get(i).PrintIndexKata();
        }
    }
    
    /**
     * Return true if String Kata does exist in ListKata
     * @param Kata
     * @return
     */
    public Boolean isKataAda(String Kata) {
    	Boolean KataAda = false;
    	for (int i = 0; i < ListKata.size(); i++) {
    		if (ListKata.get(i).getKata().compareToIgnoreCase(Kata) == 0) {
    			KataAda = true;
    			break;
    		}
    	}
    	return KataAda;
    }
    /**
     * return indeks where String Kata does exist in ListKata and
     * return -1 if String Kata does not exist in ListKata
     * @param Kata
     * @return
     */
    public int getIndexKata(String Kata) {
    	// Menghasilkan index dimana string Kata tersebut disimpan di ListKata, 
    	// akan mengembalikan nilai -1 apabila kata tersebut tidak ada di
    	int Idx = -1;
    	for (int i = 0; i < ListKata.size(); i++) {
    		if (ListKata.get(i).getKata().compareToIgnoreCase(Kata) == 0) {
    			Idx = i;
    			break;
    		}
    	}
    	return Idx;
    }
    
    public boolean isACommonWord(String s){
    	boolean found = false;
    	for(String str: ListOfCommonWords){
    		if(s.toLowerCase().contentEquals(str)){
    			found = true;
    			break;
    		}
    	}
    	return found;
    }
    
    /**
     * Indexing for String StrSource
     * @param StrSource
     */
    public void StringIndexing(String StrSource) {
    	String ArrSplit[] = StrSource.split("\\s+");
    	
    	for(String s : ArrSplit){
    		if(!isACommonWord(s) && s.length() > 6 ){
	    		if (!isKataAda(s)) {
	    			// Kalau kata belum terkandung di ListKata, masukkan
	    			// kata tersebut dan isi jumlah kemunculannya dengan 1
	    			IndexKata IK = new IndexKata(s);
	    			addIndexKata(IK);
	    		} else{
	    			// Kalau kata sudah terkandung di ListKata, tambahkan
	    			// jumlah kemunculan kata tersebut
	    			int idx = getIndexKata(s);
	    			ListKata.get(idx).MunculPlus();
	    		}
    		}
    	}
    }
    
    /**
     * Indexing from List of String Source
     * @param Source
     */
    public void Indexing(List<String> Source) {
        for (int i = 0; i < Source.size(); i++) {
            String StringSource = Source.get(i);
            StringIndexing(StringSource);
        }
    }
    
    /**
     * return index of word that has the highest number of occurrences
     * @return
     */
    public String KataTop() {
    	int iMax = 0;
    	int MunculMax = 0;
    	for (int i = 0; i < ListKata.size(); i++) {
    		if (ListKata.get(i).getMuncul() >= MunculMax) {
    			MunculMax = ListKata.get(i).getMuncul();
    			iMax = i;
    		}
    	}
    	return ListKata.get(iMax).getKata();    	
    }
    
    /**
     * return List of String that String N has the highest number of occurrences
     * @param N
     * @return
     */
    public List<String> KataTopN(int N) {
    	List<String> TopN = new ArrayList<String>();
    	int iMax;
    	int MunculMax;
    	for (int j = 0; j < N; j++) {
    		iMax = 0; MunculMax = 0;
    		
	    	for (int i = 0; i < ListKata.size(); i++) {
	    		if ((ListKata.get(i).getMuncul() >= MunculMax) &&
	    				(!TopN.contains(ListKata.get(i).getKata()))) {
	    			// Hanya kata-kata yang belum ada di list TopN yang
	    			// dapat menjadi untuk kata dengan MunculMax selanjutnya
	    			MunculMax = ListKata.get(i).getMuncul();
	    			iMax = i;
	    		}
	    	}
	    	TopN.add(ListKata.get(iMax).getKata());
    	}
    	return TopN;
    }

    

}

