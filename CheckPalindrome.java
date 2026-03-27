public class CheckPalindrome {
    public static class Node {
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

    public Node findMid(Node head){
        Node temp1 = head;      // takes jump of 1(slow)
        Node temp2 = head;      // takes jump of 2(fast)

        while (temp2 != null && temp2.next != null) {
            temp1 = temp1.next;         //+1
            temp2 = temp2.next.next;    //+2
        }
        
        return temp1;
    }

    public boolean isPalindrome(){
        if (head == null || head.next == null) {
            return true;
        }
        // step 1 - find mid node
        Node midNode = findMid(head);

        // step 2 - reverse the half right part
        Node currNode = midNode;
        Node preNode = null;
        Node nextNode;

        while (currNode!=null) {
            nextNode = currNode.next;
            currNode.next = preNode;
            preNode  = currNode;
            currNode = nextNode;
        }
        Node right = preNode;
        Node left = head;

        // step 2 - check right part to left part
        while (right!=null) {
            if(left.data!=right.data){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPalindrome ll = new CheckPalindrome();
        ll.addLast(1);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();

        System.out.println(ll.isPalindrome());
    }
}
