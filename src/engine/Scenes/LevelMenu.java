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
        nama_lvl="Indonesian Maze";
        level=1;
        height=30;
        width=100;        
        spacebetween=width/25;
        space=((width)-(spacebetween*10)-10-4);        
    }
    
    @Override
    public void Update()
    {
        level+=1;
        if (level==2){
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
    
    @Override 
    //punya kevin
    public void Draw()
    {
        for (int i=0;i<100;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("||");
        for (int i=0;i<space;i++) System.out.print(" ");
        for (int j=0;j<nama_klmpk.length();j++){
            System.out.print(nama_klmpk.charAt(j));
            for (int i=0;i<spacebetween;i++) System.out.print(" ");
        }
        for (int i=0;i<space;i++) System.out.print(" ");
        System.out.print("||");
        System.out.println(" ");
        
        //Print judul
        System.out.println("||");
        for (int i=0;i<space;i++) System.out.print(" ");
        for (int j=0;j<judul.length();j++){
            System.out.print(judul.charAt(j));
            for (int i=0;i<spacebetween;i++) System.out.print(" ");
        }
        for (int i=0;i<space;i++) System.out.print(" ");
        System.out.print("||");
        System.out.println(" ");
        
        //Print nama level
        space=((width)-(spacebetween*nama_lvl.length())-nama_lvl.length()-4);
        System.out.println("||");
        for (int i=0;i<space;i++) System.out.print(" ");
        for (int j=0;j<nama_lvl.length();j++){
            System.out.print(nama_lvl.charAt(j));
            for (int i=0;i<spacebetween;i++) System.out.print(" ");
        }
        for (int i=0;i<space;i++) System.out.print(" ");
        System.out.print("||");
        System.out.println(" ");
        
        System.out.println(judul);
        System.out.println(level);
        System.out.println(nama_lvl);
        System.out.print("<" + ">");
    }
}

