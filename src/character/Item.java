package character;

/**
 * class Item implements Cloneable
 * @author yafithekid
 */
public class Item implements Cloneable{
    private static int nItem = 0;
    
    private int id;
    private String name;
    private int cost;
    private int strEff;
    private int agiEff;
    private int intEff;
    private int currentHealthEff;
    private int currentManaEff;
    private int maxHealthEff;
    private int maxManaEff;
    private String description; 
    private String imagePath;
    
    /**
     * constructor
     * @param item 
     */
    public Item(Item item){
        Item i = new Item();
        i.id = item.id;
        i.name = item.name;
        i.strEff = item.strEff;
        i.agiEff = item.agiEff;
        i.intEff = item.intEff;
        i.currentHealthEff = item.currentHealthEff;
        i.currentManaEff = item.currentManaEff;
        i.maxHealthEff = item.maxHealthEff;
        i.maxManaEff = item.maxManaEff;
        i.description = item.description;
        i.imagePath = item.imagePath;
    }
    /**
     * constructor
     */
    public Item(){
        this.id = 0;
        this.name = new String();
        this.setCost(0);
        this.setStrAgiInt(0,0,0);
        this.setCurrentHealthMana(0,0);
        this.setMaxHealthMana(0,0);
    }
    
    /**
     * method for get image path
     * @return 
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * method for set image path
     * @param imagePath 
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    /**
     * method get current health
     * @return 
     */
    
    public int getCurrentHealthEff() {
        return currentHealthEff;
    }

    /**
     * method set current health
     * @param currentHealthEff 
     */
    public void setCurrentHealthEff(int currentHealthEff) {
        this.currentHealthEff = currentHealthEff;
    }

    /**
     * method get current mana
     * @return 
     */
    public int getCurrentManaEff() {
        return currentManaEff;
    }

    /**
     * method set current mana
     * @param currentManaEff 
     */
    public void setCurrentManaEff(int currentManaEff) {
        this.currentManaEff = currentManaEff;
    }

    /**
     * method get max health
     * @return 
     */
    public int getMaxHealthEff() {
        return maxHealthEff;
    }

    /**
     * method set max health
     * @param maxHealthEff 
     */
    public void setMaxHealthEff(int maxHealthEff) {
        this.maxHealthEff = maxHealthEff;
    }

    /**
     * method get max mana
     * @return 
     */
    public int getMaxManaEff() {
        return maxManaEff;
    }

    /**
     * methid get max mana
     * @param maxManaEff 
     */
    public void setMaxManaEff(int maxManaEff) {
        this.maxManaEff = maxManaEff;
    }


    /**
     * method get id
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * method set id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * method get name
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * method set name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method get cost
     * @return 
     */
    public int getCost() {
        return cost;
    }

    /**
     * method set cost
     * @param cost 
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * method get str
     * @return 
     */
    public int getStrEff() {
        return strEff;
    }

    /**
     * method set str
     * @param strEff 
     */
    public void setStrEff(int strEff) {
        this.strEff = strEff;
    }

    /**
     * method get agi
     * @return 
     */
    public int getAgiEff() {
        return agiEff;
    }

    /**
     * method set agi
     * @param agiEff 
     */
    public void setAgiEff(int agiEff) {
        this.agiEff = agiEff;
    }

    /**
     * method get int
     * @return 
     */
    public int getIntEff() {
        return intEff;
    }

    /**
     * method set int
     * @param intEff 
     */
    public void setIntEff(int intEff) {
        this.intEff = intEff;
    }

    /**
     * method get mana
     * @return 
     */
    public int getManaEff() {
        return currentManaEff;
    }

    /**
     * method set mana
     * @param manaEff 
     */
    public void setManaEff(int manaEff) {
        this.currentManaEff = manaEff;
    }

    /**
     * method get description
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * method set description
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * method set str agi and int
     * @param str
     * @param agi
     * @param inte 
     */
    public void setStrAgiInt(int str,int agi,int inte){
        this.setStrEff(str);
        this.setAgiEff(agi);
        this.setIntEff(inte);
    }
    
    /**
     * method set current health mana
     * @param health
     * @param mana 
     */
    public void setCurrentHealthMana(int health,int mana){
        this.setCurrentHealthEff(health);
        this.setCurrentManaEff(mana);
    }
    
    /**
     * method set max for health and mana
     * @param health
     * @param mana 
     */
    public void setMaxHealthMana(int health,int mana){
        this.setMaxHealthEff(health);
        this.setMaxManaEff(mana);
    }
    
    @Override
    public Item clone() throws CloneNotSupportedException{
        return (Item) super.clone();
    }
}