public class Reverse {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("Linked list is null");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverse(){      // O(n)
        Node currNode = tail = head;
        Node preNode = null;
        Node nextNode;

        while (currNode!=null) {
            nextNode = currNode.next;
            currNode.next = preNode;
            preNode  = currNode;
            currNode = nextNode;
        }
        head = preNode;
    }
    public static void main(String[] args) {
        Reverse ll = new Reverse();
        ll.addLast(5);
        ll.addLast(4);
        ll.addLast(8);
        ll.addLast(9);
        ll.addLast(1);
        ll.print();
        ll.reverse();
        ll.print();
    }
}
