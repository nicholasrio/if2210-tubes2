package calogerusdraconis;

import static java.lang.Thread.sleep; 
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.DF71A32C-B40F-498E-E6D5-9F4513B43A22]
// </editor-fold> 
public class UserDragon extends Dragon {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9B6996D6-9D30-35C7-C2CD-E73DB7F0E8CF]
    // </editor-fold> 
    private String password;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EBDC48DE-2E8B-B203-0F6D-4E51C55A8BCB]
    // </editor-fold> 
    private float money;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3E0300E9-AAEC-E4C7-70D3-67516D1EAA8D]
    // </editor-fold> 
    private float happiness;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E7EE7EE8-EEF2-6089-FC34-B81192D0AB59]
    // </editor-fold> 
    private ArrayList<Consumable> fdInventory;
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6E9F01F2-D50D-BD74-70EC-A8F0D4DFCCED]
    // </editor-fold> 
    protected float maxHealth;
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8E483E98-B30E-A342-6A19-2C19F3CABBE6]
    // </editor-fold> 
    protected float maxStamina;
    
    private Thread th;
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.39F10D0D-020E-7824-2E18-D995AC6ED214]
    // </editor-fold> 
    public UserDragon (String name, float health, float maxHealth, float stamina, float maxStamina, float thirst, float bladder, float hunger, int level, int experience, String password, float money, float happiness) {
        super(name, health, stamina, thirst, bladder, hunger, level, experience);
        this.maxHealth = maxHealth;
        this.maxStamina = maxStamina;
        this.password = password;
        this.money = money;
        this.happiness = happiness;
        th = new Thread() {
            @Override
            public void run() {
                try {
                    while(true) {
                        sleep(1000);
                        modifyAttribute();
                    }
                } catch (InterruptedException ex) {
                    System.out.println("interrupted");
                }
            }
        };
        th.start();
    }
    
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
    
    private void tambahThirst(int val) {
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
    
    private void tambahBladder (int val) {
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
    
    private void tambahHunger (int val) {
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
    
    private void tambahMoney(float val) {
        synchronized (this) {
            money += val;
        }
    }
    
    private void tambahHappiness(float val) {
        synchronized(this) {
            if ((happiness + val) > 100) {
                happiness = 100;
            } else happiness += val;
        }
    }
    
    public float getMaxHealth() {
        return maxHealth;
    }
    
    public float getMaxStamina() {
        return maxStamina;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B112E0C0-12CE-6328-CA63-947031A9E5D4]
    // </editor-fold> 
    public ArrayList<Consumable> getFdInventory () {
        return fdInventory;
    }
    
    public void removeFdInventory(int idx) {
        this.fdInventory.remove(idx);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DC5D1D42-8A76-00B1-081A-42B70BD35ABE]
    // </editor-fold> 
    public void addFdInventory (Consumable val) {
        this.fdInventory.add(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DE5979F6-6507-47F8-D0DB-38CDBF826BF7]
    // </editor-fold> 
    public float getHappiness () {
        return happiness;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6DDA13A0-CBDF-5386-53C4-B3572DA123D1]
    // </editor-fold> 
    public void setHappiness (float val) {
        this.happiness = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FF2F5803-9362-8956-4285-607F8311B732]
    // </editor-fold> 
    public float getMoney () {
        return money;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.94B86C97-726A-A571-226A-DE3EC1EF1BB5]
    // </editor-fold> 
    public void setMoney (float val) {
        this.money = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9C65A126-D740-7A30-3143-471B8151D021]
    // </editor-fold> 
    public String getPassword () {
        return password;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B85B65E8-3F7D-5A51-03F9-BE56ECA9662D]
    // </editor-fold> 
    public void setPassword (String val) {
        this.password = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2FA42178-E36A-15BE-3646-94D71EAC0289]
    // </editor-fold> 
    public Event useConsumable (Consumable fd) {
        return null;
    }
    
    public void sebelumExit() {
        th.interrupt();
    }
    
    private void modifyAttribute() {
        //tambah attribute
        tambahHealth(30 * level);
        tambahStamina(1);
        tambahMoney(1);
        tambahHappiness(-1);
        tambahThirst(1);
        tambahHunger(1);

        if (hunger > 75){ // lapar banget
            tambahHappiness(-5);
            tambahHealth (-10 * level);
        } else if (hunger > 50){
            tambahHappiness(-3);
            tambahHealth (-5 * level);
        }

        if (thirst > 75){ // haus banget
            tambahHappiness(-3);
            tambahHealth(-10 * level);
        } else if (thirst > 50){
            tambahHappiness(-5);
            tambahHealth (-5 * level);
        }

		if (hunger < 30){ // kalau baru makan
            tambahBladder(4);
        } else if (hunger < 60){
            tambahBladder(3);
        } else if (hunger < 90){
            tambahBladder(2);
        } else {
            tambahBladder(1);
        }

        if (thirst < 30){ // kalau baru makan
            tambahBladder(4);
        } else if (thirst < 60){
            tambahBladder(3);
        } else if (thirst < 90){
            tambahBladder(2);
        } else {
            tambahBladder(1);
        }
		
        if (bladder > 75){ // kebelet banget
            tambahHappiness(-3);
            tambahHealth(-10 * level);
        } else if (bladder > 50){
            tambahHappiness(-5);
            tambahHealth (-5 * level);
        }

        if (happiness < 50){ // galau banget
            tambahHealth(-10 * level);
        } else if (happiness < 25){
            tambahHealth(-5 * level);
        }
    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CAFBB28D-46E4-68A5-0A2A-82623BC039D0]
    // </editor-fold> 
    
    public Event fight () {
        
        Random rand = new Random();
        float ranHealth = (float) Math.ceil(rand.nextGaussian()*(0.2*health)+health);
        float ranStamina = (float) Math.ceil(rand.nextGaussian()*(0.2*stamina)+stamina);
        int ranExperience = (int) Math.ceil(rand.nextGaussian()*(0.2*experience)+experience);
        int ranLevel = (int) Math.ceil(rand.nextGaussian()*(0.2*level)+level);
        float ranThirst = (float) Math.ceil(rand.nextGaussian()*(0.2*thirst)+thirst);
        float ranBladder = (float) Math.ceil(rand.nextGaussian()*(0.2*bladder)+bladder);
        float ranHunger = (float) Math.ceil(rand.nextGaussian()*(0.2*hunger)+hunger);
        Dragon withWho = new Dragon("Random Dragon", ranHealth, ranStamina, ranThirst, ranBladder, ranHunger, ranLevel, ranExperience);
        
        float sum1 = (float)0.2 * health + (float)0.2 * stamina + (float)0.3 * experience + 5 * level - (float)0.1 * thirst - (float)0.1 * bladder - (float)0.1 * hunger;
        float sum2 = (float)0.2 * withWho.getHealth() + (float)0.2 * withWho.getStamina() + (float)0.3 * withWho.getExperience() + 5 * withWho.getLevel() - (float)0.1 * withWho.getThirst() - (float)0.1 * withWho.getBladder() - (float)0.1 * withWho.getHunger();
        
        Event e = new Event();
        if (sum1 > sum2){ // we win
            e.setType("WinFight");
            e.setMessage("Congrats!You Win.");
            experience += 200 + 30 * level;
            tambahMoney((float)(100 + (Math.random() * (500 - 100))));
        } else if (sum1 < sum2){ // we lose
            e.setType("LoseFight");
            e.setMessage("Sorry!You Lose.");
            experience += 25 * level;
        }
        // jika naik level
        while(experience >= 100*(level+1)*(level+1)*(level+1)){
            level++;
            maxHealth += 30;
            maxStamina += 10;
        }
        return e;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0194129F-5D6C-13CE-0AE4-A5601DADA176]
    // </editor-fold> 
    public Event train (Date howLong) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.847AFD4C-3B2A-B5F6-9C2C-571586FEBF0A]
    // </editor-fold> 
    public Event entertain (Date howLong) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.20C42E67-996F-166D-45F1-95DC8D50E616]
    // </editor-fold> 
    public Event rest (Date howLong) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8A6C5225-21DB-47E8-1287-18C4BEE4D3B1]
    // </editor-fold> 
    public Event toToilet () {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0929F36F-FC07-E055-0FD8-118CC54E9595]
    // </editor-fold> 
    public Event addConsumable (Consumable what) {
        return null;
    }
}
