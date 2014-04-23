// kelas tower

import java.util.*;

public class Tower{
	public int level_max;
	private int current_level;
	private int position_x;
	private int position_y;
	private int upgrade_cost;
	private int attack;
	private int range;
	private int attackSpeed;

	public Tower(int _position_x, int _position_y){
		current_level=1;
		position_x=_position_x;
		position_y=_position_y;
		attack=;
		range=;
		attackSpeed=;
	}
	public void tembak(){

	}
	public void upgrade(){
		if(current_level != level_max){
			current_level++;
			range=range+_;
			attack=attack+_;
			attackSpeed=attackSpeed+_;
		}
	}
}