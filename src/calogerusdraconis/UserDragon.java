package calogerusdraconis;

import static java.lang.Thread.sleep; 
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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
        modifyAttribute();
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
    
    private void modifyAttribute() {
        try {
            while (true) {
                sleep(5000);
                //tambah attribute
                health += 30 * level;
                stamina += 1;
                money += 1;
                happiness -= 1;
                thirst += 1;
                hunger += 1;
                
                if (hunger > 75){ // lapar banget
                    happiness -= 5;
                    health -= 10 * level;
                } else if (hunger > 50){
                    happiness -= 3;
                    health -= 5 * level;
                }
                
                if (thirst > 75){ // haus banget
                    happiness -= 3;
                    health -= 10 * level;
                } else if (thirst > 50){
                    happiness -= 5;
                    health -= 5 * level;
                }
                
                if (bladder > 75){ // kebelet banget
                    happiness -= 3;
                    health -= 10 * level;
                } else if (bladder > 50){
                    happiness -= 5;
                    health -= 5 * level;
                }
                
                if (happiness < 50){ // galau banget
                    health -= 10 * level;
                } else if (happiness < 25){
                    health -= 5 * level;
                }
                
                if (hunger < 30){ // kalau baru makan
                    bladder += 4;
                } else if (hunger < 60){
                    bladder += 3;
                } else if (hunger < 90){
                    bladder += 2;
                } else {
                    bladder += 1;
                }
                
                if (thirst < 30){ // kalau baru makan
                    bladder += 4;
                } else if (thirst < 60){
                    bladder += 3;
                } else if (thirst < 90){
                    bladder += 2;
                } else {
                    bladder += 1;
                }
                
            }
        } catch (Exception e) {
            
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CAFBB28D-46E4-68A5-0A2A-82623BC039D0]
    // </editor-fold> 
    public Event fight () {
        Random rand = new Random();
        float ranHealth = (float) Math.ceil(rand.nextGaussian()*(0.2*health)+health);
        float ranStamina = (float) Math.ceil(rand.nextGaussian()*(0.2*stamina)+stamina);
        int ranIexperience = (int) Math.ceil(rand.nextGaussian()*(0.2*iexperience)+iexperience);
        int ranLevel = (int) Math.ceil(rand.nextGaussian()*(0.2*level)+level);
        float ranThirst = (float) Math.ceil(rand.nextGaussian()*(0.2*thirst)+thirst);
        float ranBladder = (float) Math.ceil(rand.nextGaussian()*(0.2*bladder)+bladder);
        float ranHunger = (float) Math.ceil(rand.nextGaussian()*(0.2*hunger)+hunger);
        Dragon withWho = new Dragon("Random Dragon", ranHealth, ranStamina, ranThirst, ranBladder, ranHunger, ranLevel, ranIexperience);
        
        float sum1 = (float)0.2 * health + (float)0.2 * stamina + (float)0.3 * iexperience + 5 * level - (float)0.1 * thirst - (float)0.1 * bladder - (float)0.1 * hunger;
        float sum2 = (float)0.2 * withWho.getHealth() + (float)0.2 * withWho.getStamina() + (float)0.3 * withWho.getIexperience() + 5 * withWho.getLevel() - (float)0.1 * withWho.getThirst() - (float)0.1 * withWho.getBladder() - (float)0.1 * withWho.getHunger();
        
        Event e = new Event();
        if (sum1 > sum2){ // we win
            e.setType("WinFight");
            e.setMessage("Congrats!You Win.");
            iexperience += 400 * withWho.getLevel();
            money += 200 + (Math.random() * (500 - 200));
        } else if (sum1 < sum2){ // we lose
            e.setType("LoseFight");
            e.setMessage("Sorry!You Lose.");
            iexperience += 25 * withWho.getLevel();
        }
        
        // jika naik level
        while(iexperience >= 100*(level+1)*(level+1)*(level+1)){
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

