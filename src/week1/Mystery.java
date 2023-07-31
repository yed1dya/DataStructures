package week1;

public class Mystery {
	public static String mystery(String s){
		int len = s.length();
		if (len <= 1) return s;
		String a = s.substring(0, len/2);
		String b = s.substring(len/2, len);
		String x = mystery(a);
		String y = mystery(b);
		return y + x;
	}
	public static int mcCarthy(int n){
		if (n > 100) return n-10;
		return mcCarthy(mcCarthy(n+11));
	}
	public static void main(String[] args) {
		System.out.println(mystery("abcde"));
		System.out.println(mystery("123456789"));
		System.out.println(mcCarthy(2000));
	}
}
/**
	edcba
	987654321
*/