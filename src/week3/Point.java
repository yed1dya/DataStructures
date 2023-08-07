package week3;

public class Point {
	public double _x, _y;
	public Point (double x1, double y1){
		_x = x1;
		_y = y1;
	}
	public Point (Point p){
		this(p.x(), p.y());
	}
	public double x() {return _x;}
	public double y() {return _y;}

	public String toString() {
		return " [" + _x + "," + _y+"]";
	}

	public boolean equals(Point p){
		return p._x==_x && p._y==_y;
	}
	public double dist0(){
		return Math.sqrt(_x*_x + _y*_y);
	}

	public static void main(String[] args) {
	}
}
