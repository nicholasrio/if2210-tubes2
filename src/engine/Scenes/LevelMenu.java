package engine.Scenes;
import engine.*;

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
        nama_klmpk="Cube Mazer";
        judul="Level Menu";        
        level=0;
        height=56;
        width=168;        
        spacebetween=width/25;
        space=((width)-(spacebetween*10)-10-4)/2;        
    }
    
    @Override
    public void Update()
    {
        if (level<5) level+=1;
         if (level==1){
            nama_lvl="Indonesian Maze";
        }       
         else if (level==2){
            nama_lvl="Dungeon Maze";
        }
        else if (level==3){
            nama_lvl="Fire Maze";
        }
        else if (level==4){
            nama_lvl="Egypt Maze";
        }
        else if (level==5){
            nama_lvl="Alien Maze";
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
        while (k<19){
            PrintBR();
            k+=1;            
        }
        
        //Print Nama Kelompok
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
        PrintBR();
        PrintBR();
        k+=2;
        
        //Print nama level
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

