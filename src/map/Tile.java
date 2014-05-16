/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

/**
 *
 * @author Calvin
 */
public abstract class Tile implements Copyable<Tile>{
    public static final int tileUnused = 0;
    public final static int tileDirtWall = 1; //not in use
    public final static int tileDirtFloor = 2;
    public final static int tileStoneWall = 3;
    public final static int tileCorridor = 4;
    public final static int tileDoor = 5;
    public final static int tileUpStairs = 6;
    public final static int tileDownStairs = 7;
    public final static int tileChest = 8;
    abstract int getId();
    abstract boolean isWalkable();
    abstract boolean isOpenable();
}

abstract class OpenableTile extends Tile implements Openable{
    
}

class tileChest extends OpenableTile{
    private boolean open = false;
    @Override
    boolean isWalkable() {
        return open;
    }

    @Override
    boolean isOpenable() {
        return true;
    }

    @Override
    int getId() {
        return Tile.tileChest;
    }

    @Override
    public Tile copy() {
        tileChest copy = new tileChest();
        copy.open = open;
        return copy;
    }

    @Override
    public void open() {
        open = true;
    }

    @Override
    public void close() {
        open = false;
    }

    @Override
    public boolean isOpen() {
        return open;
    }
    
}

class tileDownStairs extends Tile{
    
    @Override
    boolean isWalkable() {
        return true;
    }

    @Override
    boolean isOpenable() {
        return false;
    }

    @Override
    int getId() {
        return Tile.tileDownStairs;
    }
    
    @Override
    public Tile copy() {
        Tile copy = new tileDownStairs();
        return copy;
    }
    
}

class tileUpstair extends Tile{
    
    @Override
    boolean isWalkable() {
        return true;
    }

    @Override
    boolean isOpenable() {
        return false;
    }

    @Override
    int getId() {
        return Tile.tileUpStairs;
    }
    @Override
    public Tile copy() {
        Tile copy = new tileUpstair();
        return copy;
    }
}

class tileDoor extends OpenableTile{
    private boolean open;
    @Override
    boolean isWalkable() {
        return open;
    }

    @Override
    boolean isOpenable() {
        return true;
    }

    @Override
    int getId() {
        return Tile.tileDoor;
    }
    @Override
    public Tile copy() {
        tileDoor copy = new tileDoor();
        copy.open = this.open;
        return copy;
    }

    @Override
    public void open() {
        open = true;
    }

    @Override
    public void close() {
        open = false;
    }

    @Override
    public boolean isOpen() {
        return open;
    }
}

class tileCorridor extends Tile{
    
    @Override
    boolean isWalkable() {
        return true;
    }

    @Override
    boolean isOpenable() {
        return false;
    }

    @Override
    int getId() {
        return Tile.tileCorridor;
    }
    
    @Override
    public Tile copy() {
        Tile copy = new tileCorridor();
        return copy;
    }
}

class tileStoneWall extends Tile{
    
    @Override
    boolean isWalkable() {
        return false;
    }

    @Override
    boolean isOpenable() {
        return false;
    }

    @Override
    int getId() {
        return Tile.tileStoneWall;
    }
    
    
    @Override
    public Tile copy() {
        Tile copy = new tileStoneWall();
        return copy;
    }
}

class tileDirtFloor extends Tile{
    
    @Override
    boolean isWalkable() {
        return true;
    }

    @Override
    boolean isOpenable() {
        return false;
    }

    @Override
    int getId() {
        return Tile.tileDirtFloor;
    }
    
    @Override
    public Tile copy() {
        Tile copy = new tileDirtFloor();
        return copy;
    }
}

class tileDirtWall extends Tile{
    
    @Override
    boolean isWalkable() {
        return false;
    }

    @Override
    boolean isOpenable() {
        return false;
    }

    @Override
    int getId() {
        return Tile.tileDirtWall;
    }
    
    @Override
    public Tile copy() {
        Tile copy = new tileDirtWall();
        return copy;
    }
}

class tileUnused extends Tile{
    
    @Override
    boolean isWalkable() {
        return false;
    }

    @Override
    boolean isOpenable() {
        return false;
    }

    @Override
    int getId() {
        return Tile.tileUnused;
    }
    
    @Override
    public Tile copy() {
        Tile copy = new tileUnused();
        return copy;
    }
}