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

package calogerusdraconis;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.95E31C0A-5A00-66DF-D726-38397C93359E]
// </editor-fold> 
public interface View {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.481C5C9C-569A-4681-602E-F139067CDDC3]
    // </editor-fold> 
    public void UpdateScreen (UserDragon drg);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F596E244-8EE3-240E-ADD8-7908C8F36291]
    // </editor-fold> 
    public void UpdateScreen (Store str);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.41CD8BC4-F1D5-8CE9-F183-ED13062BE962]
    // </editor-fold> 
    public void UpdateScreen (UserDragon drg, Dragon enemy);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CAE25CD5-671E-A7E1-88F1-BF1E64D97987]
    // </editor-fold> 
    public void UpdateScreen (UserDragon drg, Event evnt);

}

