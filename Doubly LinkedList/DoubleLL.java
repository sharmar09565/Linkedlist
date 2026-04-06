public class DoubleLL {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        
    }
    public static Node head;
    public static Node tail;
    
    // add first
    public void addFirst(int data){
        Node newNode = new Node(data);

        if(head==null){
            head=tail=newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Remove first
    public void removeFirst(){
        if(head==null){
            System.out.println("LL is empty. Can't delete");
            return;
        }
        if(head.next==null){
            head=tail=null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    // print
    public void print(){
        Node temp = head;

        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        while (temp!=null) {
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void reverse(){
        Node currNode = head;
        Node nextNode;
        Node prevNode = null;

        while (currNode!=null) {

            nextNode = currNode.next;
            currNode.next = prevNode;
            currNode.prev = currNode.next;
            prevNode = currNode;
            currNode = nextNode;

        }
        head = prevNode;
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);

        // dll.removeFirst();
        dll.print();
        dll.reverse();
        dll.print();
    }
}
