// https://leetcode.com/problems/design-browser-history/submissions/1282839299/

class Node{
    String data;
    Node next;
    Node prev;

    Node(String data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}

class BrowserHistoryDesign{
    Node current;

    BrowserHistoryDesign(String homepage){
        this.current=new Node(homepage);
    }

    void visit(String url){
        Node newNode= new Node(url);
        current.next=newNode;
        newNode.prev=current;
        current=current.next;
    }

    String back(int steps){
        while((steps--) >0){
            if(current.prev!=null){
                current=current.prev;
            }
            else{
                break;
            }
        }
        return current.data;
    }

    String front(int steps){
        while((steps--)>0){
            if(current.next!=null){
                current=current.next;
            }
            else{
                break;
            }
        }
        return current.data;
    }
}


public class BrowserHistory {
    public static void main(String[] args) {
        BrowserHistoryDesign obj= new BrowserHistoryDesign("www.google.com");
        obj.visit("miteshagrawal.vercel.com"); 
        obj.visit("www.linkedin.com/in/mitesh-agrawal76"); 
        obj.visit("https://github.com/Mitesh766"); 
        System.out.println(obj.front(5));


    }
}

