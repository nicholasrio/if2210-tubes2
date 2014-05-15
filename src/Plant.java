import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Plant extends SaleableObject implements Drawable {
	private static int waterRottenLevel = -1;
	private static int fertilizerRottenLevel = -1;
	private static int waterMaxLevel = 10;
	private static int waterDropSpeed = 4;
	private static Image imgPlant;
	private static Image imgPlant1 = getImg1();
	private static Image imgPlant2 = getImg2();
	private static Image imgPlant3 = getImg3();
	private static int imgWidth = 100;
	private static int imgHeight = 100;
	
	private static Image getImg1(){
		ImageIcon ii = new ImageIcon("images/level2.png");
		return ii.getImage();
	}
	
	private static Image getImg2(){
		ImageIcon ii = new ImageIcon("images/level3.png");
		return ii.getImage();
	}
	
	private static Image getImg3(){
		ImageIcon ii = new ImageIcon("images/level4.png");
		return ii.getImage();
	}
	
    public Plant(){
    	age = 0;
    	state = 1;
		isFruitAvailable =  false;
		isRotten = false;
		waterLevel = waterMaxLevel * waterDropSpeed;
	}
	public double hargabibit(){
        //harga persatuan
        return price;
    }
    public double hargaUnlock(){
        //harga untuk mengunlock
        return 20;
    }
    
    public Image getImage(){
    	return imgPlant;
    }
    
   
	private int age;
	private int waterLevel;
	private int fertilizerLevel;
	private int waterDropLevel = 1;
	private int fertilizerDropLevel;
	private int harvestTime;
	private int harvestPeriod;
	private int rottenTime;
	private boolean isFruitAvailable;
	private boolean isRotten;
	private boolean isFruitRotten;
	private int fruitTime;
	private int fruitRottenTime;
	private int maxFertilizer;
	private int harvestTimeReset;
	protected Fruit fruit;
	
	private int state;
	
	public Fruit takeFruit(){
		isFruitAvailable = false;
		harvestTime = harvestTimeReset;
		Fruit temp = fruit;
		fruit = null;
		return temp;
	}
	
	public void watering(){
		waterLevel = waterMaxLevel * waterDropSpeed;
	}
	
	public void fertilizering(){
		if(fertilizerLevel<maxFertilizer){
			fertilizerLevel++;
			waterDropLevel++;
		}
		else{
			//pengennya throw exception
		}
	}
	
	private void fruiting(){
		fruit = new Fruit();
	}
	
	public void draw(Graphics g,int x,int y){
		if(state==1){
			g.drawImage(imgPlant1,x,y,imgWidth,imgHeight,null);
		}
		else if(state==2){
			g.drawImage(imgPlant2,x,y,imgWidth,imgHeight,null);
		}
		else if(state==3){
			g.drawImage(imgPlant3,x,y,imgWidth,imgHeight,null);
		}
		g.setColor(Color.BLUE);
		for(int i=0;i<waterLevel/waterDropSpeed;i++){
			g.fillRect(x+(imgWidth-10), y+imgHeight-(i*10), 10, 10);
		}
		g.setColor(Color.BLACK);
		for(int i=waterLevel/waterDropSpeed;i<waterMaxLevel;i++){
			g.fillRect(x+(imgWidth-10), y+imgHeight-(i*10), 10, 10);
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double timeElapsed) {
		// TODO Auto-generated method stub

		
		if(waterLevel > 0){
			waterLevel= waterLevel - waterDropLevel;
		}
		fertilizerLevel = fertilizerLevel - fertilizerDropLevel;
		if((waterLevel == waterRottenLevel) || (fertilizerLevel == fertilizerRottenLevel)){
			isRotten = true;
		}
		
		age++;
		if(age<=15){
			state = 1;
		}
		if(age>15){
			state = 2;
		}
		if(age>25){
			state = 3;
		}
		if(!isFruitAvailable){
			harvestTime++;
			if(harvestTime == harvestPeriod){
				fruiting();
				isFruitAvailable = true;
				isFruitRotten = false;
			}
		}
		else{
			if(!isFruitRotten){
				fruitTime++;
				if(fruitTime == fruitRottenTime){
					isFruitRotten = true;
				}
			}
		}
	}
}
