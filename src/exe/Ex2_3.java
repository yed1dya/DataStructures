// 207404997
package exe;

import java.util.Stack;

public class Ex2_3 {
    public static void main(String[] args) {
        Queue2Stacks q = new Queue2Stacks();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        System.out.println(q.deQueue());
        q.enQueue(4);
        while(!q.isEmpty()) {
            System.out.print(q.deQueue() + ", ");
            System.out.print(q.deQueue() + ", ");
            System.out.println(q.deQueue() + ", ");
        }
    }
}

/**
 * uses 2 stacks to implement a queue.
 * stack1 is the queue. enQueue is just pushing an item into the stack.
 * deQueue is copying stack1 into stack2 (order will be reversed),
 * then popping the last element (the first one that was queued),
 * then copying stack2 into stack1 (order is reversed again).
 */
class Queue2Stacks {
    Stack<Integer> stack1, stack2;
    int size;
    public Queue2Stacks (){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size=0;
    }
    // Function to enqueue an item to the queue O(1).
    public void enQueue(int x) {
        stack1.push(x);
        size++;
    }
    // Function to deQueue an item from queue O(N) in general
    public int deQueue() {
        // transfer stack1 to stack2, complexity O(N)
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        // get item to be returned, O(1)
        int ans = stack2.pop();
        // restore stack1, O(N)
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        // decrement size, O(1)
        size--;
        return ans;
    }
    // Function returns true if the queue is empty,
    // otherwise it returns false.
    public boolean isEmpty(){
        return size==0;
    } // O(1).
    // Function returns the number of items, stored in the queue.
    public int size(){
        return size;
    }// O(1).
}
