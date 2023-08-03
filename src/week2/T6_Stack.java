package week2;

public class T6_Stack {
    public static void main(String[] args) {
        System.out.println(Q1("svragbaer"));
        System.out.println(Q1("sv(5*12)ra<{g}3b[ae]r>"));
        System.out.println(Q1("sv(5*12)ra<{g}3b[ae]]r>"));
        System.out.println(Q2(543.345));
        System.out.println(Q2(543.543));
        System.out.println(Q2(1543.345));
        System.out.println(Q2(543.3451));
        int[] a1 = {5, 2, 5,6, 32, 423, 45 , 45, 3, 2, 9};
        Stack1<Integer> s1 = Q3(a1);
        System.out.println(s1);
    }
    public static Stack1<Integer> Q3(int[] arr){
        Stack1<Integer> ans = new Stack1<>(), help = new Stack1<>();
        if(arr==null || arr.length==0) return ans;
        ans.push(arr[0]);
        for(int i=1; i<arr.length; i++){
            while(ans.size>0 && arr[i]>ans.peek()){
                help.push(ans.pop());
            }
            ans.push(arr[i]);
            while (help.size>0){
                ans.push(help.pop());
            }
        }
        return ans;
    }
    public static boolean Q2(double num){
        String s = ""+num;
        int p = s.indexOf('.');
        Stack1<Character> t = new Stack1<>();
        for(int i=0; i<p; i++){
            t.push(s.charAt(i));
        }
        for(int i=p+1; i<s.length(); i++){
            if(t.size==0 || t.pop()!=s.charAt(i)){
                return false;
            }
        }
        return t.size == 0;
    }
    public static boolean Q1(String s){
        if(s==null) return true;
        Stack1<Boolean> round = new Stack1<>();
        Stack1<Boolean> square = new Stack1<>();
        Stack1<Boolean> squiggle = new Stack1<>();
        Stack1<Boolean> triangle = new Stack1<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            switch (c){
                case '(' -> round.push(true);
                case ')' -> {
                    if(!round.tryPop()) return false;
                }
                case '[' -> square.push(true);
                case ']' -> {
                    if(!square.tryPop()) return false;
                }
                case '{' -> squiggle.push(true);
                case '}' -> {
                    if(!squiggle.tryPop()) return false;
                }
                case '<' -> triangle.push(true);
                case '>' -> {
                    if(!triangle.tryPop()) return false;
                }
            }
        }
        return true;
    }
}
