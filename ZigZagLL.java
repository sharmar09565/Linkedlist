public class ZigZagLL {
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

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node zigZag() {

        // find mid
        Node mid = findMid(head);

        // reverse right half
        Node currNode = mid.next;
        mid.next = null;
        Node prevNode = null;
        Node nextNode;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        Node right = prevNode;
        Node left = head;

        Node zigZaggedLL = new Node(-1);
        Node temp = zigZaggedLL;

        while (left != null && right != null) {
            // add left node
            temp.next = left;
            left = left.next;
            temp = temp.next;

            // add right node
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        if (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        return zigZaggedLL.next;
    }

    public static void main(String[] args) {
        ZigZagLL ll = new ZigZagLL();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.zigZag();
        ll.print();
    }
}
