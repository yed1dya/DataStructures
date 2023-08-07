package week3;

import java.util.Stack;

public class JavaStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        System.out.println("isEmpty()? "+st.empty());
        System.out.println(st.push(11));
        System.out.println(st.push(12));
        System.out.println("top = "+st.peek());

        System.out.println("size = "+st.size());
        System.out.println("isEmpty()? "+st.empty());
        System.out.print(st.push(13) + ", ");
        System.out.print(st.push(14) + ", ");
        System.out.print(st.push(15) + ", ");
        System.out.print(st.push(16));
        System.out.println();
        System.out.println("size = "+st.size());
        System.out.println("stack: "+st.toString());
        while(!st.empty()){
            System.out.println("item: "+st.pop());
        }
        System.out.println("isEmpty()? "+st.empty());
        System.out.println("size = "+st.size());
        //////
        Stack<String> stj = new Stack<>();
        stj.add("a");
        stj.add("b");
        stj.add("c");
        while(!stj.empty())
            System.out.println(stj.pop());
    }

}
