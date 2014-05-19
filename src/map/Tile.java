/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

/**
 * abstract class of tile.
 * @author Calvin
 */
public abstract class Tile implements Copyable<Tile>{

    /**
     * constant for unused tile
     */
    public static final int tileUnused = 0;

    /**
     * constant for dirty wall
     */
    public final static int tileDirtWall = 1; //not in use

    /**
     * constant for dirty floor
     */
    public final static int tileDirtFloor = 2;

    /**
     * constant for stone wall
     */
    public final static int tileStoneWall = 3;

    /**
     * constant for corridor tile.
     */
    public final static int tileCorridor = 4;

    /**
     * constant for door.
     */
    public final static int tileDoor = 5;

    /**
     * constant for upstairs tile.
     */
    public final static int tileUpStairs = 6;

    /**
     * constant for downstairs tile.
     */
    public final static int tileDownStairs = 7;

    /**
     * constant for chest tile.
     */
    public final static int tileChest = 8;

    /**
     * get id of tile.
     * @return int id.
     */
    public abstract int getId();

    /**
     * check whether a tile is walkable.
     * @return boolean.
     */
    public abstract boolean isWalkable();

    /**
     * check whether tile is openable.
     * @return boolean.
     */
    public abstract boolean isOpenable();
}

abstract class OpenableTile extends Tile implements Openable{
    
}

class tileChest extends OpenableTile{
    private boolean open = false;
    @Override
    public boolean isWalkable() {
        return open;
    }

    @Override
    public boolean isOpenable() {
        return true;
    }

    @Override
    public int getId() {
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
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isOpenable() {
        return false;
    }

    @Override
    public int getId() {
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
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isOpenable() {
        return false;
    }

    @Override
    public int getId() {
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
    public boolean isWalkable() {
        return open;
    }

    @Override
    public boolean isOpenable() {
        return true;
    }

    @Override
    public int getId() {
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
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isOpenable() {
        return false;
    }

    @Override
    public int getId() {
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
    public boolean isWalkable() {
        return false;
    }

    @Override
    public boolean isOpenable() {
        return false;
    }

    @Override
    public int getId() {
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
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isOpenable() {
        return false;
    }

    @Override
    public int getId() {
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
    public boolean isWalkable() {
        return false;
    }

    @Override
    public boolean isOpenable() {
        return false;
    }

    @Override
    public int getId() {
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
    public boolean isWalkable() {
        return false;
    }

    @Override
    public boolean isOpenable() {
        return false;
    }

    @Override
    public int getId() {
        return Tile.tileUnused;
    }
    
    @Override
    public Tile copy() {
        Tile copy = new tileUnused();
        return copy;
    }
}