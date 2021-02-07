package doubleLinkedList;

public class Node {
    int data;
    Node next;
    Node previous;

    protected Node(int data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

}
