// delete nth from last

public class DeleteNth {
    public class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }  
    }
    public static Node head;
    public static Node tail;

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void print(){
        Node temp = head;

        if (head == null) {
            System.out.println("Linked list is null");
            return;
        }

        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void remove(int n){
        int size = 0;
        Node temp = head;

        while (temp!=null) {
            temp=temp.next;
            size++;
        }

        if(n==size){
            head=head.next;
            return;
        }

        int i=1;
        int idx = size-n;
        Node prev = head;
        
        while (i<idx) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    public static void main(String[] args) {
        DeleteNth ll = new DeleteNth();
        ll.addLast(2);
        ll.addLast(5);
        ll.addLast(1);
        ll.addLast(4);
        ll.addLast(3);
        ll.print();
        ll.remove(2);
        ll.print();
    }
}
