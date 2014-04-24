package CalogerusDraconis;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E6A612CE-8541-8B71-8C55-7163C635A90D]
// </editor-fold> 
public class Dragon {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BBC9E929-D7C0-B817-02B3-06F5C3879DB9]
    // </editor-fold> 
    private String name;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.945F8DD4-D2F4-FB15-DDC2-CA52DADDE85C]
    // </editor-fold> 
    private float health;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6E9F01F2-D50D-BD74-70EC-A8F0D4DFCCED]
    // </editor-fold> 
    private float maxHealth;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A9D0A60F-1DF6-E280-56F7-EC7EB9608BC0]
    // </editor-fold> 
    private float stamina;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8E483E98-B30E-A342-6A19-2C19F3CABBE6]
    // </editor-fold> 
    private float maxStamina;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B9490DAF-9CCD-C6A0-576E-D2BE83DFF40A]
    // </editor-fold> 
    private float thirst;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.20D90B97-CE2A-DC4D-0990-EDABCF43383A]
    // </editor-fold> 
    private float bladder;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A10BC95A-5B3B-BF14-8658-07C226D811B5]
    // </editor-fold> 
    private float hunger;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DDDF8E02-DA81-91EC-C68A-C9B0E88BDC91]
    // </editor-fold> 
    private float level;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.82F315C9-04A4-FFB5-6ECC-4B08463CD346]
    // </editor-fold> 
    private float experience;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CF3D2C4D-9EA6-E944-69EA-28C431E61AE3]
    // </editor-fold> 
    public Dragon () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BEDDE777-A659-6921-1DBA-BCF0639DFE8A]
    // </editor-fold> 
    public float getBladder () {
        return bladder;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B4DBDDEE-5173-CF4D-DB98-9B42EECB6B91]
    // </editor-fold> 
    public void setBladder (float val) {
        this.bladder = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8EE0298E-917C-8477-74F8-511A87D2C31A]
    // </editor-fold> 
    public float getExperience () {
        return experience;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4B2A63A4-0A82-82BE-3066-51538767D04E]
    // </editor-fold> 
    public void setExperience (float val) {
        this.experience = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.529852B7-419A-E67A-017E-6DE85DD69437]
    // </editor-fold> 
    public float getHealth () {
        return health;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FDB1F63E-3FD9-0F27-54F8-6E37F045F54E]
    // </editor-fold> 
    public void setHealth (float val) {
        this.health = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.308B626E-D670-075F-FEE4-9914D89D91D3]
    // </editor-fold> 
    public float getHunger () {
        return hunger;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.058E8526-325D-0300-0F8D-E129FAC98B96]
    // </editor-fold> 
    public void setHunger (float val) {
        this.hunger = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5A9FEC81-669F-B128-CFBF-21A73FF46A9F]
    // </editor-fold> 
    public float getLevel () {
        return level;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.273BCA42-554C-7F30-4B62-B88C23F5AAB1]
    // </editor-fold> 
    public void setLevel (float val) {
        this.level = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9D857681-5832-E816-C5AC-6672F39D5B18]
    // </editor-fold> 
    public float getMaxHealth () {
        return maxHealth;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.31197C59-99D4-0C0D-D939-8B07F7F99CF9]
    // </editor-fold> 
    public void setMaxHealth (float val) {
        this.maxHealth = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.042D3737-77D3-43E4-CCA4-ECC74324B670]
    // </editor-fold> 
    public float getMaxStamina () {
        return maxStamina;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.66C70F77-915B-B32E-BB1B-16729C13ED23]
    // </editor-fold> 
    public void setMaxStamina (float val) {
        this.maxStamina = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.992EC7B3-97F0-0967-50E5-DE7D726F0A4A]
    // </editor-fold> 
    public String getName () {
        return name;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.45C43BBC-3BE8-C849-663F-F34289CBDBA9]
    // </editor-fold> 
    public void setName (String val) {
        this.name = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9FEA72BE-7A05-FBB0-8C0C-9EB9462FCD5D]
    // </editor-fold> 
    public float getStamina () {
        return stamina;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A6D4CC63-1002-D25E-3544-5D84C27A08B6]
    // </editor-fold> 
    public void setStamina (float val) {
        this.stamina = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5BD56FB4-7501-9B51-0277-6F178C849755]
    // </editor-fold> 
    public float getThirst () {
        return thirst;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8390DE16-9460-CEB6-53AA-AEE7B04EA64B]
    // </editor-fold> 
    public void setThirst (float val) {
        this.thirst = val;
    }

}

