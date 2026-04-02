public class MergerSort {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public Node head;
    public Node tail;

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public Node findMid(Node head) {
        // find mid
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeSort(Node head){

        if(head==null || head.next==null){
            return head;
        }

        // find mid
        Node midNode = findMid(head);
        Node rightHead = midNode.next;
        midNode.next=null;
        Node leftPart = mergeSort(head);
        Node rightPart = mergeSort(rightHead);

        return merge(leftPart, rightPart);
    }

    public Node merge(Node head1, Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1!=null && head2!=null) {
            if(head1.data<=head2.data){
                temp.next = head1;
                head1 = head1.next;
            
            }
            else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        while (head1!=null) {
            temp.next = head1;
            head1=head1.next;
            temp = temp.next;
        }
        while (head2!=null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
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
        MergerSort ll = new MergerSort();
        ll.addLast(4);
        ll.addLast(6);
        ll.addLast(5);
        ll.addLast(2);
        ll.addLast(3);
        ll.head = ll.mergeSort(ll.head);
        ll.print();
    }
}
