package CalogerusDraconis;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.EC42E277-3873-7B5D-179F-EF0A6AE27F84]
// </editor-fold> 
public class modifyAttribute implements Runnable {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.68B4CEC8-C885-5781-1E78-1D11848CA201]
    // </editor-fold> 
    private float lowerBound;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6CDB04BD-5FC8-9E4B-A0C8-B008CDD76CB2]
    // </editor-fold> 
    private Float upperBound;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9704BB3D-07B3-4322-1FD0-40E146BE5CC7]
    // </editor-fold> 
    private float add;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5471E61E-4612-BB73-9FCD-DFD543659037]
    // </editor-fold> 
    private long milis;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.63359AEB-A3DB-F86F-4418-3F40942E2BB2]
    // </editor-fold> 
    private float attribute;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E4E420C5-C1CB-05A1-52C4-18060C73832E]
    // </editor-fold> 
    public modifyAttribute (float initValue, long milis, long add, Float upperBound, float lowerBound) {
        this.attribute = initValue;
        this.add = add;
        this.milis = milis;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.096FF865-0172-8C79-9958-9DE9C5DCA496]
    // </editor-fold> 
    public void addAttribute (float add) {
        synchronized(this) {
            attribute += add;
            if (upperBound != null && attribute > upperBound) {
                attribute = upperBound;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.046995DF-1FFD-ED0B-A27A-BFA9305E7700]
    // </editor-fold> 
    public float getAttribute () {
        return attribute;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.497BD480-DD3A-B1FB-B5F3-F5F7B2920BF0]
    // </editor-fold> 
    public void setAttribute (float val) {
        this.attribute = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D5EF25E3-B5F8-463B-8E29-0BFA5EDE7145]
    // </editor-fold> 
    public void setLowerBound (float val) {
        this.lowerBound = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.12982699-0C78-87AD-8976-5C5AB8BE5DFB]
    // </editor-fold> 
    public void setUpperBound (float val) {
        this.upperBound = val;
    }
    
    @Override
    public void run() {
        try {
            while(true) {
                sleep(milis);
                addAttribute(add);
                System.out.println("attr " + attribute);
            }
        } catch (InterruptedException ex) {
            //Logger.getLogger(modifyAttribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

