package character;

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
    public Item(){
        this.id = 0;
        this.name = new String();
        this.setCost(0);
        this.setStrAgiInt(0,0,0);
        this.setCurrentHealthMana(0,0);
        this.setMaxHealthMana(0,0);
    }
    
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public int getCurrentHealthEff() {
        return currentHealthEff;
    }

    public void setCurrentHealthEff(int currentHealthEff) {
        this.currentHealthEff = currentHealthEff;
    }

    public int getCurrentManaEff() {
        return currentManaEff;
    }

    public void setCurrentManaEff(int currentManaEff) {
        this.currentManaEff = currentManaEff;
    }

    public int getMaxHealthEff() {
        return maxHealthEff;
    }

    public void setMaxHealthEff(int maxHealthEff) {
        this.maxHealthEff = maxHealthEff;
    }

    public int getMaxManaEff() {
        return maxManaEff;
    }

    public void setMaxManaEff(int maxManaEff) {
        this.maxManaEff = maxManaEff;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getStrEff() {
        return strEff;
    }

    public void setStrEff(int strEff) {
        this.strEff = strEff;
    }

    public int getAgiEff() {
        return agiEff;
    }

    public void setAgiEff(int agiEff) {
        this.agiEff = agiEff;
    }

    public int getIntEff() {
        return intEff;
    }

    public void setIntEff(int intEff) {
        this.intEff = intEff;
    }

    public int getManaEff() {
        return currentManaEff;
    }

    public void setManaEff(int manaEff) {
        this.currentManaEff = manaEff;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setStrAgiInt(int str,int agi,int inte){
        this.setStrEff(str);
        this.setAgiEff(agi);
        this.setIntEff(inte);
    }
    
    public void setCurrentHealthMana(int health,int mana){
        this.setCurrentHealthEff(health);
        this.setCurrentManaEff(mana);
    }
    
    public void setMaxHealthMana(int health,int mana){
        this.setMaxHealthEff(health);
        this.setMaxManaEff(mana);
    }
    
    @Override
    public Item clone() throws CloneNotSupportedException{
        return (Item) super.clone();
    }
}