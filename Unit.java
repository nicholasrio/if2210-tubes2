import java.util.*;

public class Unit {
	private int HP;
	private int Colour;
	private int Status;
	private int Turn;
	private boolean LeWeather;
	/**
         * Inisialisasi awal unit
         */
	public Unit() {
		HP = 3;
		Random rand = new Random();
		Colour = rand.nextInt(3) + 1;
		Status = 1;
		Turn = -1;
	}
        /**
         * Mendapatkan HP unit
         * @return HP
         */
	public int GetHP() {
		return HP;
	}
        /**
         * Mengembalikan jenis warna unit
         * @return Colour
         */
	public int GetColour() {
		return Colour;
	}
        /**
         * Mengembalikan status unit
         * @return Status
         */
	public int GetStatus() {
		return Status;
	}
        /**
         * Mengembalikan turn unit
         * @return Turn
         */
	public int GetTurn() {
		return Turn;
	}
        /**
         * Mengembalikan true jika terdapat weather
         * @return LeWeather
         */
	public boolean GetWeatherStatus(){
		return LeWeather;
	}
        /**
         * mengganti HP pada unit menjadi sebesar i
         * @param i HP unit
         */
	public void SetHP(int i) {
		HP = i;
	}
        /**
         * mengganti warna unit menjadi i
         * @param i jenis warna unit
         */
	public void SetColour(int i) {
		Colour = i;
	}
        /**
         * Mengganti status unit menjadi i
         * @param i status pengganti
         */
	public void SetStatus(int i) {
		Status = i;
	}
        /**
         * Mengganti turn unit menjadi i
         * @param i turn unit pengganti
         */
	public void SetTurn(int i) {
		Turn = i;
	}
        /**
         * Mengganti keadaan weather menjadi b
         * @param b keadaan weather pengganti
         */
	public void SetWeatherStatus(boolean b){
		LeWeather = b;
	}
        /**
         * Menampilkan unit pada konsol
         */
	public void Print(int x, int y, boolean b) {
		int extend = 10;
		if(!b) {
			extend = 70;
		}
		if(Status == 1) {
			if(Colour == 1) {
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x, extend+8*y) + " ___ ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+1, extend+8*y) + "|   |");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+2, extend+8*y) + "|   |");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+3, extend+8*y) + "|___|");
			}
			else if(Colour == 2) {
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x, extend+8*y) + " ___ ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+1, extend+8*y) + "\\   /");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+2, extend+8*y) + " \\ / ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+3, extend+8*y) + "  V  ");
			}
			else if(Colour == 3) {
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x, extend+8*y) + "_   _");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+1, extend+8*y) + " \\ / ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+2, extend+8*y) + "  X  ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+3, extend+8*y) + "_/ \\_");
			}
		}
		else if(Status == 2) {
			if(Colour == 1) {
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x, extend+8*y) + " ___ ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+1, extend+8*y) + "|#  |" + HP);
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+2, extend+8*y) + "|   |");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+3, extend+8*y) + "|___|" + Turn);
			}
			else if(Colour == 2) {
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x, extend+8*y) + " ___ ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+1, extend+8*y) + "\\#  /" + HP);
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+2, extend+8*y) + " \\ / ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+3, extend+8*y) + "  V  " + Turn);
			}
			else if(Colour == 3) {
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x, extend+8*y) + "_   _");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+1, extend+8*y) + "#\\ / " + HP);
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+2, extend+8*y) + "  X  ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+3, extend+8*y) + "_/ \\_" + Turn);
			}
		}
		else if(Status == 3) {
			System.out.println(String.format("%c[%d;%df", 0x1B, 4*x, extend+8*y) + " ### ");
			System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+1, extend+8*y) + " ### " + HP);
			System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+2, extend+8*y) + " ### ");
			System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+3, extend+8*y) + " ### ");
		}
		else {
			if(b) {
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x, extend+8*y) + "     ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+1, extend+8*y) + "     ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+2, extend+8*y) + "  >  ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+3, extend+8*y) + "     ");
			}
			else {
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x, extend+8*y) + "     ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+1, extend+8*y) + "     ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+2, extend+8*y) + "  <  ");
				System.out.println(String.format("%c[%d;%df", 0x1B, 4*x+3, extend+8*y) + "     ");
			}
		}
		/*System.out.print(HP);
		System.out.print(Status);
		System.out.print(Turn + " ");*/
	}
        /**
         * Menghapus unit
         */
	public void SetEmpty() {
		HP = 0;
		Colour = 0;
		Status = 0;
	}
        /**
         * Mencopy unit
         */
	public Unit Copy() {
		Unit U = new Unit();
		U.SetHP(GetHP());
		U.SetColour(GetColour());
		U.SetStatus(GetStatus());
		U.SetTurn(GetTurn());
		return U;
	}
}
