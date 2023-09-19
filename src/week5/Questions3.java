package week5;

public class Questions3 {
    public static void main(String[] args) {
        int[] a = new int[]{-11, -4, 0, 1, 2, 5, 14};
        System.out.println(Q1(a, 12));
        System.out.println(Q5(new int[]{-11, 1, 1, 1, 1, 5, 14, 15}));
        System.out.println(Q6(new int[]{-11, 1, 5, 14, 15}, -11));
    }

    // binary search non rec
    public static int Q1(int[] a, int v){
        if(a==null || a.length==0) return -1;
        int small=0, big=a.length-1, m;
        while(small<=big){
            m=(small+big)/2;
            if(a[m]==v) return m;
            if(a[m]<v) small++;
            else big--;
        }
        return -1;
    }

    // if num appears more than n/2 times
    public static int Q5(int[] a){
        if(a==null || a.length==0){
            System.out.println("too short");
            return 0;
        }
        if(a.length<2) return a[0];
        int index = 0, len = a.length, d = len/2;
        while (index+d < len){
            if(a[index]==a[index+d]) return a[index];
            index++;
        }
        System.out.println("not found");
        return 0;
    }

    public static int Q6(int[] n, int v){
        return Q6(n, v, 0, n.length-1);
    }
    private static int Q6(int[] n, int v, int a, int b){
        int m = (a+b)/2;
        if(a>b || m==0) return -1;
        if(v>n[m]) return Q6(n, v, m+1, b);
        if(n[m-1]>=v) return Q6(n, v, a, m-1);
        return m;
    }
}
