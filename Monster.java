import java.io.*;
public class Monster {
	private int hitPoints;
	private int position_x;
	private int position_y;
	
	public Monster() {
		hitPoints = 100;
		position_x = 0;
		position_y = 0;
	}
	
	public void move() {
	}
	
	public void decreaseHitPoints(int damage) {
		hitPoints = hitPoints - damage;
	}
	
	public void LevelUp(int level) {
		hitPoints = level * hitPoints;
		position_x = 0;
		position_y = 0;
		
	}
	
	public static void main(String[] args) {
		Monster monster = new Monster();
		monster.LevelUp(2);
		System.out.println(monster.hitPoints);
	}
}