import java.util.*;

public class ND {
	private static Field Player[];
        /**
         * Main Program
         */
	public static void main(String[] args) {
		Player = new Field[2];
		Scanner reader = new Scanner(System.in);
		String s;
		char c;
		do {
			System.out.print(String.format("\033[2J"));
			Player[0] = new Field(true);
			Player[1] = new Field(false);
			int playernow = 0;
			Player[0].SetTurn(0);
			Player[1].SetTurn(0);
			int posisi = 0;
			int WeatherDetermined = 0;
			int WeatherTypeInt = 0;
			while(Player[0].HP > 0 && Player[1].HP > 0) {
				if (WeatherDetermined % 6 == 0){
					Player[0].ResetUnitWeather();
					Player[1].ResetUnitWeather();
					Random rand = new Random();
			        WeatherTypeInt = rand.nextInt(8) + 1;			        	        
				} 
				else if (WeatherDetermined % 6 == 4){ // NORMALISASI WEATHER SETELAH 2 TURN
					WeatherTypeInt = 0;
				}
				Player[0].WeatherRandom(WeatherTypeInt);
			 	Player[1].WeatherRandom(WeatherTypeInt);
				Player[playernow%2].SetTurn(3);
				Player[playernow%2].ReduceChargeTurn();
				Attack(Player, playernow%2);
				while(Player[playernow%2].GetTurn() != 0 && Player[0].HP > 0 && Player[1].HP > 0) {
					Player[playernow%2].WeatherRandom(WeatherTypeInt);
					PrintScale(playernow%2, WeatherTypeInt);
					s = reader.next();
					if(s.equals("delete")) {
						char x = reader.next().charAt(0);
						int y = reader.nextInt();
						Player[playernow%2].Delete(y-1, x-97);
						Player[playernow%2].SetTurn(Player[playernow%2].GetTurn()-1);
					}
					else if(s.equals("move")) {
						int x1 = reader.nextInt();
						int x2 = reader.nextInt();
						Player[playernow%2].Move(x1-1, x2-1);
					}
					else if(s.equals("call")) {
						Player[playernow%2].Call();
					}
					else if(s.equals("surrender")) {
						Player[playernow%2].HP = 0;
					}
					else if(s.equals("skip")) {
						Player[playernow%2].SetTurn(0);
					}
					while(Player[playernow%2].Formation()) {}
				}
				playernow++;
				WeatherDetermined++;
			}
			System.out.print(String.format("\033[2J"));
			if(Player[0].HP <= 0) {
				System.out.print(String.format("%c[%d;%df", 0x1B, 10, 20) + "Player 2 wins !");
			}
			else {
				System.out.print(String.format("%c[%d;%df", 0x1B, 10, 20) + "Player 1 wins !");
			}
			System.out.print(String.format("%c[%d;%df", 0x1B, 12, 20) + "Play again ? [y/n] ");
			c = reader.next().charAt(0);
			while(c != 'y' && c != 'n') {
				System.out.print(String.format("\033[2J"));
				System.out.print(String.format("%c[%d;%df", 0x1B, 10, 20) + "Player " + (playernow%2+1) + " wins !");
				System.out.print(String.format("%c[%d;%df", 0x1B, 12, 20) + "Play again ? [y/n] ");
				c = reader.next().charAt(0);
			}
		} while (c != 'n');
		System.out.print(String.format("\033[2J"));
	}
        /**
         * Menampilkan field pada layar
         */
	public static void PrintScale(int playernow, int WeatherTypeInt) {
		System.out.print(String.format("\033[2J"));
		Player[0].Print(playernow%2);
		Player[1].Print(playernow%2);
		int extend = 0;
		if(playernow == 1) {
			extend = 59;
		}
		for(int i=0; i<8; i++) {
			System.out.print(String.format("%c[%d;%df", 0x1B, 4*(i+1)+2, 69) + "-" + (i+1) + "-");
		}
		for(int i=0; i<6; i++) {
			System.out.print(String.format("%c[%d;%df%c", 0x1B, 2, 20+i*8, (102-i)));
		}
		for(int i=0; i<6; i++) {
			System.out.print(String.format("%c[%d;%df%c", 0x1B, 2, 80+i*8, (i+97)));
		}
		System.out.print(String.format("%c[%d;%df", 0x1B, 3, extend+17));
		for(int i=0; i<49; i++) {
			System.out.print("_");
		}
		System.out.print(String.format("%c[%d;%df", 0x1B, 36, extend+17));
		for(int i=0; i<49; i++) {
			System.out.print("_");
		}
		for(int i=0; i<33; i++) {
			System.out.print(String.format("%c[%d;%df", 0x1B, i+4, extend+66) + "|");
		}
		for(int i=0; i<33; i++) {
			System.out.print(String.format("%c[%d;%df", 0x1B, i+4, extend+16) + "|");
		}
		PrintWeather(WeatherTypeInt);
		System.out.print(String.format("%c[%d;%df", 0x1B, 40, extend+20) + "command : ");
	}
	/**
         * Melakukan attack pada formasi yang memiliki turn 0
         */
	public static void Attack(Field[] player, int playernow) {
		for(int i=0; i<4; i++) {
			for(int j=0; j<8; j++) {
				while(player[playernow].U[i][j].GetStatus() == 2 && player[playernow].U[i][j].GetTurn() == 0) {
					int damage = player[playernow].U[i][j].GetHP();
					while(damage > 0) {
						if(player[(playernow+1)%2].U[0][j].GetStatus() == 0) {
							player[(playernow+1)%2].HP = player[(playernow+1)%2].HP - damage;
							damage = 0;
						}
						else if(player[(playernow+1)%2].U[0][j].GetStatus() == 1) {
							damage = damage - player[(playernow+1)%2].U[0][j].GetHP();
							player[(playernow+1)%2].Delete(j, 0);
						}
						else if(player[(playernow+1)%2].U[0][j].GetStatus() == 2) {
							if(player[(playernow+1)%2].U[0][j].GetHP() > damage) {
								player[(playernow+1)%2].U[0][j].SetHP(player[(playernow+1)%2].U[0][j].GetHP() - damage);
								player[(playernow+1)%2].U[1][j].SetHP(player[(playernow+1)%2].U[1][j].GetHP() - damage);
								player[(playernow+1)%2].U[2][j].SetHP(player[(playernow+1)%2].U[2][j].GetHP() - damage);
								damage = 0;
							}
							else {
								damage = damage - player[(playernow+1)%2].U[0][j].GetHP();
								for(int l=0; l<3; l++) {
									player[(playernow+1)%2].U[0][j].SetStatus(1);
									player[(playernow+1)%2].Delete(j, 0);
								}
							}
						}
						else if(player[(playernow+1)%2].U[0][j].GetStatus() == 3) {
							if(player[(playernow+1)%2].U[0][j].GetHP() > damage) {
								player[(playernow+1)%2].U[0][j].SetHP(player[(playernow+1)%2].U[0][j].GetHP() - damage);
								damage = 0;
							}
							else {
								damage = damage - player[(playernow+1)%2].U[0][j].GetHP();
								player[(playernow+1)%2].Delete(j, 0);
							}
						}
						try {
							for(int k=0; k<3; k++) {
								player[playernow].U[i+k][j].SetHP(damage);
							}
							player[0].Print(1);
							player[1].Print(1);
							Thread.sleep(500);
						}
						catch(Exception e) {}
					}
					for(int k=0; k<3; k++) {
						player[playernow].U[i][j].SetStatus(1);
						player[playernow].Delete(j, i);
					}
				}
			}
		}
	}
        /**
         * Menampilkan weather yang sedang berlaku
         */
	public static void PrintWeather(int WeatherTypeInt) {
		System.out.print(String.format("%c[%d;%df", 0x1B, 38, 66) + "");
		switch(WeatherTypeInt) {
			case 0 :
				System.out.print("Normal"); break;
			case 1 :
				System.out.print("Kemarau"); break;
			case 2 :
				System.out.print("Gempa"); break;
			case 3 :
				System.out.print("Badai"); break;
			case 4 :
				System.out.print("Hujan Asam"); break;
			case 5 :
				System.out.print("Badai UAS"); break;
			case 6 :
				System.out.print("Sunny uhuy"); break;
			case 7 :
				System.out.print("Kebakaran"); break;
		}
	}
}
