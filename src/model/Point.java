package model;

/**
 * A point representing a location in (x,y) coordinate space,
 * specified in double precision.
 * @author created by : Joshua Bezaleel Abednego
 * @author modified by : Riva Syafri Rachmatullah
 * @since 1.0
 * @version 1.2
 */
public class Point {
    private double x;
    private double y;
    
    /**
     * Constructs and initializes a point at the (0, 0) location in coordinate.
     * @since 1.0
     */
    public Point() {
        x = 0;
        y = 0;
    }
    
    /**
     * Constructs and initializes a point as same as point input location in 
     * coordinate.
     * @param p a point
     * @since 1.1
     */
    public Point(Point p) {
        x = p.getX();
        y = p.getY();
    }
    
    /**
     * Constructs and initializes a point at the (x, y) location in 
     * global position.
     * @param x the X coordinate
     * @param y the X coordinate
     * @since 1.1
     */
    public Point(double x, double y) {
	this.x = x;
        this.y = y;
    }
    
    /**
     * Check if this point is equal to a point
     * @param p a point
     * @return true if equals.
     * @since 1.2
     */
    public boolean equals(Point p) {
        return (this.x == p.x && this.y == p.y);
    }
    
    /**
     * Check if this point is equal to (x,y) coordinate.
     * @param x the X coordinate
     * @param y the Y coordinate
     * @return true if equals.
     * @since 1.2
     */
    public boolean equals(double x, double y) {
        return (this.x == x && this.y == y);
    }
    
    /**
     * Returns the location of this point.
     * @return a copy of this point, at the same location.
     * @since 1.1
     */
    public Point getLocation() {
        return new Point(x, y);
    }
    
    /**
     * Sets the location of this point to the specified double coordinates.
     * @param x the X coordinate of the new location
     * @param y the Y coordinate of the new location
     * @since 1.0
     */
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Returns the distance from this Point to a specified Point.
     * @param pt the specified point to be measured against this Point
     * @return the distance between this Point and the specified Point.
     * @since 1.1
     */
    public double distance(Point pt) {
        return Math.sqrt(Math.pow(Math.abs(this.x - pt.x), 2) 
                + Math.pow(Math.abs(this.y - pt.y), 2));
    }
    
    /**
     * Returns the distance from this Point to a specified point.
     * @param px the X coordinate of the specified point to be measured against this Point
     * @param py the Y coordinate of the specified point to be measured against this Point
     * @return the distance between this Point and a specified point.
     * @since 1.1
     */
    public double distance(double px, double py) {
        return Math.sqrt(Math.pow(Math.abs(x - px), 2) 
                + Math.pow(Math.abs(y - py), 2));
    }

    /**
     * Returns the X coordinate of this Point in double precision.
     * @return the X coordinate of this Point.
     * @since 1.0
     */
    public double getX() {
        return x;
    }
    
    /**
     * Returns the Y coordinate of this Point in double precision.
     * @return the Y coordinate of this Point.
     * @since 1.0
     */
    public double getY() {
        return y;
    }
    
    /**
     * Moves this point to the specified location in the (x,y) coordinate.
     * @param x the X coordinate of the new location.
     * @param y the Y coordinate of the new location.
     * @since 1.1
     */
    public void move(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Translates this point by dx along the x axis and dy along the y axis so 
     * that it now represents the point (x+dx,y+dy).
     * @param dx the distance to move this point along the X axis
     * @param dy the distance to move this point along the Y axis
     * @since 1.1
     */
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
}