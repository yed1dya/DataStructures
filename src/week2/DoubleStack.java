package week2;

public class DoubleStack {
    private int[] stack;
    private int max, leftIndex, rightIndex;
    public DoubleStack(){
        int DEFAULT_SIZE = 100;
        stack = new int[DEFAULT_SIZE];
        max=50;
        leftIndex=0;
        rightIndex=DEFAULT_SIZE;
    }
    public DoubleStack(int size){
        stack = new int[size*2];
        max=size;
        leftIndex=0;
        rightIndex=size*2;
    }
    public boolean pushLeft(int data){
        if(leftIndex<max){
            stack[++leftIndex] = data;
            return true;
        }
        return false;
    }
    public boolean pushRight(int data){
        if(rightIndex>max){
            stack[--rightIndex] = data;
            return true;
        }
        return false;
    }
    public int popLeft(){
        if(leftIndex>=0){
            return stack[leftIndex--];
        }
        return 0;
    }
    public int popRight(){
        if(rightIndex<=max*2){
            return stack[rightIndex++];
        }
        return 0;
    }
}
