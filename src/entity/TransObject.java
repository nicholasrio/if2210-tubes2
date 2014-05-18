/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Gilang
 */
public class TransObject implements Serializable {

	private static final long serialVersionUID = -4630977808690959143L;

	private String fileName;
	private String extension;

	public TransObject(String fileName) {
		this.fileName = fileName;
	}

}
