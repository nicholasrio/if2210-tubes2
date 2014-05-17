/**
g * @author William Stefan
 */
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Vehicle implements Drawable {
	private int speed; /** The vehicle's speed */
	private int capacity; /** he vehicle's capacity */
	private int id; /** THe vehicle's level */
	private int startx; /** The vehicle's starting position */
	private int finalx; /** The vehicle's final position */
	private int status; /** 1 when the vehicle is moving and 0 when it is not */
	private int arah; /** 1 when it is moving to the right and 0 when it is moving to the left */
	private int x; /** The position of the vehicle */	
	private Storage vehStorage; /** The vehicle's storage */
	private static Image imgVeh; /** The image container */

	/** CTOR */
	public Vehicle() {
		ImageIcon i = new ImageIcon("images/veh1.png");
		Vehicle.imgVeh = i.getImage();
		this.setImage(1, 1);
		this.speed = 5;
		this.capacity = 6;
		this.id = 1;
		this.startx = 600;
		this.finalx = 700;
		this.status = 0;
		this.arah = 1;
		this.x = this.startx;
	}

	/** To upgrade the vehicle */
	public void Upgrade() {
		// ganti gambar yang sesuai
		if (this.id < 3) {
			this.id++;
			setImage(this.id, 1);
			// ubah nilai atribut
			this.speed += 5;
			this.capacity += 2;
		}
		else {
			System.out.println("Level sudah maksimal");
		}

	}

	/** To downgrade the vehicle */
	public void Downgrade()	{
		// ganti gambar yang sesuai
		if (this.id > 1) {
			this.id--;
			setImage(this.id, 1);
			// ubah nilai atribut
			this.speed -= 5;
			this.capacity -= 2;
		}
		else {
			System.out.println("Level sudah minimal");
		}

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
		return Vehicle.imgVeh;
	}

	/** Set the image */
	public void setImage(int ID) {
		ImageIcon i;
		if(ID == 1) {
			i = new ImageIcon("images/vehicle_level1.png");
			Vehicle.imgVeh = i.getImage();
		}
		else if(ID == 2) {
			i = new ImageIcon("images/vehicle_level2.png");
			Vehicle.imgVeh = i.getImage();
		}
		else if(ID == 3) {
			i = new ImageIcon("images/vehicle_level3.png");
			Vehicle.imgVeh = i.getImage();
		}
	}

	/** Show the vehicle's stats */
	public void printVehicleStat() {
		System.out.println("speed: " + speed);
		System.out.println("capacity: " + capacity);
	}

	/** Show the vehicle's contents */
	public void printVehicleContents() {
		for(int i = 0; i < this.vehStorage.arrStorage.size(); i++)
		{
			System.out.println("nama: " + this.vehStorage.arrStorage.get(i).getName());
			System.out.println("harga: " + this.vehStorage.arrStorage.get(i).getPrice());
			System.out.println("kapasitas: " + this.vehStorage.arrStorage.get(i).getCapacity());
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
		for(int i = 0; i < this.vehStorage.arrStorage.size(); i++)
		{
			sumMoney += this.vehStorage.arrStorage.get(i).getPrice();
		}
		emptyAll();
		return sumMoney;
	}

	/** Add an item to the storage */
	public void addItem(SaleableObject item) {
		this.vehStorage.arrStorage.add(item);
	}

	@Override
	public void draw(Graphics g) {
		if (arah == 0) {
			//			AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
			//			tx.translate(-Vehicle.imgVeh.getWidth(null), 0);
			//			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			//			g.drawImage(op.filter(Vehicle.imgVeh, null), x, 50, 50, 50, null);

			g.drawImage(Vehicle.imgVeh, x + 50, 50, -50, 50, null);
		}
		else {
			g.drawImage(Vehicle.imgVeh, x, 50, 50, 50, null);
		}
	}

	@Override
	public void update(double timeElapsed) {
		System.out.println("status: " + this.status);
		System.out.println("arah: " + this.arah);
		if(this.status == 1) {
			if(this.arah == 1) {
				if(this.x < this.finalx) {
					this.x += this.speed;
				}
				else {
					this.arah = 0;
				}
			}
			else {
				setImage(this.id, 0);
				if(this.x > this.startx) {
					this.x -= this.speed;
				}
				else {
					this.arah = 1;
					this.status = 0;
					setImage(this.id, 1);
				}
			}
		}
	}
}