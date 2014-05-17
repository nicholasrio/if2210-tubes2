public class Main {
	public static void main(String[] args) {
		System.out.print(String.format("\033[2J"));
		
		System.out.println(String.format("%c[%d;%df", 0x1B, 10, 10) + " ___ ");
		System.out.println(String.format("%c[%d;%df", 0x1B, 11, 10) + "|   |");
		System.out.println(String.format("%c[%d;%df", 0x1B, 12, 10) + "|   |");
		System.out.println(String.format("%c[%d;%df", 0x1B, 13, 10) + "|___|");
		
		System.out.println(String.format("%c[%d;%df", 0x1B, 10, 20) + " ___ ");
		System.out.println(String.format("%c[%d;%df", 0x1B, 11, 20) + "\\   /");
		System.out.println(String.format("%c[%d;%df", 0x1B, 12, 20) + " \\ / ");
		System.out.println(String.format("%c[%d;%df", 0x1B, 13, 20) + "  V  ");
		
		System.out.println(String.format("%c[%d;%df", 0x1B, 10, 30) + "_   _");
		System.out.println(String.format("%c[%d;%df", 0x1B, 11, 30) + " \\ / ");
		System.out.println(String.format("%c[%d;%df", 0x1B, 12, 30) + "  X  ");
		System.out.println(String.format("%c[%d;%df", 0x1B, 13, 30) + "_/ \\_");
	}
}
