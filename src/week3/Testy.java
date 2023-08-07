package week3;

public class Testy {
    public static void main(String[] args) {
        MyVectorGeneric<String> mvg = new MyVectorGeneric<String>();
        mvg.add("abc");
        mvg.add("to be or to eat");
        mvg.add("I love Java");
        mvg.add("Hello World");
        System.out.println(mvg.toString());
        //////////
        MyVectorGeneric<Integer> mvgInt = new MyVectorGeneric<Integer>();
        mvgInt.add(1);
        mvgInt.add(2);
        mvgInt.add(3);
        mvgInt.add(4);
        System.out.println(mvgInt.toString());
        /////////
        MyVectorGeneric<Character> mvgObj = new MyVectorGeneric<Character>();
        mvgObj.add('a');
        mvgObj.add('b');
        mvgObj.add('c');
        System.out.println(mvgObj.toString());
        //////////////////
        MyVectorGeneric<Point> vp = new MyVectorGeneric<Point>();
        // vp.add(new Shape());//ERROR!!!
        vp.add(new Point(1,1));
        System.out.println(vp);

/*
        generics.MyVectorGeneric<Shape> vsh = new generics.MyVectorGeneric<>();
        vsh.add(new Shape());
        vsh.add(new generics.Point(1,1));
        System.out.println(vsh);
*/

    }
}
