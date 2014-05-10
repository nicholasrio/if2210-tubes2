package CalogerusDraconis;

import java.util.ArrayList; 
import java.util.Date;

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
    // #[regen=yes,id=DCE.39F10D0D-020E-7824-2E18-D995AC6ED214]
    // </editor-fold> 
    public UserDragon (String name, float health, float maxHealth, float stamina, float maxStamina, float thirst, float bladder, float hunger, int level, int experience, String password, float money, float happiness) {
        super(name, health, maxHealth, stamina, maxStamina, thirst, bladder, hunger, level, experience);
        this.password = password;
        this.money = money;
        this.happiness = happiness;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B112E0C0-12CE-6328-CA63-947031A9E5D4]
    // </editor-fold> 
    public ArrayList<Consumable> getFdInventory () {
        return fdInventory;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DC5D1D42-8A76-00B1-081A-42B70BD35ABE]
    // </editor-fold> 
    public void setFdInventory (ArrayList<Consumable> val) {
        this.fdInventory = val;
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

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CAFBB28D-46E4-68A5-0A2A-82623BC039D0]
    // </editor-fold> 
    public Event fight (Dragon withWho) {
        return null;
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

