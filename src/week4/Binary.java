package week4;

public class Binary {
    public static void main(String[] args) {
        System.out.println("0 --> "+DecToBi(0));
        System.out.println("1 --> "+DecToBi(1));
        System.out.println("2 --> "+DecToBi(2));
        System.out.println("3 --> "+DecToBi(3));
        System.out.println("13 --> "+DecToBi(13));
        System.out.println("15 --> "+DecToBi(15));
        System.out.println();
        System.out.println("null --> "+BiToDec(""));
        System.out.println("0 --> "+BiToDec("0"));
        System.out.println("1 --> "+BiToDec("1"));
        System.out.println("10 --> "+BiToDec("10"));
        System.out.println("11 --> "+BiToDec("11"));
        System.out.println("1101 --> "+BiToDec("1101"));
        System.out.println("1111 --> "+BiToDec("1111"));
        System.out.println();
        System.out.println("0 --> "+BiToDec(DecToBi(0)));
        System.out.println("1 --> "+BiToDec(DecToBi(1)));
        System.out.println("2 --> "+BiToDec(DecToBi(2)));
        System.out.println("3 --> "+BiToDec(DecToBi(3)));
        System.out.println("4 --> "+BiToDec(DecToBi(4)));
        System.out.println("13 --> "+BiToDec(DecToBi(13)));
        System.out.println("15 --> "+BiToDec(DecToBi(15)));
    }
    public static String DecToBi(int n){
        return DecToBi(n, new StringBuilder());
    }
    private static String DecToBi(int n, StringBuilder s){
        while (n>0){
            s.insert(0, n%2);
            n/=2;
        }
        if(s.isEmpty()) s.append("0");
        return s.toString();
    }
    public static String BiToDec(String s){
        int ans = 0, power = 0;
        for(int i=s.length(); i>0; i--){
            int n = s.charAt(i-1)-48;
            ans += (int) (n *(Math.pow(2,power++)));
        }
        return ""+ans;
    }
}
