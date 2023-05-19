package DataStructure;

public class Point {
	
	public static final Point RIGHT = new Point(1, 0); // x, y 좌표
	public static final Point DOWN = new Point(0, 1); // x, y 좌표
	public static final Point LEFT = new Point(-1, 0); // x, y 좌표
	public static final Point UP = new Point(0, -1); // x, y 좌표

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRow() {
        return y;
    }

    public int getCol() {
        return x;
    }

    public void setRowColumn(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public void setRow(int y) {
        this.y = y;
    }

    public void setCol(int x) {
        this.x = x;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }
    
    public static Point add(Point p1, Point p2) {
    	Point result = new Point();
    	result.x = p1.x + p2.x;
    	result.y = p1.y + p2.y;
    	
    	return result;
    }

    public static Point rotateCW(Point p) {
    	Point result = new Point();

    	if (p.equals(Point.RIGHT))
    		result = Point.DOWN;
    	else if (p.equals(Point.DOWN))
    		result = Point.LEFT;
    	else if (p.equals(Point.LEFT))
    		result = Point.UP;
    	else if (p.equals(Point.UP))
    		result = Point.RIGHT;
    	
    	return result;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;

        if ((this.x == p.x) && (this.y == p.y))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }

}
