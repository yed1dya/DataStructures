package sandbox;

import java.util.Arrays;

public class B {
    public static void main(String[] args) {
        B b = new B(9);
        b.insert(3);
        b.display();
        b.insert(5);
        b.display();
        b.insert(2);
        b.display();
        b.insert(8);
        b.display();
        System.out.println(b.bigger(8));
    }
    int[][] a;
    int t;
    public B(int t){
        a = new int[2][t+1];
        this.t = t;
    }
    public void insert(int v){
        if(v<0 || v>t) return;
        for(int i=v; i<=t; i++){
            a[1][i] = Math.max(a[1][i], v);
        }
        a[0][v]++;
    }
    public int bigger(int x){
        if(x<0) return -1;
        if(x>t) return a[1][t];
        return a[1][x];
    }
    public void display(){
        System.out.print("\n[");
        for(int i=0; i<t; i++) System.out.print(i+", ");
        System.out.println(t+"]");
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
    }
}
