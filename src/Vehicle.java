/**
 * @author William Stefan
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/** This class is the class used to control the vehicle that will sell the saleable objects to the market */
public class Vehicle implements Drawable {
	/** The vehicle's speed */
	private int speed;

	/** The vehicle's level */
	private int id;

	/** The vehicle's starting position */
	private int startx;

	/** The vehicle's final position */
	private int finalx;
	
	/** The vehicle's position */
	private int x;

	/** 1 when the vehicle is moving and 0 when it is not */
	private int status;

	/** 1 when it is moving to the right and 0 when it is moving to the left */
	private int arah;

	/** The vehicle's storage */
	private Storage vehStorage;

	/** The image container */
	private Image imgVeh;
	
	/** Money from selling objects */
	private int money;

	/** CTOR */
	public Vehicle() {
		ImageIcon i = new ImageIcon("images/veh1.png");
		this.imgVeh = i.getImage();
		this.setImage(1);
		this.speed = 5;
		this.id = 1;
		this.startx = 480;
		this.finalx = 670;
		this.status = 0;
		this.arah = 1;
		this.x = this.startx;
		this.vehStorage = new Storage();
		this.vehStorage.setCapacity(6);
	}

	/** To upgrade the vehicle */
	public void Upgrade() {
		/** Change the image */
		if (this.id < 3) {
			this.id++;
			setImage(this.id);
			/** Change the attribute */
			this.speed += 5;
			this.vehStorage.setCapacity(this.vehStorage.getCapacity() + 2);
		} else {
			System.out.println("Level sudah maksimal");
		}

	}

	/** To downgrade the vehicle */
	public void Downgrade() {
		/** Change the image */
		if (this.id > 1) {
			this.id--;
			setImage(this.id);
			/** Change the attribute */
			this.speed -= 5;
			this.vehStorage.setCapacity(this.vehStorage.getCapacity() - 2);
		} else {
			System.out.println("Level sudah minimal");
		}

	}

	/** Return the ID of the vehicle */
	public int getID() {
		return this.id;
	}
	
	/** Return the status of the vehicle */
	public int getStatus() {
		return this.status;
	}

	/** Set the vehicle's status */
	public void setStatus(int _status) {
		this.status = _status;
	}

	/** Return the vehicle's image */
	public Image getImage() {
		return this.imgVeh;
	}

	/** Set the image */
	public void setImage(int ID) {
		ImageIcon i;
		if (ID == 1) {
			i = new ImageIcon("images/vehicle_level1.png");
			this.imgVeh = i.getImage();
		} else if (ID == 2) {
			i = new ImageIcon("images/vehicle_level2.png");
			this.imgVeh = i.getImage();
		} else if (ID == 3) {
			i = new ImageIcon("images/vehicle_level3.png");
			this.imgVeh = i.getImage();
		}
	}

	/** Show the vehicle's stats */
	public void printVehicleStat() {
		System.out.println("speed: " + speed);
		System.out.println("capacity: " + this.vehStorage.getCapacity());
	}

	/** Show the vehicle's contents */
	public void printVehicleContents() {
		for (int i = 0; i < this.vehStorage.arrStorage.size(); i++) {
			System.out.println("nama: "
					+ this.vehStorage.arrStorage.get(i).getName());
			System.out.println("harga: "
					+ this.vehStorage.arrStorage.get(i).getPrice());
			System.out.println("kapasitas: "
					+ this.vehStorage.arrStorage.get(i).getCapacity());
			System.out.println();
		}
	}

	/** Discard all the vehicle's contents */
	public void emptyAll() {
		this.vehStorage.arrStorage.removeAll(this.vehStorage.arrStorage);
	}

	/** Sell all the vehicle's contents */
	public int sellAll() {
		int sumMoney = 0;
		for (int i = 0; i < this.vehStorage.arrStorage.size(); i++) {
			sumMoney += this.vehStorage.arrStorage.get(i).getPrice();
		}
		emptyAll();
		return sumMoney;
	}

	/** Add an item to the storage 
	 * @throws StorageOverflowException */
	public void addItem(SaleableObject item) throws StorageOverflowException {
		this.vehStorage.add(item);
	}

	@Override
	public void draw(Graphics g) {
		if (arah == 0) {
			g.drawImage(this.imgVeh, getBounds().x + getBounds().width, getBounds().y, -getBounds().width, getBounds().height, null);
		} else {
			g.drawImage(this.imgVeh, getBounds().x, getBounds().y, getBounds().width, getBounds().height, null);
		}
		// draw capacity
		g.setColor(Color.GREEN);
		for (int i = 0; i < 50; i++) {
			if (i >= 50.0 * (double)vehStorage.getCapacity() / (double)vehStorage.maxCapacity()) {
				g.setColor(Color.GRAY);
			}
			g.fillRect(getBounds().x - 10, getBounds().y + getBounds().height - i, 4, 1);
		}
	}

	@Override
	public void update(double timeElapsed) {
		if (this.status == 1) {
			if (this.arah == 1) {
				if (this.x < this.finalx) {
					this.x += this.speed;
				} else {
					this.arah = 0;
					money += this.vehStorage.sellAll();
				}
			} else {
				setImage(this.id);
				if (this.x > this.startx) {
					this.x -= this.speed;
				} else {
					this.arah = 1;
					this.status = 0;
					setImage(this.id);
				}
			}
		}
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, 500, 100, 70);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}