package week2;

public class T2_RecursionPractice {
    public static void main(String[] args) {
        System.out.println(sum(3, 5));
        System.out.println(subtract(5,3));
        System.out.println(multiply(3,5));
        System.out.println(divide(15,3));
        System.out.println(remainder(15,3));
        System.out.println(twoPwrOfN(5));
        System.out.println(reverse("asdf"));
        System.out.println(recReverse("asdf"));
        System.out.println(reverse(12345));
        System.out.println(recReverse(12345));
        System.out.println(factorial(10));
        System.out.println(mystery("abcdef"));
        triangle(12);
        System.out.println();
        for(int i=0; i<15; i++){
            System.out.println(fibonacci(i));
        }
        System.out.println(power(3,7));
    }
    public static int maxValue(int[] arr, int beg){
        if (beg == 0){
            return arr[0];
        }
        int x = maxValue(arr, beg-1);
        return x>arr[beg] ? x : arr[beg];
    }
    public static void triangle(int n){ // print triangle
        char x = '*';
        if (n > 1){
            triangle(n-1);
            System.out.println();
            line(n);
        }
        else{
            System.out.print(x);
        }
    }
    public static void line(int n){ // print line
        char x = '*';
        if (n>1){
            line(n-1);
        }
        System.out.print(x);
    }
    public static String mystery( String s) {
        int len = s.length();
        if (len <= 1) return s;
        String a = s.substring(0, len / 2);
        String b = s.substring(len / 2, len);
        return mystery(b) + mystery(a);
    }
    public static long fibonacci(long n){
        if(n==0) return 1;
        if(n==1) return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static long factorial(long n){
        if(n==0) return 1;
        return n*factorial(n-1);
    }
    public static int reverse(int n){
        int ans = 0;
        while (n!=0){
            ans = ans*10+n%10;
            n/=10;
        }
        return ans;
    }
    public static int recReverse(int n){
        return recReverse(n, 0);
    }
    public static int recReverse(int n, int a){
        if(n==0) return a;
        a = a*10 + n%10;
        return recReverse(n/10, a);
    }
    public static String recReverse(String s){
        if(s.length()==1) return s;
        return s.charAt(s.length()-1)+recReverse(s.substring(0, s.length()-1));
    }
    public static String reverse(String s){
        StringBuilder ans = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
    public static int twoPwrOfN(int n){
        if(n==0) return 1;
        return twoPwrOfN(n-1)+ twoPwrOfN(n-1);
    }
    public static int sum(int a, int b){
        if(b==0) return a;
        return(sum(a, b-1)+1);
    }
    public static int subtract(int a, int b){
        if(b==0) return a;
        return(subtract(a, b-1)-1);
    }
    public static int multiply(int a, int b){
        if(b==1) return a;
        return multiply(a, b-1)+a;
    }
    public static int divide(int a, int b){
        if(a<b) return 0;
        return divide(a-b, b)+1;
    }
    public static int remainder(int a, int b){
        if(a<b) return a;
        return remainder(a-b, b);
    }
    public static long power(long base, long pwr){
        if(pwr==0) return 1;
        return power(base, pwr-1)*base;
    }
}
