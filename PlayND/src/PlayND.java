import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PlayND extends javax.swing.JFrame {
    public PlayND() {
        move1 = -1;
        move2 = -1;
        initComponents();
        setSize(1024,725);
        Player = new Field[2];
        Player[0] = new Field(true);
	Player[1] = new Field(false);
        UnitP1 = new JButton[6][8];
        UnitP2 = new JButton[6][8];
        P1Label = new JLabel[6][8];
        P2Label = new JLabel[6][8];
        for(int i=0; i<6; i++){
            for(int j=0; j<8; j++){
                UnitP1[i][j] = new JButton();   
                UnitP2[i][j] = new JButton();   
                P1Label[i][j] = new JLabel();
                P2Label[i][j] = new JLabel();
            }
        }
        ShootP1 = new JLabel[8];
        ShootP2 = new JLabel[8];
        for(int i=0; i<8; i++){
            ShootP1[i] = new JLabel();
            ShootP1[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/Nature/blast.png")));
            getContentPane().add(ShootP1[i]);
            ShootP1[i].setBounds(480, (10+(i+1)*50+165), 120, 40);
            ShootP1[i].setVisible(false);
            ShootP2[i] = new JLabel();
            ShootP2[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/Human/blast.png")));
            getContentPane().add(ShootP2[i]);
            ShootP2[i].setBounds(490, (10+(i+1)*50+165), 120, 40);
            ShootP2[i].setVisible(false);  
        }
        SkipP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/nature.png")));
        SkipP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/human.png")));
        initUnitP1();
        initUnitP2();
        P1CallButton.setText(Integer.toString(Player[0].GetStock()));
        P2CallButton.setText(Integer.toString(Player[1].GetStock()));
        Player[0].SetTurn(3);
        Player[1].SetTurn(0);
        P1TurnLabel.setText("Turn: " + Integer.toString(Player[0].GetTurn()));
        P2TurnLabel.setText("Turn: " + Integer.toString(Player[1].GetTurn()));
        P1HP.setText(Integer.toString(Player[0].HP));
        P2HP.setText(Integer.toString(Player[1].HP));
        P1MoveNow.setVisible(false);
        P2MoveNow.setVisible(false);
        DisableP2();
        setVisible(true);
    }
    public void printUnitP1(){
        String unittype;
        for (int i = 0; i < 6; i++){
            for(int j=0; j < 8; j++){
                if(Player[0].U[i][j].GetStatus()==1){
                    if(Player[0].U[i][j].GetColour()==1){
                        unittype = "/Picture/Nature/10.png";
                    }
                    else if(Player[0].U[i][j].GetColour()==2){
                        unittype = "/Picture/Nature/20.png";
                    }
                    else{
                        unittype = "/Picture/Nature/30.png";
                    }
                    P1Label[i][j].setText(" ");
                    getContentPane().add(P1Label[i][j]);
                    P1Label[i][j].setBounds((Math.abs(i-5)+1)*40+170, (10+(j+1)*50+200), 40, 20);
                }
                else if(Player[0].U[i][j].GetStatus()==2){
                    if(Player[0].U[i][j].GetColour()==1){
                        unittype = "/Picture/Nature/11.png";
                    }
                    else if(Player[0].U[i][j].GetColour()==2){
                        unittype = "/Picture/Nature/21.png";
                    }
                    else{
                        unittype = "/Picture/Nature/31.png";
                    }
                    P1Label[i][j].setText("  " + Player[0].U[i][j].GetHP() + "  " + Player[0].U[i][j].GetTurn());
                    getContentPane().add(P1Label[i][j]);
                    P1Label[i][j].setBounds((Math.abs(i-5)+1)*40+170, (10+(j+1)*50+200), 40, 20);
                }
                else if(Player[0].U[i][j].GetStatus()==3){
                    unittype = "/Picture/Nature/wall.png";
                    P1Label[i][j].setText("      " + Player[0].U[i][j].GetHP());
                    getContentPane().add(P1Label[i][j]);
                    P1Label[i][j].setBounds((Math.abs(i-5)+1)*40+170, (10+(j+1)*50+200), 40, 20);
                }
                else{
                    unittype = "/Picture/Nature/blank.png";
                    P1Label[i][j].setText(" ");
                    getContentPane().add(P1Label[i][j]);
                    P1Label[i][j].setBounds((Math.abs(i-5)+1)*40+170, (10+(j+1)*50+200), 40, 20);
                }
                UnitP1[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource(unittype)));
                getContentPane().add(UnitP1[i][j]);
                UnitP1[i][j].setBounds((Math.abs(i-5)+1)*40+170, (10+(j+1)*50+165), 40, 40);
            }
        }
        P1HP.setText(Integer.toString(Player[0].HP));
        P2HP.setText(Integer.toString(Player[1].HP));
    }
    public void printUnitP2(){
        String unittype;
        for (int i = 0; i < 6; i++){
            for(int j=0; j < 8; j++){
                if(Player[1].U[i][j].GetStatus()==1){
                    if(Player[1].U[i][j].GetColour()==1){
                        unittype = "/Picture/Human/10.png";
                    }
                    else if(Player[1].U[i][j].GetColour()==2){
                        unittype = "/Picture/Human/20.png";
                    }
                    else{
                        unittype = "/Picture/Human/30.png";
                    }
                    P2Label[i][j].setText(" ");
                    getContentPane().add(P2Label[i][j]);
                    P2Label[i][j].setBounds((i+10)*40+170, (10+(j+1)*50+200), 40, 20);
                }
                else if(Player[1].U[i][j].GetStatus()==2){
                    if(Player[1].U[i][j].GetColour()==1){
                        unittype = "/Picture/Human/11.png";
                    }
                    else if(Player[1].U[i][j].GetColour()==2){
                        unittype = "/Picture/Human/21.png";
                    }
                    else{
                        unittype = "/Picture/Human/31.png";
                    }
                    P2Label[i][j].setText("  " + Player[1].U[i][j].GetHP() + "  " + Player[1].U[i][j].GetTurn());
                    getContentPane().add(P2Label[i][j]);
                    P2Label[i][j].setBounds((i+10)*40+170, (10+(j+1)*50+200), 40, 20);
                }
                else if(Player[1].U[i][j].GetStatus()==3){
                    unittype = "/Picture/Human/wall.png";
                    P2Label[i][j].setText("      " + Player[0].U[i][j].GetHP());
                    getContentPane().add(P2Label[i][j]);
                    P2Label[i][j].setBounds((i+10)*40+170, (10+(j+1)*50+200), 40, 20);
                }
                else{
                    unittype = "/Picture/Human/blank.png";
                    P2Label[i][j].setText(" ");
                    getContentPane().add(P2Label[i][j]);
                    P2Label[i][j].setBounds((i+10)*40+170, (10+(j+1)*50+200), 40, 20);
                }
                UnitP2[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource(unittype)));
                getContentPane().add(UnitP2[i][j]);
                UnitP2[i][j].setBounds((i+10)*40+170, (10+(j+1)*50+165), 40, 40);
            }
        }  
        P1HP.setText(Integer.toString(Player[0].HP));
        P2HP.setText(Integer.toString(Player[1].HP));
    }    
    public void initUnitP1(){
        printUnitP1();
        UnitP1[0][0].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(0,0);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[0]-1][0].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 0;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,0);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });       
        UnitP1[1][0].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(1,0);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[0]-1][0].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 0;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,0);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[2][0].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(2,0);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[0]-1][0].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 0;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,0);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[3][0].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(3,0);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[0]-1][0].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 0;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,0);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[4][0].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(4,0);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[0]-1][0].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 0;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,0);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[5][0].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(5,0);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[0]-1][0].getIcon());
                        P1MoveNow.setVisible(true);                         
                        move1 = 0;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,0);
                         printUnitP1();                         
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[0][1].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(0,1);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[1]-1][1].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 1;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,1);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[1][1].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(1,1);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[1]-1][1].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 1;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,1);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[2][1].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(2,1);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[1]-1][1].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 1;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,1);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[3][1].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(3,1);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[1]-1][1].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 1;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,1);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[4][1].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(4,1);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[1]-1][1].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 1;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,1);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[5][1].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(5,1);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[1]-1][1].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 1;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,1);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[0][2].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(0,2);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[2]-1][2].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 2;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,2);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[1][2].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(1,2);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[2]-1][2].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 2;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,2);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[2][2].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(2,2);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[2]-1][2].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 2;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,2);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[3][2].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(3,2);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[2]-1][2].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 2;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,2);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[4][2].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(4,2);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[2]-1][2].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 2;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,2);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[5][2].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(5,2);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[2]-1][2].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 2;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,2);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[0][3].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(0,3);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[3]-1][3].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 3;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,3);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });        
        UnitP1[1][3].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(1,3);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[3]-1][3].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 3;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,3);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[2][3].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(2,3);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[3]-1][3].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 3;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,3);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[3][3].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(3,3);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[3]-1][3].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 3;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,3);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[4][3].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(4,3);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[3]-1][3].getIcon());
                        P1MoveNow.setVisible(true); 
                        move1 = 3;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,3);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[5][3].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(5,3);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[3]-1][3].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 3;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,3);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[0][4].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(0,4);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[4]-1][4].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 4;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,4);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[1][4].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(1,4);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[4]-1][4].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 4;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,4);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[2][4].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(2,4);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[4]-1][4].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 4;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,4);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[3][4].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(3,4);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[4]-1][4].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 4;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,4);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[4][4].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(4,4);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[4]-1][4].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 4;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,4);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[5][4].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(5,4);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[4]-1][4].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 4;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,4);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[0][5].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(0,5);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[5]-1][5].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 5;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,5);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });      
        UnitP1[1][5].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(1,5);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[5]-1][5].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 5;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,5);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[2][5].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(2,5);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[5]-1][5].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 5;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,5);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[3][5].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(3,5);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[5]-1][5].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 5;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,5);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[4][5].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(4,5);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[5]-1][5].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 5;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,5);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[5][5].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(5,5);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[5]-1][5].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 5;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,5);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[0][6].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(0,6);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[6]-1][6].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 6;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,6);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[1][6].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(1,6);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[6]-1][6].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 6;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,6);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[2][6].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(2,6);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[6]-1][6].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 6;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,6);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });        
        UnitP1[3][6].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(3,6);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[6]-1][6].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 6;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,6);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[4][6].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(4,6);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[6]-1][6].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 6;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,6);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[5][6].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(5,6);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[6]-1][6].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 6;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,6);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[0][7].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(0,7);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[7]-1][7].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 7;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,7);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[1][7].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(1,7);
                }
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[7]-1][7].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 7;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,7);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[2][7].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(2,7);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[7]-1][7].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 7;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,7);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[3][7].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(3,7);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[7]-1][7].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 7;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,7);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[4][7].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(4,7);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[7]-1][7].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 7;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,7);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
        UnitP1[5][7].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP1(5,7);
                } 
                else{
                     if(move1 == -1){
                        P1MoveNow.setIcon(UnitP1[Player[0].Q[7]-1][7].getIcon());
                        P1MoveNow.setVisible(true);
                        move1 = 7;
                     }
                     else{
                         P1MoveNow.setVisible(false);
                         MoveP1(move1,7);
                         printUnitP1();
                         move1 = -1;
                     }
                }
            }
        });
    }    
    public void initUnitP2(){
        printUnitP2();
        UnitP2[0][0].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(0,0);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[0]-1][0].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 0;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,0);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });       
        UnitP2[1][0].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(1,0);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[0]-1][0].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 0;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,0);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[2][0].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(2,0);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[0]-1][0].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 0;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,0);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[3][0].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(3,0);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[0]-1][0].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 0;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,0);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[4][0].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(4,0);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[0]-1][0].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 0;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,0);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[5][0].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(5,0);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[0]-1][0].getIcon());
                        P2MoveNow.setVisible(true);                         
                        move2 = 0;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,0);
                         printUnitP2();                         
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[0][1].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(0,1);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[1]-1][1].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 1;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,1);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[1][1].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(1,1);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[1]-1][1].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 1;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,1);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[2][1].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(2,1);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[1]-1][1].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 1;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,1);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[3][1].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(3,1);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[1]-1][1].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 1;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,1);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[4][1].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(4,1);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[1]-1][1].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 1;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,1);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[5][1].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(5,1);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[1]-1][1].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 1;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,1);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[0][2].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(0,2);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[2]-1][2].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 2;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,2);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[1][2].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(1,2);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[2]-1][2].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 2;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,2);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[2][2].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(2,2);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[2]-1][2].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 2;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,2);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[3][2].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(3,2);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[2]-1][2].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 2;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,2);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[4][2].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(4,2);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[2]-1][2].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 2;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,2);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[5][2].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(5,2);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[2]-1][2].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 2;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,2);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[0][3].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(0,3);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[3]-1][3].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 3;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,3);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });        
        UnitP2[1][3].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(1,3);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[3]-1][3].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 3;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,3);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[2][3].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(2,3);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[3]-1][3].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 3;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,3);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[3][3].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(3,3);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[3]-1][3].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 3;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,3);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[4][3].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(4,3);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[3]-1][3].getIcon());
                        P2MoveNow.setVisible(true); 
                        move2 = 3;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,3);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[5][3].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(5,3);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[3]-1][3].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 3;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,3);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[0][4].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(0,4);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[4]-1][4].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 4;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,4);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[1][4].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(1,4);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[4]-1][4].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 4;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,4);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[2][4].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(2,4);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[4]-1][4].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 4;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,4);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[3][4].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(3,4);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[4]-1][4].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 4;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,4);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[4][4].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(4,4);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[4]-1][4].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 4;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,4);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[5][4].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(5,4);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[4]-1][4].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 4;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,4);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[0][5].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(0,5);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[5]-1][5].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 5;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,5);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });      
        UnitP2[1][5].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(1,5);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[5]-1][5].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 5;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,5);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[2][5].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(2,5);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[5]-1][5].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 5;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,5);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[3][5].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(3,5);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[5]-1][5].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 5;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,5);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[4][5].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(4,5);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[5]-1][5].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 5;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,5);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[5][5].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(5,5);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[5]-1][5].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 5;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,5);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[0][6].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(0,6);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[6]-1][6].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 6;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,6);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[1][6].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(1,6);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[6]-1][6].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 6;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,6);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[2][6].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(2,6);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[6]-1][6].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 6;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,6);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });        
        UnitP2[3][6].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(3,6);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[6]-1][6].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 6;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,6);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[4][6].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(4,6);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[6]-1][6].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 6;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,6);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[5][6].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(5,6);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[6]-1][6].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 6;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,6);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[0][7].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(0,7);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[7]-1][7].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 7;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,7);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[1][7].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(1,7);
                }
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[7]-1][7].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 7;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,7);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[2][7].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(2,7);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[7]-1][7].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 7;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,7);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[3][7].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(3,7);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[7]-1][7].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 7;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,7);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[4][7].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(4,7);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[7]-1][7].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 7;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,7);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
        UnitP2[5][7].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) { // if right click
                    DeleteUnitP2(5,7);
                } 
                else{
                     if(move2 == -1){
                        P2MoveNow.setIcon(UnitP2[Player[1].Q[7]-1][7].getIcon());
                        P2MoveNow.setVisible(true);
                        move2 = 7;
                     }
                     else{
                         P2MoveNow.setVisible(false);
                         MoveP2(move2,7);
                         printUnitP2();
                         move2 = -1;
                     }
                }
            }
        });
    }    
    public void MoveP1(int x1, int x2){
        DisableShoot();
        if(P==1){
            Player[0].Move(x1, x2);
            while(Player[0].Formation()){}
            P1CallButton.setText(Integer.toString(Player[0].GetStock()));
            printUnitP1();
            if(Player[0].GetTurn()<=0){
                DisableP1();
                Player[1].SetTurn(3);
            }
            P1TurnLabel.setText("Turn: " + Integer.toString(Player[0].GetTurn()));
            P2TurnLabel.setText("Turn: " + Integer.toString(Player[1].GetTurn()));
        }
    }
    public void MoveP2(int x1, int x2){
        DisableShoot();
        if(P==2){
            Player[1].Move(x1, x2);
            while(Player[1].Formation()){}
            P1CallButton.setText(Integer.toString(Player[0].GetStock()));
            printUnitP2();
            if(Player[1].GetTurn()<=0){
                DisableP2();
                Player[0].SetTurn(3);
            }
            P1TurnLabel.setText("Turn: " + Integer.toString(Player[0].GetTurn()));
            P2TurnLabel.setText("Turn: " + Integer.toString(Player[1].GetTurn()));        
        }
    }
    public void DeleteUnitP1(int x, int y){
        DisableShoot();
        if(P==1){
            P1MoveNow.setVisible(false);
            move1 = -1;
            Player[0].Delete(y,x);
            while(Player[0].Formation()){}
            P1CallButton.setText(Integer.toString(Player[0].GetStock()));
            printUnitP1();
            Player[0].SetTurn(Player[0].GetTurn()-1);
            if(Player[0].GetTurn()<=0){
                DisableP1();
                Player[1].SetTurn(3);
            }
            P1TurnLabel.setText("Turn: " + Integer.toString(Player[0].GetTurn()));
            P2TurnLabel.setText("Turn: " + Integer.toString(Player[1].GetTurn()));
        }
    }
    public void DeleteUnitP2(int x, int y){
        DisableShoot();
        if(P==2){
            P2MoveNow.setVisible(false);
            move2 = -1;
            Player[1].Delete(y,x);
            while(Player[1].Formation()){}
            P2CallButton.setText(Integer.toString(Player[1].GetStock()));
            printUnitP2();
            Player[1].SetTurn(Player[1].GetTurn()-1);
            if(Player[1].GetTurn()<=0){
                DisableP2();
                Player[0].SetTurn(3);
            }
            P1TurnLabel.setText("Turn: " + Integer.toString(Player[0].GetTurn()));
            P2TurnLabel.setText("Turn: " + Integer.toString(Player[1].GetTurn()));
        }
    }
    public void DisableP1(){
        P = 2;
        P1CallButton.setEnabled(false);
        P2CallButton.setEnabled(true);
        move2 = -1;
        SkipP1.setEnabled(false);
        SkipP2.setEnabled(true);
        Player[1].ReduceChargeTurn();
        printUnitP1();
        printUnitP2();
        Attack(Player, 1);
        while(Player[1].Formation()){}
        printUnitP1();
        printUnitP2();
        P1CallButton.setText(Integer.toString(Player[0].GetStock()));
        P2CallButton.setText(Integer.toString(Player[1].GetStock()));
        if(Player[0].HP<=0){
            EndGame(2);
        }
        else if(Player[1].HP<=0){
            EndGame(1);
        }
    }
    public void DisableP2(){
        P = 1;
        P2CallButton.setEnabled(false);
        P1CallButton.setEnabled(true);
        move1 = -1;
        SkipP1.setEnabled(true);
        SkipP2.setEnabled(false);
        Player[0].ReduceChargeTurn();
        printUnitP1();
        printUnitP2();
        Attack(Player, 0);
        while(Player[0].Formation()){}
        printUnitP1();
        printUnitP2();
        P1CallButton.setText(Integer.toString(Player[0].GetStock()));
        P2CallButton.setText(Integer.toString(Player[1].GetStock()));
        if(Player[0].HP<=0){
            EndGame(2);
        }
        else if(Player[1].HP<=0){
            EndGame(1);
        }
    }
    public void EndGame(int i){
        dispose(); //Destroy the JFrame object
        setVisible(false);
        new Winner(i);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        P1CallButton = new javax.swing.JButton();
        P2CallButton = new javax.swing.JButton();
        SkipP2 = new javax.swing.JButton();
        SkipP1 = new javax.swing.JButton();
        P2TurnLabel = new javax.swing.JLabel();
        P1TurnLabel = new javax.swing.JLabel();
        P2HP = new javax.swing.JLabel();
        P1HP = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        P2MoveNow = new javax.swing.JButton();
        P1MoveNow = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        P1CallButton.setText("P1");
        P1CallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P1CallButtonActionPerformed(evt);
            }
        });
        getContentPane().add(P1CallButton);
        P1CallButton.setBounds(280, 100, 63, 59);

        P2CallButton.setText("P2");
        P2CallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2CallButtonActionPerformed(evt);
            }
        });
        getContentPane().add(P2CallButton);
        P2CallButton.setBounds(670, 100, 60, 60);

        SkipP2.setText("Human");
        SkipP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SkipP2ActionPerformed(evt);
            }
        });
        getContentPane().add(SkipP2);
        SkipP2.setBounds(740, 30, 130, 130);

        SkipP1.setText("Nature");
        SkipP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SkipP1ActionPerformed(evt);
            }
        });
        getContentPane().add(SkipP1);
        SkipP1.setBounds(140, 30, 130, 130);

        P2TurnLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        P2TurnLabel.setText("Turn: 3");
        getContentPane().add(P2TurnLabel);
        P2TurnLabel.setBounds(670, 80, 60, 22);

        P1TurnLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        P1TurnLabel.setText("Turn: 3");
        getContentPane().add(P1TurnLabel);
        P1TurnLabel.setBounds(280, 80, 70, 22);

        P2HP.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        P2HP.setForeground(new java.awt.Color(255, 0, 0));
        P2HP.setText("100");
        getContentPane().add(P2HP);
        P2HP.setBounds(670, 30, 60, 40);

        P1HP.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        P1HP.setForeground(new java.awt.Color(255, 0, 0));
        P1HP.setText("100");
        getContentPane().add(P1HP);
        P1HP.setBounds(280, 30, 60, 40);

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton);
        BackButton.setBounds(10, 20, 70, 40);

        P2MoveNow.setText("P1");
        P2MoveNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2MoveNowActionPerformed(evt);
            }
        });
        getContentPane().add(P2MoveNow);
        P2MoveNow.setBounds(900, 360, 40, 40);

        P1MoveNow.setText("P1");
        P1MoveNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P1MoveNowActionPerformed(evt);
            }
        });
        getContentPane().add(P1MoveNow);
        P1MoveNow.setBounds(30, 370, 40, 40);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(470, 40, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void P1CallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P1CallButtonActionPerformed
        Player[0].Call();
        while(Player[0].Formation()){}
        P1CallButton.setText(Integer.toString(Player[0].GetStock()));
        P2CallButton.setText(Integer.toString(Player[1].GetStock()));
        printUnitP1();
        if(Player[0].GetTurn()<=0){
            DisableP1();
            Player[1].SetTurn(3);
        }
        P1TurnLabel.setText("Turn: " + Integer.toString(Player[0].GetTurn()));
        P2TurnLabel.setText("Turn: " + Integer.toString(Player[1].GetTurn())); 
    }//GEN-LAST:event_P1CallButtonActionPerformed

    private void P2CallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2CallButtonActionPerformed
        Player[1].Call();
        while(Player[1].Formation()){}
        P1CallButton.setText(Integer.toString(Player[0].GetStock()));
        P2CallButton.setText(Integer.toString(Player[1].GetStock()));
        printUnitP2();
        if(Player[1].GetTurn()<=0){
            DisableP2();
            Player[0].SetTurn(3);
        }
        P1TurnLabel.setText("Turn: " + Integer.toString(Player[0].GetTurn()));
        P2TurnLabel.setText("Turn: " + Integer.toString(Player[1].GetTurn()));
        
    }//GEN-LAST:event_P2CallButtonActionPerformed

    private void SkipP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SkipP1ActionPerformed
        DisableShoot();
        Player[0].SetTurn(0);
        Player[1].SetTurn(3);
        DisableP1();
        P1TurnLabel.setText("Turn: 0");
        P2TurnLabel.setText("Turn: 3");
        SkipP1.setEnabled(false);
    }//GEN-LAST:event_SkipP1ActionPerformed

    private void SkipP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SkipP2ActionPerformed
        DisableShoot();
        Player[0].SetTurn(3);
        Player[1].SetTurn(0);
        DisableP2();
        P1TurnLabel.setText("Turn: 3");
        P2TurnLabel.setText("Turn: 0");
        SkipP2.setEnabled(false);
    }//GEN-LAST:event_SkipP2ActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        dispose(); //Destroy the JFrame object
        setVisible(false);
        new MainMenu();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void P2MoveNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2MoveNowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_P2MoveNowActionPerformed

    private void P1MoveNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P1MoveNowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_P1MoveNowActionPerformed

    public void Attack(Field[] player, int playernow) {
        count = 0;
        for(int i=0; i<4; i++) {
            for(int j=0; j<8; j++) {
                while(player[playernow].U[i][j].GetStatus() == 2 && player[playernow].U[i][j].GetTurn() == 0) {
                    count++;
                    if(playernow == 0){
                        ShootP1[j].setVisible(true);                        
                    }
                    else{ 
                        ShootP2[j].setVisible(true);
                    } 
                    int damage = player[playernow].U[i][j].GetHP();
                    for(int k=0; k<3; k++) {
                        player[playernow].U[i][j].SetStatus(1);
                        player[playernow].Delete(j, i);
                    }
                    while(damage > 0) {
                        System.out.println(damage);
                        if(player[(playernow+1)%2].U[0][j].GetStatus() == 0) {
                            player[(playernow+1)%2].HP = player[(playernow+1)%2].HP - damage;
                            damage = 0;
                        }
                        else if(player[(playernow+1)%2].U[0][j].GetStatus() == 1) {
                            damage = damage - player[(playernow+1)%2].U[0][j].GetHP();
                            player[(playernow+1)%2].Delete(j, 0);
                        }
                        else if(player[(playernow+1)%2].U[0][j].GetStatus() == 2) {
                            if(player[(playernow+1)%2].U[0][j].GetHP() > damage) {
                                    player[(playernow+1)%2].U[0][j].SetHP(player[(playernow+1)%2].U[0][j].GetHP() - damage);
                                    player[(playernow+1)%2].U[1][j].SetHP(player[(playernow+1)%2].U[1][j].GetHP() - damage);
                                    player[(playernow+1)%2].U[2][j].SetHP(player[(playernow+1)%2].U[2][j].GetHP() - damage);
                                    damage = 0;
                            }
                            else {
                                damage = damage - player[(playernow+1)%2].U[0][j].GetHP();
                                for(int l=0; l<3; l++) {
                                    player[(playernow+1)%2].U[0][j].SetStatus(1);
                                    player[(playernow+1)%2].Delete(j, 0);
                                }
                            }
                        }
                        else if(player[(playernow+1)%2].U[0][j].GetStatus() == 3) {
                            if(player[(playernow+1)%2].U[0][j].GetHP() > damage) {
                                player[(playernow+1)%2].U[0][j].SetHP(player[(playernow+1)%2].U[0][j].GetHP() - damage);
                                damage = 0;
                            }
                            else {
                                damage = damage - player[(playernow+1)%2].U[0][j].GetHP();
                                player[(playernow+1)%2].Delete(j, 0);
                            }
                        }
                    }
                }
            }
        }
    }
    public void DisableShoot(){
        if(count>0){
            for(int i=0; i<8; i++){
                ShootP1[i].setVisible(false);
                ShootP2[i].setVisible(false);  
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayND().setVisible(true);
            }
        });
    }
    private int count;
    private int P;
    private int move1;
    private int move2;
    private JLabel ShootP1[];
    private JLabel ShootP2[];
    private JButton UnitP1[][];
    private JButton UnitP2[][];
    private JLabel P1Label[][];
    private JLabel P2Label[][];
    private Field Player[];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton P1CallButton;
    private javax.swing.JLabel P1HP;
    private javax.swing.JButton P1MoveNow;
    private javax.swing.JLabel P1TurnLabel;
    private javax.swing.JButton P2CallButton;
    private javax.swing.JLabel P2HP;
    private javax.swing.JButton P2MoveNow;
    private javax.swing.JLabel P2TurnLabel;
    private javax.swing.JButton SkipP1;
    private javax.swing.JButton SkipP2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
