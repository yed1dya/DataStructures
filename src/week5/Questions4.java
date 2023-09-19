package week5;

public class Questions4 {
    public static void main(String[] args) {
        int[] a = new int[]{-11, -4, 0, 1, 2, 5, 14};
        System.out.println(Q2(a));
    }
    // find i=n[i]
    public static int Q2(int[] n){
        if(n==null || n.length==0) return -1;
        int a=0, b=n.length-1, m;
        while(a<b){
            m=(a+b)/2;
            if(n[m]==m) return m;
            if(n[m]>m) b=m;
            if(n[m]<m) a=m;
        }
        return -1;
    }
}
