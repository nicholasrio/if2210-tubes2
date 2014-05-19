/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
import java.util.*;

public class Unit {
	private int HP;
	private int Colour;
	private int Status;
	private int Turn;
	
	public Unit() {
		HP = 3;
		Random rand = new Random();
		Colour = rand.nextInt(3) + 1;
		Status = 1;
		Turn = -1;
	}
	public int GetHP() {
		return HP;
	}
	public int GetColour() {
		return Colour;
	}
	public int GetStatus() {
		return Status;
	}
	public int GetTurn() {
		return Turn;
	}
	public void SetHP(int i) {
		HP = i;
	}
	public void SetColour(int i) {
		Colour = i;
	}
	public void SetStatus(int i) {
		Status = i;
	}
	public void SetTurn(int i) {
		Turn = i;
	}
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
	public void SetEmpty() {
		HP = 0;
		Colour = 0;
		Status = 0;
	}
	public Unit Copy() {
		Unit U = new Unit();
		U.SetHP(GetHP());
		U.SetColour(GetColour());
		U.SetStatus(GetStatus());
		U.SetTurn(GetTurn());
		return U;
	}
}
