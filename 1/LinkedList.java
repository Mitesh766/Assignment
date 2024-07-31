class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

public class LinkedList {

    private static Node convertingArrToLL(int[] arr) {
        if (arr.length == 0)
            return null;
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    private static void traversingALL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private static Node addBeforeHead(Node head, int element) {
        Node newNode = new Node(element, head);
        return newNode;
    }

    private static boolean isEmptyLL(Node head) {
        if (head == null)
            return true;

        return false;
    }

    private static int sizeOfLL(Node head) {
        if (isEmptyLL(head))
            return 0;
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;

    }

    private static Node appendAtLast(Node head, int element) {
        Node newNode = new Node(element);
        if (head == null)
            return newNode;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    private static Node middleOfLL(Node head) {

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node[] splitAtIndex(Node head, int index) {
        if (index < 0 || head == null) {
            return new Node[] { head, null };
        }

        Node current = head;
        Node prev = null;
        int count = 0;

        while (current != null && count < index) {
            prev = current;
            current = current.next;
            count++;
        }

        if (prev != null) {
            prev.next = null;  
        }

        return new Node[] { head, current };
    }

    private static Node mergeTwoLL(Node head1, Node head2) {
        Node temp = head1;
        if (temp == null)
            return head2;

        while (temp.next != null)
            temp = temp.next;
        temp.next = head2;

        return head1;

    }

    private static Node interLeaveLL(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            Node next1 = temp1.next;
            Node next2 = temp2.next;

            temp1.next = temp2;  
            if (next1 == null) break;  

            temp2.next = next1; 
            temp1 = next1;
            temp2 = next2;
        }

        if (temp1 == null) {
            temp1.next = temp2;
        }

        return head1;

    }

    private static Node insertAtIndex(Node head, int index, int ele) {
        Node newNode = new Node(ele);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        }
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (count == index - 1) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            count++;
            temp = temp.next;
        }
        return head;
    }

    private static int indexOf(Node head, int element) {
        int index = 0;  
        Node current = head;

        while (current != null) {
            if (current.data == element) {
                return index;  
            }
            current = current.next;  
            index++;  
        }

        return -1;  
    }

    private static Node rotateLLByKPosition(Node head, int k) {
        if (head == null || head.next == null)
            return head;
        int n = 1;
        Node tail = head;
        while (tail.next != null) {
            n = n + 1;
            tail = tail.next;
        }
        k = k % n;
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k) {
                Node newHead = temp.next;
                temp.next = null;
                tail.next = head;
                return newHead;
            }
            temp = temp.next;
        }
        return head;

    }

    private static Node deleteAtIndex(Node head, int index) {
        if (head == null)
            return head;
        Node temp = head;
        if (index == 0) {
            head = head.next;
            temp.next = null;
            return head;
        }
        int cnt = 0;
        while (temp.next != null) {
            if (cnt == index - 1) {
                Node delElement = temp.next;
                temp.next = delElement.next;
                delElement.next = null;
                return head;
            }
            cnt += 1;
            temp = temp.next;
        }
        return head;
    }

    private static Node reverseASLL(Node head){
        // if(head==null || head.next==null) return head;
        Node prev=null;
        Node curr=head;
        Node front=head;
        while(curr!=null){
            front=front.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        return prev;
    }
    public static void main(String[] args) {

        int[] arr1 = {1,2,3,6,7,10};
        int[] arr2 = {4,5,8,9};
        Node head1 = convertingArrToLL(arr1);
        Node head2 = convertingArrToLL(arr2);
        Node head = interLeaveLL(head1,head2);
        traversingALL(head);

    }

}
