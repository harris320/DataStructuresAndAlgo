package queue;

public class QueueImpl {

    Node first;
    Node last;
    int length;

    public QueueImpl(){
        first=null;
        last=null;
        length=0;
    }

    public void enqueue(Object value){
        Node newNode = new Node(value);
        if(length==0){
            first = newNode;
            last = newNode;
        }else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public void peek(){
        if (length==0){
            System.out.println("Empty stack!!");
            return;
        }
        Object peekValue = this.first.value;
        System.out.println("PEEK : First value in queue is " + peekValue.toString() + " with a stack length of " + length);
    }

    public void dequeue(){
        System.out.println("Dequeing...");
        if (length==0){
            System.out.println("Stack underflow!!");
            return;
        }else if (length==1){
            first = null;
            last = null;
        }else {
           this.first = this.first.next;
        }
        length--;
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        queue.enqueue(10);
//        queue.enqueue(20);
//        queue.enqueue(30);

        queue.peek();

        queue.dequeue();

        queue.peek();
    }
}
