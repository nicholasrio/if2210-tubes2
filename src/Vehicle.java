/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William Stefan
 */
import java.awt.Image;
import java.util.*;
import javax.swing.*;

public class Vehicle
{
	private int speed, capacity, id, distance = 100;
	private ArrayList<SaleableObjects> ArrofSaleableObjects = new ArrayList<SaleableObjects>(capacity);
	private Image imgVeh;

	public Vehicle() {
		ImageIcon i = new ImageIcon("veh1.png");
		imgVeh = i.getImage();    
		this.speed = 10;
		this.capacity = 10;
		this.id = 1;
	}

	public void Upgrade() {
		// ganti gambar yang sesuai
		if (this.id < 3) {
			this.id++;
			setImage(this.id, 1);
		}
		else {
			System.out.println("Level sudah maksimal");
		}
		
		// ubah nilai atribut
		this.speed += 2;
		this.capacity += 2;
	}

	public void Downgrade()	{
		// ganti gambar yang sesuai
		if (this.id > 1) {
			this.id--;
			setImage(this.id, 1);
		}
		else {
			System.out.println("Level sudah minimal");
		}
		
		// ubah nilai atribut
		this.speed -= 2;
		this.capacity -= 2;
	}
	
	public int getSpeed() {
		return (this.speed);
	}

	public int getCapacity() {
		return (this.capacity);
	}

	public int getID() {
		return (this.id);
	}

	public Image getImage() {
		return imgVeh;
	}

	public void setImage(int ID, int arah) {
		ImageIcon i;
		if(ID == 1 && arah == 1) {
			i = new ImageIcon("veh1.png");
			imgVeh = i.getImage();
		}
		else if(ID == 2 && arah == 1) {
			i = new ImageIcon("veh2.png");
			imgVeh = i.getImage();
		}
		else if(ID == 3 && arah == 1) {
			i = new ImageIcon("veh3.png");
			imgVeh = i.getImage();
		}
		else if(ID == 1 && arah == 0) {
			i = new ImageIcon("veh1inv.png");
			imgVeh = i.getImage();
		}
		else if(ID == 2 && arah == 0) {
			i = new ImageIcon("veh2inv.png");
			imgVeh = i.getImage();
		}
		else if(ID == 3 && arah == 0) {
			i = new ImageIcon("veh3inv.png");
			imgVeh = i.getImage();
		}
	}
	
	public void printVehicleStat() {
		System.out.println("speed: " + speed);
		System.out.println("capacity: " + capacity);
	}

	public void printVehicleContents() {
		for(int i = 0; i < ArrofSaleableObjects.size(); i++)
		{
			System.out.println("nama: " + ArrofSaleableObjects.get(i).getName());
			System.out.println("harga: " + ArrofSaleableObjects.get(i).getPrice());
			System.out.println("kapasitas: " + ArrofSaleableObjects.get(i).getCapacity());
			System.out.println();
		}
	}

	public void emptyAll() {
		ArrofSaleableObjects.removeAll(ArrofSaleableObjects);
	}

	public int saleAll() {
		int sumMoney = 0;
		for(int i = 0; i < ArrofSaleableObjects.size(); i++)
		{
			sumMoney += ArrofSaleableObjects.get(i).getPrice();
		}
		emptyAll();
		return sumMoney;
	}

	public void addItem(SaleableObjects item) {
		ArrofSaleableObjects.add(item);
	}

/*
	public void go() {
		while(this.distance > 0)
		{
			this.distance -= this.speed;
		}
		System.out.println("Sudah sampai.");
		this.distance = 100;
	}
*/
}