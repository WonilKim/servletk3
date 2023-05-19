package Mazing;

import DataStructure.ObjectStack;
import DataStructure.Point;

public class Mazing {

	private int[][] maze;
	private int rowSize;
	private int columnSize;
	private Point currentLocation;
	private Point currentDirection;
	private ObjectStack<Point> stack;
	
	public Point getCurrentLocation() {
		return currentLocation;
	}
		
	public Mazing(int[][] maze) {
		this.maze = maze;
		
		this.rowSize = maze.length;
		this.columnSize = maze[0].length;
		
		this.currentLocation = new Point();
		this.currentDirection = new Point();
		
		this.stack = new <Point>ObjectStack(this.rowSize * this.columnSize);
					
		this.currentDirection = Point.RIGHT;

	}
	
	public void setStartPoint(Point p) {
		this.currentLocation = p;
	}
	
	public boolean moveNext() {
		Point next = Point.add(this.currentLocation, this.currentDirection);
		if (checkNext(next) == true) {
			this.currentLocation = next;
			stack.push(next);
			return true;
		} else {
			for (int i=0; i<3; i++) {
				next = Point.add(
						this.currentLocation, 
						Point.rotateCW(this.currentDirection));
				
				if(stack.peek().equals(next)) {
					continue;
				}
				
				if (checkNext(next) == true) {
					this.currentLocation = next;
					stack.push(next);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkNext(Point p) {
		int nextRow = p.getRow();
		if ((nextRow < 0) || (this.rowSize <= nextRow)) {
			return false;
		}
		int nextCol = p.getCol();
		if ((nextCol < 0) || (this.columnSize <= nextCol)) {
			return false;
		}
		if (maze[nextRow][nextCol] == 1) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int mazeData[][] = {
				{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
				{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
				{1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1}, 
				{1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
				{1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1}, 
				{1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, 
				{1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
				{1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1}, 
				{1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
				{1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1}, 
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1}
				};
		
		Mazing mazing = new Mazing(mazeData);
		
		for (int r=0; r<mazing.rowSize; r++) {
			for (int c=0; c<mazing.columnSize; c++) {
				if(mazeData[r][c] == 1) {
					System.out.print("■");
				} else {
					System.out.print(" ");
				}
				
			}
			System.out.println();
		}
	}
}
