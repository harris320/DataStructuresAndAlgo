package linkedLists;

import java.util.Arrays;

public class LinkedListImpl {

    Node head;
    Node tail;
    int length;

    public LinkedListImpl(int value){
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void append(int value){
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public void insert(int index, int value) {
        if(index>length || index<0){
            System.out.println("Index out of bounds than LinkedList size");
        }
        if(index==0){
            this.prepend(value);
        } else if(index==length){
            this.append(value);
        } else {
            Node newNode = new Node(value);
            Node current = this.head;
            int i =0;
            while (i<index-1){
                current = current.next;
                i++;
            }
            Node nextNode = current.next;
            current.next = newNode;
            newNode.next = nextNode;
            length++;
        }
    }

    public void remove(int index){
        if(index>length-1 || index<0){
            System.out.println("Index out of bounds than LinkedList size");
        }
        if(index==0){
            head = head.next;
            length--;
        } else {
            Node current = this.head;
            int i =0;
            while (i<index-1){
                current = current.next;
                i++;
            }
            if(i==length-1){
                tail=current;
                tail.next=null;
                length--;
            }else{
                current.next = current.next.next;
                length--;
            }
        }
    }

    public int getLength(){
        return this.length;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public int[] printList(){
        int[] myList = new int[length];
        Node current = this.head;
        int i=0;
        while (current!=null){
            myList[i] = current.value;
            current = current.next;
            i++;
        }
        return myList;
    }

    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl(10);

        linkedList.append(20);
        linkedList.prepend(50);
        linkedList.prepend(30);
        linkedList.prepend(90);
        linkedList.append(100);

        System.out.println("length: " + linkedList.getLength());
        System.out.println("List" + Arrays.toString(linkedList.printList()));
        System.out.println("\n Inserting....");
        linkedList.insert(6,40);

        System.out.println("\n After Inserting....");
        System.out.println("length: " + linkedList.getLength());
        System.out.println("List" + Arrays.toString(linkedList.printList()));

        System.out.println("\n Removing....");
        linkedList.remove(4);

        System.out.println("\n After Removing....");
        System.out.println("length: " + linkedList.getLength());
        System.out.println("After removing" + Arrays.toString(linkedList.printList()));

    }
}
