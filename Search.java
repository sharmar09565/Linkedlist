public class Search {
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
    
    // Iterative search
    public int itrSearch(int num){
        Node temp = head;
        int i=0;
        while (temp!=null) {
            if(temp.data==num){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int num){
        if(head==null){
            return -1;
        }
        if(head.data==num){
            return 0;
        }

        int idx = helper(head.next, num);
        if(idx == -1){
            return -1;
        }
        else{
            return idx+1;
        }
    }
    public int recursiveSearch(int num){
        return helper(head, num);
    }

    public static void main(String[] args) {
        Search ll = new Search();
        ll.addFirst(1);
        ll.addFirst(3);
        ll.addLast(2);
        ll.addLast(5);
        ll.print();
        // System.out.println(ll.itrSearch(1));;
        System.out.println(ll.recursiveSearch(2));
        

    }
}
