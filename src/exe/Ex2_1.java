// 20404997
package exe;

import java.util.ArrayList;

public class Ex2_1 {
    public static void main(String[] args) {
        Point[] points = {new Point(4,5),new Point(6,9),new Point(9,3),
                new Point(8,6),new Point(5,7),new Point(3,1),
                new Point(2,6),new Point(1,4),new Point(7,2)};
        System.out.println(maxima(points));
    }

    /**
     * a point P is defined as a maximum point if:
     * for every other point Q in the array, P.x >= Q.x or P.y >= Q.y
     * in this assignment, points only have non-negative values.
     * Algorithm:
     * sorts array by X value.
     * iterates over array from right:
     * add all points of the largest X value. update 'max' to largest Y value.
     * for every X value: add points if they have a Y value larger than 'max',
     * and update tempMax to the current maximum.
     * before each new X value, update 'max' to the tempMax.
     * @param points array of points to search
     * @return Arraylist of the maximum points
     */
    public static ArrayList<Point> maxima(Point[] points) {
        ArrayList<Point> ans = new ArrayList<>();
        // base cases: null, length 0, length 1:
        if(points==null || points.length==0) return ans;
        int length = points.length;
        if(length==1){
            ans.add(points[0]);
            return ans;
        }
        // sort array by X value:
        sortByX(points, 0, points.length-1);
        ans.add(points[length-1]);
        double max = 0, tX = points[length-1].x(), tempMax = 0;
        // iterate from right:
        for(int i=length-2; i>=0; i--){
            double x = points[i].x(), y = points[i].y();
            // if it's the same X value:
            if(x==tX){
                // update max
                max = Math.max(y, max);
                // if Y value is bigger than tempMax:
                if(y>=tempMax) {
                    ans.add(points[i]);
                }
            }
            // if it's a new X value:
            else{
                // update values and add point if relevant:
                tempMax = max;
                tX=x;
                if(y>=max){
                    ans.add(points[i]);
                    max = y;
                }
            }
        }
        return ans;
    }

    /**
     * quickSort for points, sorts by X value.
     * @param points array to sort
     * @param start starting index
     * @param end end index
     */
    public static void sortByX(Point[] points, int start, int end){
        if(end<=start) return; // base case
        int pivot = partition(points, start, end); // sort by pivot index
        sortByX(points, start, pivot-1); // recursive call on left side
        sortByX(points, pivot+1, end); // recursive call on right side
    }

    /**
     * chooses a pivot index, sorts the array according to that partition, and returns the index.
     * @param points array that is being sorted
     * @param start start index
     * @param end end index
     * @return the pivot index
     */
    public static int partition(Point[] points, int start, int end){
        Point pivot = points[end];
        int i = start-1;
        for(int j=start; j<=end; j++){
            // put all elements smaller than pivot before pivot
            if(points[j].x()<pivot.x()){
                Point t = points[++i];
                points[i] = points[j];
                points[j] = t;
            }
        }
        // put pivot in the middle
        Point t = points[++i];
        points[i] = points[end];
        points[end] = t;
        // return pivot index:
        return i;
    }
}

class Point {
    public double _x, _y;
    public Point (double x1, double y1){
        _x = x1;
        _y = y1;
    }
    public Point (week3.Point p){
        this(p.x(), p.y());
    }
    public double x() {return _x;}
    public double y() {return _y;}

    public String toString() {
        return " [" + _x + "," + _y+"]";
    }

    public boolean equals(week3.Point p){
        return p._x==_x && p._y==_y;
    }
    public double dist0(){
        return Math.sqrt(_x*_x + _y*_y);
    }

    public static void main(String[] args) {
    }
}
