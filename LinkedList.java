public class LinkedList {

    public static class Node {
        int data;           // variable that stores data
        Node next;          // it stores the address of next node. that's why it has Node type

        public Node(int data){
            this.data = data;
            this.next = null;
        }
        
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);      // create a new data
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next = head;        // head stores the fist Node add so head (1st node address) assigned to newNode(bcz it becomes 1st node now)
        head = newNode;             // head stores the address of 1st node(newNode)
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void add(int idx, int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        int i=0;
        Node temp = head;
        while (i<idx-1) {       //idex-1 = prev
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size==0){
            System.err.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(head==null){
            System.err.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node prev = head;
        for(int i=0;i<size-2;i++){      // secondLast node = size-2
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }


    public void print(){
        Node temp = head;
        if (head==null) {
            System.out.println("Linked list is null");
            return;
        }
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(1);
        // ll.addFirst(3);
        // ll.addLast(2);
        // ll.addLast(5);
        // ll.print();
        ll.removeFirst();
        // System.out.println(ll.size);
    }
}