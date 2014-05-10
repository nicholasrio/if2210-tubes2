/*
 * Copyright (C) 2014 Calogerus Draconis Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package CalogerusDraconis;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E6A612CE-8541-8B71-8C55-7163C635A90D]
// </editor-fold> 
public class Dragon {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BBC9E929-D7C0-B817-02B3-06F5C3879DB9]
    // </editor-fold> 
    protected String name;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.945F8DD4-D2F4-FB15-DDC2-CA52DADDE85C]
    // </editor-fold> 
    protected float health;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A9D0A60F-1DF6-E280-56F7-EC7EB9608BC0]
    // </editor-fold> 
    protected float stamina;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B9490DAF-9CCD-C6A0-576E-D2BE83DFF40A]
    // </editor-fold> 
    protected float thirst;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.20D90B97-CE2A-DC4D-0990-EDABCF43383A]
    // </editor-fold> 
    protected float bladder;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A10BC95A-5B3B-BF14-8658-07C226D811B5]
    // </editor-fold> 
    protected float hunger;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DDDF8E02-DA81-91EC-C68A-C9B0E88BDC91]
    // </editor-fold> 
    protected int level;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.82F315C9-04A4-FFB5-6ECC-4B08463CD346]
    // </editor-fold> 
    protected int iexperience;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CF3D2C4D-9EA6-E944-69EA-28C431E61AE3]
    // </editor-fold> 
    public Dragon (String name, float health, float stamina, float thirst, float bladder, float hunger, int level, int experience) {
        this.name = name;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BEDDE777-A659-6921-1DBA-BCF0639DFE8A]
    // </editor-fold> 
    public float getBladder () {
        return bladder;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8EE0298E-917C-8477-74F8-511A87D2C31A]
    // </editor-fold> 
    public int getIexperience () {
        return iexperience;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.529852B7-419A-E67A-017E-6DE85DD69437]
    // </editor-fold> 
    public float getHealth () {
        return health;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.308B626E-D670-075F-FEE4-9914D89D91D3]
    // </editor-fold> 
    public float getHunger () {
        return hunger;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5A9FEC81-669F-B128-CFBF-21A73FF46A9F]
    // </editor-fold> 
    public int getLevel () {
        return level;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.273BCA42-554C-7F30-4B62-B88C23F5AAB1]
    // </editor-fold> 
    public void setLevel (int val) {
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
    // #[regen=yes,regenBody=yes,id=DCE.5BD56FB4-7501-9B51-0277-6F178C849755]
    // </editor-fold> 
    public float getThirst () {
        return thirst;
    }

}

