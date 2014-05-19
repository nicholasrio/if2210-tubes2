/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
import java.util.*;
public class Field {
	public Unit U[][];
	public int Q[];
	private int NbUnit;
	private int Row;
	private int Column;
	private int Stock;
	private int Turn;
	private boolean Type;
	public int HP;
	
	private boolean FieldType; //true u/ tumbuhan, false u/ manusia
	private int Xset[];
	private int Yset[];
	private int NBAttack;
	private int WeatherType; // tipe weather berupa penomoran dari 1..n (nomor terurut dari method)
	private int NBWeatherType;
	
	private int HPOld;
    private int HPNew[];
    private double Percentage;
	
	public Field(boolean b) {
		Xset = new int [10];
		Yset = new int [10];
		NBAttack = 0;
		NBWeatherType = 7;
		
		HPNew = new int [10];
	
		NbUnit = 32;
		Row = 6;
		Column = 8;
		U = new Unit[Row][Column];
		for(int i=0; i<Row; i++) {
			for(int j=0; j<Column; j++) {
				U[i][j] = new Unit();
			}
		}
		for(int i=Row-2; i<Row; i++) {
			for(int j=0; j<Column; j++) {
				U[i][j].SetEmpty();
			}
		}
		Q = new int[Column];
		for(int i=0; i<Column; i++) {
			Q[i] = 4;
		}
		Stock = 0;
		Turn = 3;
		while(IsFormed(0)) {}
		while(FormationExist()) {
			DeleteAllFormation();
		}
		for(int i=Row-2; i<Row; i++) {
			for(int j=0; j<Column; j++) {
				U[i][j].SetEmpty();
			}
		}
		for(int i=0; i<Column; i++) {
			Q[i] = 4;
		}
		Type = b;
		HP = 100;
		Stock = 0;
	}
	public int GetNBAttack() {
		return NBAttack;
	}
        public int GetStock() {
		return Stock;
	}
	public int[] GetXset() {
		return Xset;
	}
	public int[] GetYset() {
		return Yset;
	}
	public int GetTurn() {
		return Turn;
	}
	public void SetTurn(int i) {
		Turn = i;
	}
	public void Print(int turn) {
		int extend = 4;
		if(Type) {			
			for(int i=0; i<Row; i++) {
				for(int j=0; j<Column; j++) {
					U[i][j].Print(j+1, Row-i, Type);
				}
			}
			System.out.println(String.format("%c[%d;%df", 0x1B, 7, extend) + "HP    : " + HP);
			if(turn == 0) {
				System.out.println(String.format("%c[%d;%df", 0x1B, 10, extend) + "Turn  : " + Turn);
			}
			System.out.println(String.format("%c[%d;%df", 0x1B, 11, extend) + "Stock : " + Stock);
			for(int i=0; i<8; i++) {
				System.out.println(Q[i]);
			}
		}
		else {
			extend = 128;
			for(int i=0; i<Row; i++) {
				for(int j=0; j<Column; j++) {
					U[i][j].Print(j+1, i+1, Type);
				}
			}
			System.out.println(String.format("%c[%d;%df", 0x1B, 7, extend) + "HP    : " + HP);
			if(turn == 1) {
				System.out.println(String.format("%c[%d;%df", 0x1B, 10, extend) + "Turn  : " + Turn);
			}
			System.out.println(String.format("%c[%d;%df", 0x1B, 11, extend) + "Stock : " + Stock);
		}
	}
	public void Delete(int x, int y) {
		if(U[y][x].GetStatus() == 0)  {
			System.out.println("Tidak ada unit yang bisa dihapus");
		}
		else if(U[y][x].GetStatus() == 2) {
			System.out.println("Unit sedang membentuk formasi");
		}
		else if(Q[x] != 0 && y < Q[x] && U[y][x].GetStatus() != 2) {
			for(int i=y; i<Row-1; i++) {
				U[i][x] = U[i+1][x].Copy();
			}
			Q[x]--;
			Stock++;
			U[5][x].SetEmpty();
		}
		else {
			System.out.println("Out of range");
		}
			
	}
	public void Move(int x1, int x2) {
		if(Q[x1] != 0 && Q[x2] != Row && x1 != x2 && U[Q[x1]-1][x1].GetStatus() == 1) {
			U[Q[x2]][x2] = U[Q[x1]-1][x1].Copy();
			U[Q[x1]-1][x1].SetEmpty();
			Q[x2]++;
			Q[x1]--;
			Turn--;
		}
		else {
			System.out.println("Tidak ada unit yang bisa dipindah");
		}
	}
	public void Call() {
		if(Stock > 0) {
			Random rand = new Random();
			for(int i=0; i<Stock; i++) {
				int x;
				do {
					x = rand.nextInt(8);
				} while(Q[x] == 6);
				U[Q[x]][x] = new Unit();
				Q[x]++;
			}
			Stock = 0;
			Turn--;
		}
	}
	public boolean Formation() {
		boolean F =	IsFormed(1);
		return F;
	}
	public boolean IsFormed(int q){
		// bagian indam
		// attack checking
		int i, j;
		int nform = 0;
		for (i=0; i<Row-2; i++){
			for (j=0; j<Column; j++){
				boolean scl = U[i][j].GetColour() == U[i+1][j].GetColour() &&
						   U[i+1][j].GetColour() == U[i+2][j].GetColour();
				boolean vsta = U[i][j].GetStatus() == 1 && U[i+1][j].GetStatus() == 1 &&
							U[i+2][j].GetStatus() == 1;
				if (scl && vsta){
					nform++;
					for (int k=i; k<=i+2; k++)
						U[k][j].SetStatus(4);
				}
			}
		}
		// defense checking
		for (i=0; i<Row; i++){
			j = 0;
			do {
				while (U[i][j].GetStatus()!=1 && U[i][j].GetStatus()!=4 && j < Column-2)
					j++;
				int k = j+1;
				while ((U[i][k].GetStatus()==1 || U[i][k].GetStatus()==4) && U[i][j].GetColour() == U[i][k].GetColour() && k < Column-1)
					k++;
				if (k == Column-1 && U[i][j].GetColour() == U[i][k].GetColour() && (U[i][k].GetStatus()==1 || U[i][k].GetStatus()==4))
					k++;
				if (k > j+2){
					nform++;
					for (int l=j; l<k; l++){
						if (U[i][l].GetStatus() == 4)
							U[i][l].SetStatus(5);
						else
							U[i][l].SetStatus(6);
					}
				}
				j = k;
			} while (j < Column-2);
		}
		if (nform > 0){
			Turn += nform - 1;
			Intersection();
			// Moving defense
			for (i=0; i<Row; i++){
				j = 0;
				do{
					if (U[i][j].GetStatus() == 6){
						int l = j;
						while (U[i][l].GetStatus()==6 && l<Column-1){
							U[i][l].SetStatus(3);
							U[i][l].SetHP(7);
							l++;
						}
						if (l==Column-1 && U[i][l].GetStatus() == 6){
							U[i][l].SetStatus(3);
							U[i][l].SetHP(7);
							l++;
						}
						MoveDefend(i, j, l-j);
						j = l+1;
					} else
						j++;
				} while (j<Column);
			}
			if(q == 1) {
				DefenseStacking();
			}
			// Moving attack
			for (i=0; i<Row-2; i++){
				for (j=0; j<Column; j++){
					if (U[i][j].GetStatus() == 4){
						for (int l=0; l<3; l++){
							U[i+l][j].SetStatus(2);
							U[i+l][j].SetHP(20);
							U[i+l][j].SetTurn(2);
						}
						MoveAttack(i, j);
					}
				}
			}
			if(q == 1) {
				AttackStacking();
			}	
		}

		return (nform > 0);
	}
	public void Intersection() {
		for (int i=0; i<Row; i++){
			for (int j=0; j<Column; j++){
				if (U[i][j].GetStatus() == 5){
					int k = i+1;
					while (U[k][j].GetStatus() == 5 && k<Row-1)
						k++;
					int l = k;
					while (U[l][j].GetStatus() != 0 && l<Row-1)
						l++;
					do {
						U[l][j] = U[l-1][j].Copy();
						l--;
					} while (l >= k);
					U[k][j].SetStatus(4);
					U[i][j].SetStatus(6);
					Q[j]++;
					Stock--;
				}
			}
		}
	}
	public void AttackStacking() {
		for(int i = 0 ; i < 8 ; i++) {
			if(U[0][i].GetStatus() == 2 && U[3][i].GetStatus() == 2 && U[0][i].GetColour() == U[3][i].GetColour()) {
				U[0][i].SetHP(U[0][i].GetHP() + U[3][i].GetHP());
				U[1][i].SetHP(U[1][i].GetHP() + U[4][i].GetHP());
				U[2][i].SetHP(U[2][i].GetHP() + U[5][i].GetHP());
				U[3][i].SetStatus(1);
				U[4][i].SetStatus(1);
				U[5][i].SetStatus(1);
				Delete(i, 3);
				Delete(i, 3);
				Delete(i, 3);
				Stock = Stock + 3;
			}
		}
	}
	public void DefenseStacking() {
		while(!AllDefenseStacked()){
			for(int i = 0 ; i < 8 ; i++) {
				for(int j = 0 ; j < 5 ; j++) {
					if(U[j][i].GetStatus() == 3 && U[j+1][i].GetStatus() == 3) {
						if(U[j][i].GetHP() + U[j+1][i].GetHP() > 14) {
							U[j+1][i].SetHP(U[j][i].GetHP() + U[j+1][i].GetHP() - 14);
							U[j][i].SetHP(14);
							System.out.println("boom");
						}
						else {
							U[j][i].SetHP(U[j][i].GetHP() + U[j+1][i].GetHP());
							Delete(i, j+1);
							System.out.println("bam");
						}				
					}
				}
			}
		}
	}
	public boolean AllDefenseStacked() {
		boolean found = true;
		for(int i = 0 ; i < 8 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				if((U[j][i].GetStatus() == 3 && U[j+1][i].GetStatus() == 3) && (U[j][i].GetHP() + U[j+1][i].GetHP() <= 14 || U[j][i].GetHP() < U[j+1][i].GetHP())) {
					found = false;
				}
			}
		}
		return found;
	}
	public void MoveAttack(int x, int y) {
		int used = 0;
		int i = 0;
		while (i < x){
			if (U[i][y].GetStatus() == 2 || U[i][y].GetStatus() == 3)
				used++;
			i++;
		}
		if(used == 0){
			if(x == 1){
				Unit temp1 = U[0][y].Copy();
				U[0][y] = U[1][y].Copy();
				U[1][y] = U[2][y].Copy();
				U[2][y] = U[3][y].Copy();
				U[3][y] = temp1;
			}
			else if(x == 2){
				Unit temp1 = U[0][y].Copy();
				Unit temp2 = U[1][y].Copy();
				U[0][y] = U[2][y].Copy();
				U[1][y] = U[3][y].Copy();
				U[2][y] = U[4][y].Copy();
				U[3][y] = temp1;
				U[4][y] = temp2;
			}
			else if(x == 3){
				Unit temp1 = U[0][y].Copy();
				Unit temp2 = U[1][y].Copy();
				Unit temp3 = U[2][y].Copy();
				U[0][y] = U[3][y].Copy();
				U[1][y] = U[4][y].Copy();
				U[2][y] = U[5][y].Copy();
				U[3][y] = temp1;
				U[4][y] = temp2;
				U[5][y] = temp3;
			}
		}
		if(used == 1){
			if(x == 2){
				Unit temp1 = U[1][y].Copy();
				U[1][y] = U[2][y].Copy();
				U[2][y] = U[3][y].Copy();
				U[3][y] = U[4][y].Copy();
				U[4][y] = temp1;
			}
			else if(x == 3){
				Unit temp1 = U[1][y].Copy();
				Unit temp2 = U[2][y].Copy();
				U[1][y] = U[3][y].Copy();
				U[2][y] = U[4][y].Copy();
				U[3][y] = U[5][y].Copy();
				U[4][y] = temp1;
				U[5][y] = temp2;
			}
		}
		if(used == 2){
			if(x == 3){
				Unit temp1 = U[2][y].Copy();
				U[2][y] = U[3][y].Copy();
				U[3][y] = U[4][y].Copy();
				U[4][y] = U[5][y].Copy();
				U[5][y] = temp1;
			}
		}
	}
	public void MoveDefend(int x, int y, int length) {
		for(int i = 0 ; i < length ; i++){
			if(x == 1){
				Unit temp1 = U[0][y+i].Copy();
				U[0][y+i] = U[1][y+i].Copy();
				U[1][y+i] = temp1;
			}
			else if(x == 2){
				Unit temp1 = U[0][y+i].Copy();
				Unit temp2 = U[1][y+i].Copy();
				U[0][y+i] = U[2][y+i].Copy();
				U[1][y+i] = temp1;
				U[2][y+i] = temp2;
			}
			else if(x == 3){
				Unit temp1 = U[0][y+i].Copy();
				Unit temp2 = U[1][y+i].Copy();
				Unit temp3 = U[2][y+i].Copy();
				U[0][y+i] = U[3][y+i].Copy();
				U[1][y+i] = temp1;
				U[2][y+i] = temp2;
				U[3][y+i] = temp3;
			}
			else if(x == 4){
				Unit temp1 = U[0][y+i].Copy();
				Unit temp2 = U[1][y+i].Copy();
				Unit temp3 = U[2][y+i].Copy();
				Unit temp4 = U[3][y+i].Copy();
				U[0][y+i] = U[4][y+i].Copy();
				U[1][y+i] = temp1;
				U[2][y+i] = temp2;
				U[3][y+i] = temp3;
				U[4][y+i] = temp4;
			}
			else if(x == 5){
				Unit temp1 = U[0][y+i].Copy();
				Unit temp2 = U[1][y+i].Copy();
				Unit temp3 = U[2][y+i].Copy();
				Unit temp4 = U[3][y+i].Copy();
				Unit temp5 = U[4][y+i].Copy();
				U[0][y+i] = U[5][y+i].Copy();
				U[1][y+i] = temp1;
				U[2][y+i] = temp2;
				U[3][y+i] = temp3;
				U[4][y+i] = temp4;
				U[5][y+i] = temp5;
			}
		}
	}
	public void DeleteAllFormation() {
		for(int i=0; i<Row; i++) {
			for(int j=0; j<Column; j++) {
				if(U[i][j].GetStatus() != 0 && U[i][j].GetStatus() != 1) {
					U[i][j] = new Unit();
				}
			}
		}
		while(IsFormed(0)) {}
	}
	public boolean FormationExist() {
		boolean found = false; 
		int i=0;
		int j=0;
		while(i < Row && !found) {
			j = 0;
			while(j < Column && !found) {
				if(U[i][j].GetStatus() != 0 && U[i][j].GetStatus() != 1) {
					found = true;
				}
				j++;
			}
			i++;
		}
		return found;
	}
	/*    
	public void Attack(int x) 
        {
        int y,damage;
	    boolean found;
	    x=1;
	    found = false;
            while(!found && x < 6)
            {
                if (U[x][y].GetStatus() == 2)
                {
                    damage = U[x][y].GetHP();
                    for( int i=1; i<= 3; i++){
                        Delete(x,y);
                    }
                    if (FieldType)
                        Attacked(x,F2,damage);
                    else 
                        Attacked(x,F1,damage;
                    found = true;
                }
                else
                    x++;
            }
            // bagian jonathan
    }
    
    
    public void Attacked(int y,Field F , int damage)
    {
        int i = 1;
        while (damage < 0 )
        {
            damage = damage - F.U[1][y].GetHP();
            if (F.U[1][y].GetStatus() == 1)
            {
                F.Delete(1,y);}
                else {if (F.U[1][y].GetStatus() == 2){
                        if (damage > 0){F.Delete(1,y);}
                            else{F.U[1][y].SetHP(-damage)};
                    }else{
                        if (damage > 0)
                            {for(int i =1;i<=3;i++){F.Delete(1,y);}}
                            else{
                                for(int i=1; i<=3;i++){F.U[i][y].SetHP(-damage);}
                                }
                        }
            }
        }
    }*/
	public void SearchAttack()
    // mengisi array AttUSet dengan unit berstatus attack
    {
        // bersihkan semua Xset, Yset, NBAttack
        for (int i=0; i<Xset.length; i++)
            Xset[i] = 0;
        for (int i=0; i<Yset.length; i++)
            Yset[i] = 0;
        NBAttack = 0;
        
        // Cari semua unit berstatus attack, cukup cari unit pertama yg attack
        // Simpen koordinat ke Xset & Yset
        for (int i=0; i<Column; i++)
        {
            int j=0;
            while (j<Row)
            {
                if (U[j][i].GetStatus()==2)
                {
                    Xset[NBAttack] = i;
                    Yset[NBAttack] = j;
                    NBAttack++;
                    j = j+3;
                }
                else
                    j++;
            }
        }
    }
     
    // Method Weather
        
    // NGERUGIIN kedua pihak
    public void Kemarau()
    // ngurangin hp tumbuhan 10%, nambahin turn unit charging manusia 1, gerah ceritanya
    {
        int j =0;
        for (int idx=0; idx<Xset.length; idx++)
        {
            int x = Xset[idx];
            int y = Yset[idx];
            if (U[x][y].GetStatus()!=0)
            {
                for (int i=y; i<=y+3; i++)
                {
                    if(U[x][i].GetStatus()==2)
                    {
                        if(FieldType)  // jika field tumbuhan
                        {
                            HPOld = U[x][i].GetHP();
                            Percentage = -0.1;
                            double temp = (double) HPOld * Percentage;
                            HPNew[j] = HPOld + (int)temp;
                            U[x][i].SetHP(HPNew[j]);
                        }
                        else    // jika field manusia
                            U[x][i].SetTurn(U[x][i].GetTurn()+1);
                    }
                }
            }
            j++;
        }
    }
    
    public void Gempa()
    // ngilangin semua formasi
    {
        for(int y=1; y<=6;y++)
        {
            for(int x=1; x<=8; x++)
            {
                //F1.U[x][y].SetStatus(1);
                //F2.U[x][y].SetStatus(1);
                U[x][y].SetStatus(1);
            }
        }
    }
    
    // NGUNTUNGIN kedua pihak

    // ABSTRAK
    public void Badai()
    // ngacak posisi unit idle  // move sebanyak 5 kali
    {
        Random rand = new Random();
        int temp;
        if (NbUnit<5)
            temp = NbUnit;
        else
            temp = 5;
        
        int i =0;
        while (i<temp)
        {
            int x1 = rand.nextInt(8);
            int x2 = rand.nextInt(8);
            if ((U[x1][Q[x1]].GetStatus()==1) && Q[x2]<6)
            {
                Move(x1,x2);
                i++;
            }
        }
    }

    // NGUNTUNGIN manusia
    
    // NGERUGIIN manusia
    public void HujanAsam()
    // ngurangin hp unit manusia -20%
    {
        int j =0;
        for (int idx=0; idx<Xset.length; idx++)
        {
            int x = Xset[idx];
            int y = Yset[idx];
            if (U[x][y].GetStatus()!=0)
            {
                for (int i=y; i<=y+3; i++)
                {
                    if(U[x][i].GetStatus()==2)
                    {
                        if(!FieldType)  // jika field tumbuhan
                        {
                            HPOld = U[x][i].GetHP();
                            Percentage = -0.2;
                            double temp = (double) HPOld * Percentage;
                            HPNew[j] = HPOld + (int)temp;
                            U[x][i].SetHP(HPNew[j]);
                        }
                    }
                }
            }
            j++;
        }
    }

    public void BadaiUAS()
    // manusia ga bisa call
    {
        System.out.println("Tumbuhan: Sukurin LO pada UAS ga ada bantuan");
        System.out.println("Manusia: SIAL!!!!!!!!");
    }
    
    // NGUNTUNGIN tumbuhan
    public void Sunny()
    // nambahin HP unit charge +20%, ceritanya lewat fotosintesis
    {
        int j =0;
        for (int idx=0; idx<Xset.length; idx++)
        {
            int x = Xset[idx];
            int y = Yset[idx];
            if (U[x][y].GetStatus()!=0)
            {
                for (int i=y; i<=y+3; i++)
                {
                    if(U[x][i].GetStatus()==2)
                    {
                        if(FieldType)  // jika field tumbuhan
                        {
                            HPOld = U[x][i].GetHP();
                            Percentage = 0.2;
                            double temp = (double) HPOld * Percentage;
                            HPNew[j] = HPOld + (int)temp;
                            U[x][i].SetHP(HPNew[j]);
                        }
                    }
                }
            }
            j++;
        }
    }

    // NGERUGIIN tumbuhan
    public void WildFire()
    // ngurangin HP unit charge -10%, delete 3 idle
    {
        int j =0;
        for (int idx=0; idx<Xset.length; idx++)
        {
            int x = Xset[idx];
            int y = Yset[idx];
            if (U[x][y].GetStatus()!=0)
            {
                for (int i=y; i<=y+3; i++)
                {
                    if(U[x][i].GetStatus()==2)
                    {
                        if(FieldType)  // jika field tumbuhan
                        {
                            HPOld = U[x][i].GetHP();
                            Percentage = -0.1;
                            double temp = (double) HPOld * Percentage;
                            HPNew[j] = HPOld + (int)temp;
                            U[x][i].SetHP(HPNew[j]);
                        }
                        else    // jika field manusia
                            U[x][i].SetTurn(U[x][i].GetTurn()+1);
                    }
                }
            }
            j++;
        }
        
        Random rand = new Random();
        int temp;
        if (NbUnit<3)
            temp = NbUnit;
        else
            temp = 3;
        
        int i =0;
        while (i<temp)
        {
            int x = rand.nextInt(8);
            int y = rand.nextInt(6);
            if (U[x][y].GetStatus()==1)
            {
                Delete(x,y);
                i++;   
            }
        }
    }

    // penyatu
    public void WeatherRandom()
    // Pengumpul semua method weather dan merandom apa yang akan dikeluarkan
    {
        Random rand = new Random();
        WeatherType = rand.nextInt(NBWeatherType) + 1;
        if (WeatherType==1)
        {
            Kemarau(); 
        }
        else if (WeatherType==2)
        {
            Gempa(); 
        }
        else if (WeatherType==3)
        {
            Badai();
        }
        else if (WeatherType==4)
        {
            HujanAsam();
        }
        else if (WeatherType==5)
        {
            BadaiUAS();
        }
        else if (WeatherType==6)
        {
            Sunny();
        }
        else if (WeatherType==7)
        {
            WildFire();
        }
    }
    public void ReduceChargeTurn(){
		SearchAttack();
		for(int i = 0 ; i < NBAttack ; i++){
			U[Yset[i]][Xset[i]].SetTurn(U[Yset[i]][Xset[i]].GetTurn() - 1);
			U[Yset[i]+1][Xset[i]].SetTurn(U[Yset[i]+1][Xset[i]].GetTurn() - 1);
			U[Yset[i]+2][Xset[i]].SetTurn(U[Yset[i]+2][Xset[i]].GetTurn() - 1);
		}
	}
    public boolean IsReadyToAttack(){
		boolean ready = false;
		System.out.println("isreadyto attack");
		for(int i = 0 ; i < NBAttack ; i++){
			if(U[Yset[i]][Xset[i]].GetTurn() == 0){
				ready = true;
			}
		}
		return ready;
	}
}

