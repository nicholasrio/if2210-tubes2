package CalogerusDraconis;

import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E6BDD020-1BE0-47FA-DEC1-23321E47E085]
// </editor-fold> 
public class Store {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F02D507C-955C-E473-70F5-66CF2BE0A57E]
    // </editor-fold> 
    private ArrayList<Consumable> fdInventory;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0162CBAA-064B-21DC-586A-5086BCF89195]
    // </editor-fold> 
    public Store () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5BA2A08B-741C-A0B6-B5B5-84388C3CA7EC]
    // </editor-fold> 
    public ArrayList<Consumable> getFdInventory () {
        return fdInventory;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4AC594BD-9B48-8604-6DC2-329B93CE310C]
    // </editor-fold> 
    public void setFdInventory (ArrayList<Consumable> val) {
        this.fdInventory = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.51BC2E63-3236-4A18-2895-B470C93E454E]
    // </editor-fold> 
    public Consumable buy (int arrLoc) {
        return null;
    }

}

