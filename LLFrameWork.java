import java.util.LinkedList;

public class LLFrameWork {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addLast(1);
        ll.addLast(3);
        ll.addFirst(2);

        System.out.println(ll);

        ll.removeFirst();
        ll.removeFirst();

        System.out.println(ll);
    }
}
