import java.util.*;

public class ND {
	private static Field Player[];
	public static void main(String[] args) {
		Player = new Field[2];
		Scanner reader = new Scanner(System.in);
		Player[0] = new Field(true);
		Player[1] = new Field(false);
		int playernow = 0;
		Player[0].SetTurn(0);
		Player[1].SetTurn(0);
		while(Player[0].HP != 0 && Player[1].HP != 0) {
			Player[playernow%2].SetTurn(100);
			PrintScale(playernow%2);
			char c = reader.next().charAt(0);
			while(Player[playernow%2].GetTurn() != 0) {
				if(c == 'd') {
					int x = reader.nextInt();
					int y = reader.nextInt();
					Player[playernow%2].Delete(x-1, y-1);
					Player[playernow%2].SetTurn(Player[playernow%2].GetTurn()-1);
				}
				else if(c == 'm') {
					int x1 = reader.nextInt();
					int x2 = reader.nextInt();
					Player[playernow%2].Move(x1-1, x2-1);
				}
				else if(c == 'c') {
					Player[playernow%2].Call();
				}
				while(Player[playernow%2].Formation()) {}
				PrintScale(playernow%2);
				if(Player[playernow%2].GetTurn() != 0) {
					c = reader.next().charAt(0);
				}
			}
			playernow++;
		}		
	}
	public static void PrintScale(int playernow) {
		System.out.print(String.format("\033[2J"));
		Player[0].Print();
		Player[1].Print();
		int extend = 0;
		if(playernow == 1) {
			extend = 59;
		}
		for(int i=0; i<8; i++) {
			System.out.print(String.format("%c[%d;%df", 0x1B, 4*(i+1)+2, 69) + "-" + (i+1) + "-");
		}
		for(int i=0; i<6; i++) {
			System.out.print(String.format("%c[%d;%df", 0x1B, 2, 20+i*8) + (6-i));
		}
		for(int i=0; i<6; i++) {
			System.out.print(String.format("%c[%d;%df", 0x1B, 2, 80+i*8) + (i+1));
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
		System.out.print(String.format("%c[%d;%df", 0x1B, 38, extend+20) + "command : ");
	}
}
