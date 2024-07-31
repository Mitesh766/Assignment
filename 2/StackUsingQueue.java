// https://leetcode.com/problems/implement-stack-using-queues/submissions/1277620975/

import java.util.LinkedList;
import java.util.Queue;

class Stack {
    Queue<Integer> q1 = new LinkedList<Integer>();
    int size = 0;

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size==0;
    }

    void push(int x) {
        q1.add(x);
        size++;
        for (int i = 0; i < size - 1; i++) {
            q1.add(q1.remove());
        }
    }

    int top() {
        return q1.peek();
    }

    int pop(){
        size--;
        return q1.remove();
    }

    void printStack(){
        for(int i=0;i<size;i++){
            System.out.print(q1.peek());
            if(i+1!=size){
                System.out.print("--->");
            }
            int pop=q1.remove();
            q1.add(pop);
        }
    }

}

public class StackUsingQueue {
    public static void main(String[] args) {
   Stack s1= new Stack();
   s1.push(1);
   s1.push(2);
   s1.push(3);
   s1.push(4);
      System.out.println(s1.pop());
   s1.printStack();
//    System.out.println(s1.size());
//    System.out.println(s1.pop());
//    System.out.println(s1.pop());
//    System.out.println(s1.top());
    }
}
