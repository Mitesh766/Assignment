// https://leetcode.com/problems/implement-queue-using-stacks/submissions/1277696843/
import java.util.Stack;

class Queue {
    private int size = 0;
    private Stack<Integer> input = new Stack<Integer>();
    private Stack<Integer> output = new Stack<Integer>();

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void push(int x) {
        input.push(x);
        size++;
    }

    int peek() {
        if (output.isEmpty() == false)
            return output.peek();
        
            while (input.isEmpty()==false){
                output.push(input.pop());
            }

            return output.peek();
    }

    int pop(){
        if(output.isEmpty()==false){
            size--;
            return output.pop();
        }

        while(input.isEmpty()==false){
            output.push(input.pop());
        }
        size--;
        return output.pop();
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {
        Queue q1 = new Queue();
        q1.push(1);
        q1.push(2);
        q1.push(3);
        q1.push(4);
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        System.out.println(q1.size());
    }
}
