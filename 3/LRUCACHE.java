import java.util.HashMap;

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

}

class DLL{
    Node head = new Node(-1,-1);
    Node tail= new Node(-1,-1);
    
    DLL(){
        head.next=tail;
        tail.prev=head;
    }
 

     void addNode(Node root){
        root.next= head.next;
        root.next.prev=root;
        head.next=root;
        root.prev=head;
     }

     void remove(Node root){
        root.prev.next= root.next;
        root.next.prev=root.prev;
        root.next=null;
        root.prev=null;
     }

     int removeLast(){
        int key= tail.prev.key;
        remove(tail.prev);
        return key;
     }
}

 class LRU{
    int capacity;
    int size = 0;
    HashMap<Integer, Node> mp = new HashMap<>();
    DLL q= new DLL();

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(mp.containsKey(key)){
            Node curr= mp.get(key);
            q.remove(curr);
            q.addNode(curr);
            return curr.value;
        }
        return -1;

    }

    public void put(int key, int val) {
        if(mp.containsKey(key)){
            Node curr= mp.get(key);
            curr.value=val;
            q.remove(curr);
            q.addNode(curr);

        }
        else if(size<capacity){
            size++;
            Node newNode= new Node(key,val);
            mp.put(key,newNode);
            q.addNode(newNode);
        }
        else{
            int LruKey=q.removeLast();
            mp.remove(LruKey);
            size--;
            put(key,val);
        }
    }
}

public class LRUCACHE{
    public static void main(String[] args){

    }
}
