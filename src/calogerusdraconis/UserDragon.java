package calogerusdraconis;

import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep; 
import java.util.ArrayList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author WILLY, Cilvia Sianora Putri, Dariel Valdano
 */
public class UserDragon extends Dragon {

    private String password;

    private float money;

    private float happiness;
	
    private ArrayList<Consumable> fdInventory;
	
    protected float maxHealth;
    
    protected float maxStamina;
    
    private final Thread th;
	
	/** 
	 * Constructor UserDragon
	 * @param name			Name of Dragon
	 * @param health		Health point of Dragon
	 * @param maxHealth		maxHealth of Dragon
	 * @param stamina		Stamina point of Dragon
	 * @param maxStamina	maxStamina of Dragon
	 * @param thirst		Thirst point of Dragon
	 * @param bladder		Bladder point of Dragon
	 * @param hunger		Hunger point of Dragon
	 * @param level			Level of Dragon
	 * @param experience	Experience point of Dragon
	 * @param password		Password of Dragon
	 * @param money			Money of Dragon
	 * @param happiness		Happiness point of Dragon
	 */
    public UserDragon (String name, float health, float maxHealth, float stamina, float maxStamina, float thirst, float bladder, float hunger, int level, int experience, String password, float money, float happiness) {
        super(name, health, stamina, thirst, bladder, hunger, level, experience);
        this.maxHealth = maxHealth;
        this.maxStamina = maxStamina;
        this.password = password;
        this.money = money;
        this.happiness = happiness;
		fdInventory = new ArrayList<>();
		th = new Thread() {
            @Override
            public void run() {
                try {
                    while(true) {
                        sleep(5000);
                        modifyAttribute();
                    }
                } catch (InterruptedException ex) {
                }
            }
        };
        th.start();
    }
    
	/**	
	 * Menambah parameter Health pada Dragon
	 * @param val jumlah health point yang akan ditambah
	 */
    private void tambahHealth(float val) {
        synchronized(this) {
            if (health + val < 0) {
                health = 0;
            } else {
                if (health + val > maxHealth) {
                    health = maxHealth;
                } else health += val;
            }
        }
    }
    
	/**
	 * Menambah parameter Stamina pada Dragon
	 * @param val jumlah stamina point yang akan ditambah
	 */
    private void tambahStamina(float val) {
        synchronized(this) {
            if (stamina + val < 0) {
                stamina = 0;
            } else {
                if ((stamina + val) > maxStamina) {
                   stamina = maxStamina;
                } else stamina += val;
            }
        }
    }
    
	/**
	 * Menambah parameter Thirst pada Dragon
	 * @param val jumlah thirst point yang akan ditambah
	 */
    private void tambahThirst(float val) {
        synchronized(this) {
            if (thirst + val < 0) {
                thirst = 0;
            } else {
                if ((thirst + val) > 100) {
                   thirst = 100;
               } else thirst += val;
            }
        }
    }
    
	/**
	 * Menambah parameter Bladder pada Dragon
	 * @param val jumlah bladder point yang akan ditambah
	 */
    private void tambahBladder (float val) {
        synchronized(this) {
            if (bladder + val < 0) {
                bladder = 0;
            } else {
                if (bladder + val > 100) {
                    bladder = 100;
                } else bladder += val;
            }
        }
    }
    
	/**
	 * Menambah parameter Hunger pada Dragon
	 * @param val jumlah hunger point yang akan ditambah
	 */
    private void tambahHunger (float val) {
        synchronized (this) {
            if (hunger + val < 0) {
                hunger = 0;
            } else {
                if (hunger + val > 100) {
                    hunger = 100;
                } else hunger += val;
            }
        }
    }
    
	/**
	 * Menambah parameter Money pada Dragon
	 * @param val jumlah money yang akan ditambah
	 */
    public void tambahMoney(float val) {
        synchronized (this) {
            money += val;
        }
    }
    
	/**
	 * Menambah parameter Happiness pada Dragon
	 * @param val jumlah happiness point yang akan ditambah
	 */
    private void tambahHappiness(float val) {
        synchronized(this) {
            if (happiness + val < 0) {
                happiness = 0;
            } else {
                if (happiness + val > 100) {
                    happiness = 100;
                } else happiness += val;
            }
        }
    }
    
	/**
	 * Menambah parameter Experience pada Dragon
	 * @param val jumlah experience point yang akan ditambah
	 */
	private void tambahExperience(float val) {
		synchronized(this) {
			experience += val; 
		}
	}
	
	/**
	 * Getter maxHealth
	 * @return maxHealth of Dragon
	 */
    public float getMaxHealth() {
        return maxHealth;
    }
    
	/**
	 * Getter maxStamina
	 * @return maxStamina of Dragon
	 */
    public float getMaxStamina() {
        return maxStamina;
    }

	/**
	 * Getter inventory
	 * @return inventory of Dragon
	 */
    public ArrayList<Consumable> getFdInventory () {
        return fdInventory;
    }
	
	public void setFdInventory(ArrayList<Consumable> fd) {
		fdInventory = fd;
	}

	/**
	 * Getter Happiness
	 * @return happiness point of Dragon
	 */
    public float getHappiness () {
        return happiness;
    }

	/**
	 * Setter Happiness
	 * @param val new happiness point of Dragon
	 */
    public void setHappiness (float val) {
        this.happiness = val;
    }

	/**
	 * Getter Money
	 * @return money of Dragon
	 */
    public float getMoney () {
        return money;
    }

	/**
	 * Setter Money
	 * @param val new money of Dragon
	 */
    public void setMoney (float val) {
        this.money = val;
    }

	/**
	 * Getter Password
	 * @return password of Dragon
	 */
    public String getPassword () {
        return password;
    }

	/**
	 * Setter Password
	 * @param val new password of Dragon
	 */
    public void setPassword (String val) {
        this.password = val;
    }

	/**
	 * Memberi Consumable yang sudah dibeli ke Dragon
	 * @param fd Consumable yang akan diberikan ke Dragon
	 * @return Event memberi Consumable selesai
	 */
    public Event useConsumable (Consumable fd) {
		/* Prekondisi : fd sudah ada di barang karena dipilih dari fd */
		tambahHealth(fd.getHealthValue());
		tambahThirst(fd.getThirstValue());
		tambahHunger(fd.getHungerValue());
		tambahStamina(fd.getStaminaValue());
		maxStamina += fd.getMaxStaminaValue();
		maxHealth += fd.getMaxHealthValue();
		tambahHappiness(fd.getHappinessValue());
		int idx = this.fdInventory.indexOf(fd);
		this.fdInventory.remove(idx);
		return new Event("Proses Selesai","useCosumable Selesai");
    }
	
	/**
	 * Membeli Consumable dari store
	 * @param what Consumable yang akan dibeli
	 * @return Event beli Consumable selesai
	 * @throws Exception Uang tidak cukup
	 */
    public Event addConsumable (Consumable what) throws NotEnoughMoneyException {
        if (money < what.getCost()) throw new NotEnoughMoneyException ();
		money -= what.getCost();
		fdInventory.add(what);
		return new Event("Proses Selesai","addConsumable Selesai");
    }
    
	/**
	 * sebelum melakukan Exit meng-interrupt thread
	 */
    public void sebelumExit() {
        th.interrupt();
    }
	
	/**
	 * Menampilkan gambar dragon berdasarkan status 
	 * @return 
	 */
	public javax.swing.ImageIcon getImage() {
		String emotion = "neutral";
		if (health/maxHealth < stamina/maxStamina && health/maxHealth < (100-hunger)/100 && health/maxHealth < (100-thirst)/100 && health/maxHealth < (100-bladder)/100) {
			if (health/maxHealth < 0.6) {
				emotion = "health-";
			} // else neutral
		} else if (stamina/maxStamina < health/maxHealth && stamina/maxStamina < (100-hunger)/100 && stamina/maxStamina < (100-thirst)/100 && stamina/maxStamina < (100-bladder)/100) {
			if (stamina/maxStamina < 0.3) {
				emotion = "stamina-";
			} // else neutral
		} else if ((100-hunger)/100 < stamina/maxStamina && (100-hunger)/100 < health/maxHealth && (100-hunger)/100 < (100-thirst)/100 && (100-hunger)/100 < (100-bladder)/100) {
			if (hunger > 60) {
				emotion = "hunger-";
			} // else neutral
		} else if ((100-thirst)/100 < stamina/maxStamina && (100-thirst)/100 < (100-hunger)/100 && (100-thirst)/100 < health/maxHealth && (100-thirst)/100 < (100-bladder)/100) {
			if (thirst > 60) {
				emotion = "thirst-";
			} // else neutral
		} else if ((100-bladder)/100 < stamina/maxStamina && (100-bladder)/100 < (100-hunger)/100 && (100-bladder)/100 < (100-thirst)/100 && (100-bladder)/100 < health/maxHealth) {
			if (bladder > 60) {
				emotion = "bladder-";
			} // else neutral
		}

		return new javax.swing.ImageIcon(getClass().getResource("/calogerusdraconis/res/" + emotion + " r.png"));
	}
    
	/**
	 * Mengubah parameter-parameter Dragon seiring berjalannya waktu
	 */
    private void modifyAttribute() {
        if (hunger > 75){ // lapar banget
            tambahHappiness(-5);
            tambahHealth (-2.4f);
			tambahHunger (2);
			tambahThirst (2);
        } else if (hunger > 50){
            tambahHappiness(-3);
            tambahHealth (-1.2f);
        }

        if (thirst > 75){ // haus banget
            tambahHappiness(-5);
            tambahHealth(-2.4f);
        } else if (thirst > 50){
            tambahHappiness(-3);
            tambahHealth (-1.2f);
        }

		if (hunger < 20){ // kalau baru makan
            tambahBladder(2.0f);
        } else if (hunger < 40){
            tambahBladder(1.6f);
        } else if (hunger < 80){
            tambahBladder(0.8f);
        } else {
            tambahBladder(0.4f);
        }

        if (thirst < 20){ // kalau baru makan
            tambahBladder(2.0f);
        } else if (thirst < 40){
            tambahBladder(1.6f);
        } else if (thirst < 80){
            tambahBladder(0.8f);
        } else {
            tambahBladder(0.4f);
        }
		
        if (bladder > 75){ // kebelet banget
            tambahHappiness(-5);
            tambahHealth(-2.4f);
        } else if (bladder > 50){
            tambahHappiness(-3);
            tambahHealth (-1.2f);
        }

        if (happiness < 50){ // galau banget
            tambahHealth(-2.4f);
        } else if (happiness < 25){
            tambahHealth(-1.2f);
        }
		
		//tambah attribute
        tambahHealth(util.randomInt(3,7));
        tambahStamina(util.randomInt(5,10)/10);
        tambahMoney(util.randomInt(1,5));
        tambahHappiness(-util.randomInt(5,10)/10);
        tambahThirst(util.randomInt(5,20)/10);
        tambahHunger(util.randomInt(5,20)/10);
    }
	
	/**
	 * Men-generate Enemy Dragon untuk fight
	 * @return Dragon Enemy hasil generate
	 */
	public Dragon generateEnemy() {
        float ranHealth = util.gaussBasedOn(3*maxHealth/4);
        float ranStamina = util.gaussBasedOn(3*maxStamina/4);
		int ranExperience = (int) util.gaussBasedOn(experience);
		int ranLevel = (int) util.gaussBasedOn(level);
		float ranThirst = util.gaussBasedOn(100/4);
		float ranBladder = util.gaussBasedOn(100/4);
		float ranHunger = util.gaussBasedOn(100/4);
        
		Dragon withWho = new Dragon(getRandomName(), ranHealth, ranStamina, ranThirst, ranBladder, ranHunger, ranLevel, ranExperience);
		
		return withWho;
	}
	
	/**
	 * Mengambil nama dragon enemy secara random dari XML
	 * @return nama dragon enemy
	 */
	private String getRandomName(){
		String retval = "Enemy Dragon";
		try {
			// Load XML and get root Node
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File("enemyDragons.xml");
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			
			int len = Integer.parseInt(rootNode.getChildren("length").get(0).getText());
			
			//get list of root/save nodes
			retval = rootNode.getChildren("name").get(util.randomInt(0,len-1)).getText();
			
		} catch (IOException | JDOMException io) {
			io.printStackTrace();
		}
		return retval;
	}
	
	/**
	 * Bertarung dengan Dragon lain
	 * @param withWho Dragon lain yang akan bertarung
	 * @return Event fight selesai
	 */
	public Event fight (Dragon withWho) {
        float sum1 = (float)0.2 * health + (float)0.2 * stamina + (float)0.3 * experience + 5 * level - (float)0.1 * thirst - (float)0.1 * bladder - (float)0.1 * hunger;
        float sum2 = (float)0.2 * withWho.getHealth() + (float)0.2 * withWho.getStamina() + (float)0.3 * withWho.getExperience() + 5 * withWho.getLevel() - (float)0.1 * withWho.getThirst() - (float)0.1 * withWho.getBladder() - (float)0.1 * withWho.getHunger();
        
        Event e = new Event();
        if (sum1 > sum2){ // we win
            e.setType("WinFight");
            e.setMessage("Congrats! You Win.");
			health -= 10 * level;
            experience += 200 + 30 * level;
            tambahMoney((float)(100 + (Math.random() * (500 - 100))));
        } else if (sum1 == sum2){ // draw
            experience += 25 * level;
			e.setType("DrawFight");
			e.setMessage("This fight is a Draw.");
			health -= 20 * level;
        } else { // we lose
			experience += 20 * level;
			health -= 30 * level;
			e.setType("LoseFight");
	        e.setMessage("Sorry! You Lose.");
		}
		tambahStamina(-20 * level);
        // jika naik level
        while(experience >= 100*(level+1)*(level+1)*(level+1)){
            level++;
            maxHealth += 30;
            maxStamina += 10;
        }
        return e;
    }

	/**
	 * Mengajak Dragon berlatih
	 * @return Event train selesai
	 */
    public Event train () {
		try {
			sleep(1000);
			tambahExperience(20*level);
			while(experience >= 100*(level+1)*(level+1)*(level+1)){
				level++;
				maxHealth += 30;
				maxStamina += 10;
			}
		} catch (InterruptedException e) {
			
		}
        return new Event("Proses Selesai","The dragon is now Trained");
    }

	/**
	 * Mengajak Dragon bermain
	 * @return Event entertain selesai
	 */
    public Event entertain () {
		try {
			for (int i = 0; i<10; i++) {
				sleep(1000);
				tambahHappiness(4);
			}
		} catch(InterruptedException e) {
			
		}
		return new Event("Proses Selesai","The dragon is now more entertained");
    }

	/**
	 * Menyuruh Dragon tidur
	 * @return Event rest selesai
	 */
    public Event rest () {
		try {
			while (stamina < maxStamina || health < maxHealth) {
				sleep(1000);
				if (stamina < maxStamina) tambahStamina(5);
				if (health < maxHealth) tambahHealth(2*level);
			}
		} catch(InterruptedException e) {
			
		}
		return new Event("Proses Selesai","The dragon feels well-rested");
    }

	/**
	 * Menyuruh Dragon pergi ke toilet
	 * @return Event toilet selesai 
	 */
    public Event toToilet () {
		try {
			while (bladder > 0) {
				sleep(1000);
				tambahBladder(-10);
			}
		} catch(InterruptedException e) {
			
		}
		return new Event("Proses Selesai","The dragon's bladder is emptied.");
    }
}
