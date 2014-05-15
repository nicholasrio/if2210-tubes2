package engine.Scenes;
import engine.*;
import engine.DataStructure.GameData;
import java.util.Scanner;

/**
 *
 * @author Tony
 * @author Kevin
 */
public class LevelMenu extends Scene
{
    private String nama_klmpk;
    private String judul;
    private String nama_lvl;
    private int level;
    private int height;
    private int width;
    private int space;
    private int spacebetween;
    
    public LevelMenu()
    {
        super("LevelMenu");
    }
    
    @Override
    public void Initialize()
    {
        nama_klmpk="CUBE MAZER";
        judul="LEVEL MENU";        
        level=1;
        nama_lvl="ICE MAZE";
        height=55;
        width=168;        
        spacebetween=width/25;
        space=((width)-(spacebetween*10)-10-4)/2;         
    }
    
    @Override
    public void Update()
    {
        System.out.print("Enter your choice (1 untuk ke level berikutnya,0 untuk ke level sebelumnya, 2 untuk memilih level) : ");
        Scanner sc = new Scanner(System.in);    
        int input = sc.nextInt();
        if (input==1){
            if (level<3){
                level+=1;
                height=55;
            }
            else{
                height=54;
                for (int i=0;i<60;i++) System.out.print(" ");
                System.out.println("Tidak ada level diatas level 3!!");
            }
        }
        else if(input == 0){
            if (level>1){
                height=55;
                level-=1;
            }            
            else{
                height=54;
                for (int i=0;i<60;i++) System.out.print(" ");
                System.out.println("Tidak ada level dibawah level 1!!");
            }
        }
        else // input == 2
        {
            GameData.nowLevelPlayed = level;
            System.out.println("Level Chosen : " + level);
            Game.gameRunning = false;
            //SceneManager.SwitchScene("GameMenu");
        }
        if (level==1){
            nama_lvl="ICE MAZE";
        }       
         else if (level==4){
            nama_lvl="DUNGEON MAZE";
        }
        else if (level==2){
            nama_lvl="FIRE MAZE";
        }
        else if (level==3){
            nama_lvl="EGYPT MAZE";
        }
        else if (level==5){
            nama_lvl="ALIEN MAZE";
        }        
    }
    
    public void PrintBR(){
        System.out.print("||");
        for (int i=0;i<width-4;i++) System.out.print(" ");
        System.out.println("||");
    }
    
    @Override 
    //punya kevin
    public void Draw()
    {
        int k=0;
        //Print Batas atas
        for (int i=0;i<width;i++){
            System.out.print("=");
        }
        System.out.println();
        k+=1;
        
        //Print Blank Row
        while (k<5){
            PrintBR();
            k+=1;            
        }
        
        //Print Nama Kelompok
        spacebetween=width/25;
        space=((width)-(spacebetween*10)-10-4)/2;
        System.out.print("||");
        for (int i=0;i<space;i++) System.out.print(" ");
        for (int j=0;j<nama_klmpk.length();j++){
            System.out.print(nama_klmpk.charAt(j));
            for (int i=0;i<spacebetween;i++) System.out.print(" ");
        }
        for (int i=0;i<space;i++) System.out.print(" ");
        System.out.print("||");
        System.out.println(" "); 
        k+=1;
        
        //Print Blank Row
        PrintBR();
        PrintBR();
        k+=2;
        
        //Print judul
        System.out.print("||");
        for (int i=0;i<space;i++) System.out.print(" ");
        for (int j=0;j<judul.length();j++){
            System.out.print(judul.charAt(j));
            for (int i=0;i<spacebetween;i++) System.out.print(" ");
        }
        for (int i=0;i<space;i++) System.out.print(" ");
        System.out.print("||");
        System.out.println(" ");
        k+=1;
 
        //Print Blank Row
        while (k<15){
            PrintBR();
            k+=1;            
        }
 
        //Print batas tengah        
        System.out.print("||");
        for (int i=0;i<width-4;i++) System.out.print("=");
        System.out.println("||");
        k++;
        
        
        //Print Blank Row
        while (k<28){
            PrintBR();
            k+=1;            
        }
        
        //Print nama level
        spacebetween=width/25;
        space=((width)-(spacebetween*nama_lvl.length())-nama_lvl.length()-4)/2;
        System.out.print("||");        
        for (int i=0;i<space;i++) System.out.print(" ");
        for (int j=0;j<nama_lvl.length();j++){
            System.out.print(nama_lvl.charAt(j));
            for (int i=0;i<spacebetween;i++) System.out.print(" ");
        }
        if ((nama_lvl.length()%2)!=0){
            for (int i=0;i<space+1;i++) System.out.print(" ");            
        }
        else{
            for (int i=0;i<space;i++) System.out.print(" ");            
        }
        System.out.print("||");
        System.out.println(" ");
        k+=1;

        //Print Blank Row
        PrintBR();
        PrintBR();
        k+=2;
               
        //Print tingkat level
        spacebetween=width/25;
        String str_level= "level " + level;      
        space=((width)-(spacebetween*str_level.length())-str_level.length()-4)/2;
        System.out.print("||");        
        for (int i=0;i<space;i++) System.out.print(" ");
        for (int j=0;j<str_level.length();j++){
            System.out.print(str_level.charAt(j));
            for (int i=0;i<spacebetween;i++) System.out.print(" ");
        }
        if ((str_level.length()%2)!=0){
            for (int i=0;i<space+1;i++) System.out.print(" ");            
        }
        else{
            for (int i=0;i<space;i++) System.out.print(" ");            
        }
        System.out.print("||");
        System.out.println(" ");
        k+=1;        
        
        //Print blank row
        PrintBR();
        PrintBR();
        k+=2;
        
        //Print tanda kiri dan kanan
        System.out.print("||  <");
        for (int i=0;i<width-10;i++) System.out.print(" ");
        System.out.println(">  ||");
        k+=1;
        
        while (k<height){
            System.out.print("||");
            for (int i=0;i<width-4;i++) System.out.print(" ");
            System.out.println("||");
            k++;
        }
        for (int i=0;i<width;i++) System.out.print("=");
        System.out.println("");
    }
}

