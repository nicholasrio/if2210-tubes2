package RSSep;
/**
 * 
 * @author Capokantil
 *
 */

public class IndexKata {
	
	// Kelas IndexKata merupakan elemen type dari list yang terdapat di atribut
	// ListKata di kelas Index. Kelas ini mengandung informasi untuk sebuah kata
	// dan jumlah kemunculan kata tersebut

	private String Kata; // Nama Kata yang akan dihitung banyak kemunculannya
	private int Muncul;	// Banyak kemunculan kata

	/**
	 * Constructor
	 */
	public IndexKata() {
		Kata = "";
		Muncul = 0;
	}

	/**
	 * Contructor with parameter _Kata
	 * NKata is assigned with '1' because that word
	 * appears at least once
	 * @param _Kata
	 */
	public IndexKata(String _Kata) {
		Kata = _Kata;
		Muncul = 1;
	}

	/**
	 * Constructor with parameter "_Kata" and "_Muncul"
	 * @param _Kata
	 * @param _Muncul
	 */
	public IndexKata(String _Kata, int _Muncul) {
		Kata = _Kata;
		Muncul = _Muncul;
	}

	/**
	 * Getter of Kata attribute
	 * @return
	 */
	public String getKata() {
		return Kata;
	}

	/**
	 * Getter of Muncul attribute
	 * @return
	 */
	public int getMuncul() {
		return Muncul;
	}
	
	/**
	 * Set attribute Kata to _Kata;
	 * @param _Kata
	 */
	public void setKata(String _Kata) {
		Kata = _Kata;
	}

	/**
	 * Set attribute Muncul to _Muncul
	 * @param _Muncul
	 */
	public void setMuncul(int _Muncul) {
		Muncul = _Muncul;
	}

	/**
	 * Add NKata attribute by 1
	 */
	public void MunculPlus() {
	// Menambahkan atribut NKata sebanyak 1
		Muncul++;
	}

	/**
	 * Print all of the attribute
	 */
	public void PrintIndexKata() {
		System.out.println(Kata + "[" + Muncul + "]");
	}

	/* public static void main (String[] args) {
		IndexKata a = new IndexKata("a");
		a.PrintIdKata();
		a.MunculPlus();
		a.PrintIdKata();
		a.setMuncul(5);
		a.PrintIdKata();
		String b = "Kanya";
		a.setKata(b);
		a.PrintIdKata();
	} */

}
