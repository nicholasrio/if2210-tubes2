/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package job;

import File.*;
import java.util.*;

/**
 *
 * @author adwisatya
 */
public class Job {

	private String name;
	private List<File> file;
	private static int maximum = 10;
	private int nElmt;

	public Job(String name) {
		this.name = name;
		nElmt = 0;
	}

	public void addFile(File file) {

	}

	public boolean isFull() {
		return nElmt == maximum;
	}

	public void deleteFile(File file) {

	}
}
