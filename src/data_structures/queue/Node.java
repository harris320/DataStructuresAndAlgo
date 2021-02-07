package queue;

public class Node {
    Object value;
    Node next;

    protected Node(Object value){
        this.value=value;
        this.next = null;
    }
}
