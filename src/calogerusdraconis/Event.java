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

public class Event {

    private String type;

    private String message;

    public Event () {
    }
	
	/**
	 * Constructor Event
	 * @param type		type message of Event
	 * @param message	content message of Event
	 */
	public Event(String type, String message) {
		this.type = type;
		this.message = message;
	}
	
	/**
	 * Getter Message
	 * @return content message of Event
	 */
    public String getMessage () {
        return message;
    }

	/**
	 * Setter Message
	 * @param val new content message of Event
	 */
    public void setMessage (String val) {
        this.message = val;
    }

	/**
	 * Getter Type
	 * @return type message of Event
	 */
    public String getType () {
        return type;
    }

	/**
	 * Setter Type
	 * @param val new type message of Event
	 */
    public void setType (String val) {
        this.type = val;
    }

}

