package doubleLinkedList;

import java.util.Arrays;

public class DoubleLinkedListImpl {

    Node head;
    Node tail;
    int length;

    public DoubleLinkedListImpl(int value){
        this.head = new Node(value);
        this.tail = head;
        length =1;
    }

    public int getLength(){
        return this.length;
    }

    public void append(int value){
        Node newNode = new Node(value);
        newNode.previous = this.tail;
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
        length++;
    }

    public int[] printList(){
        int[] list = new int[length];
        int i =0;
        Node current = head;
        while (current!=null){
            list[i] = current.data;
            current = current.next;
            i++;
        }
        return list;
    }

    public void insert(int index, int value){
        if(index<0 || index>length){
            System.out.println("index out of bounds");
        }
        if(index==0){
            prepend(value);
        }else if(index==length){
            append(value);
        }else {
            Node newNode = new Node(value);
            int i=0;
            Node current = head;
            while (i<index-1){
                current = current.next;
                i++;
            }
            Node nextNode = current.next;

            current.next = newNode;
            newNode.previous = current;

            newNode.next = nextNode;
            nextNode.previous = newNode;

            length++;
        }
    }

    public void remove(int index){
        if(index<0 || index>length){
            System.out.println("index out of bounds");
        }
        if(index==0){
            Node nextNode = head.next;
            head.next = null;
            nextNode.previous = null;
            this.head = nextNode;
            length--;
        }else {
            Node current = head;
            int i=0;
            while (i<index-1){
                current = current.next;
                i++;
            }
            if(i==length-2){
                current.next = null;
                tail.previous = null;
                tail = current;
                length--;
            } else {
                Node nextNode = current.next.next;
                current.next = nextNode;
                nextNode.previous = current;
                length--;
            }
        }
    }

    public static void main(String[] args) {
        DoubleLinkedListImpl linkedList = new DoubleLinkedListImpl(10);

        linkedList.append(20);
        linkedList.prepend(50);
        linkedList.prepend(30);
        linkedList.prepend(90);
        linkedList.append(100);
        linkedList.append(150);
        linkedList.append(200);

        System.out.println("length: " + linkedList.getLength());
        System.out.println("List" + Arrays.toString(linkedList.printList()));
        System.out.println("\n Inserting....");
        linkedList.insert(6,60);

        System.out.println("\n After Inserting....");
        System.out.println("length: " + linkedList.getLength());
        System.out.println("List" + Arrays.toString(linkedList.printList()));

        System.out.println("\n Removing....");
        linkedList.remove(8);

        System.out.println("\n After Removing....");
        System.out.println("length: " + linkedList.getLength());
        System.out.println("After removing" + Arrays.toString(linkedList.printList()));
    }
}
