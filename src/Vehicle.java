/**
g * @author William Stefan
 */
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Vehicle implements Drawable {
	private int speed;
	private int capacity;
	private int id;
	private int startx;
	private int finalx;
	private int status;
	private int arah;
	private int x;	
	private Storage vehStorage;
	private static Image imgVeh;

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
	
	public int getStatus() {
		return this.status;
	}
	
	public void setStatus(int _status) {
		this.status = _status;
	}

	public Image getImage() {
		return Vehicle.imgVeh;
	}
	
	public void setImage(int ID, int arah) {
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
	
	public void printVehicleStat() {
		System.out.println("speed: " + speed);
		System.out.println("capacity: " + capacity);
	}

	public void printVehicleContents() {
		for(int i = 0; i < this.vehStorage.arrStorage.size(); i++)
		{
			System.out.println("nama: " + this.vehStorage.arrStorage.get(i).getName());
			System.out.println("harga: " + this.vehStorage.arrStorage.get(i).getPrice());
			System.out.println("kapasitas: " + this.vehStorage.arrStorage.get(i).getCapacity());
			System.out.println();
		}
	}

	public void emptyAll() {
		this.vehStorage.arrStorage.removeAll(this.vehStorage.arrStorage);
	}

	public int sellAll() {
		int sumMoney = 0;
		for(int i = 0; i < this.vehStorage.arrStorage.size(); i++)
		{
			sumMoney += this.vehStorage.arrStorage.get(i).getPrice();
		}
		emptyAll();
		return sumMoney;
	}
	
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