package stacks.usingLL;

public class StackImpl {
    Node top;
    Node bottom;
    int length;

    protected StackImpl(){
        top = null;
        bottom = null;
        length = 0;
    }

    public void peek(){
        if(length==0){
            System.out.println("Empty stack!!");
            return;
        }
        Node current = this.top;
        Object peekValue = current.value;
        System.out.println("Peek (top value) of stack is " + peekValue.toString());
    }

    public void push(Object value) {
        Node newNode = new Node(value);
        if (length == 0) {
            top = newNode;
            bottom = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        length++;
    }

    public void pop(){
        System.out.println("Popping");
        if(length==0){
            System.out.println("Stack underflow");
        } else if (length==1){
            top = null;
            bottom = null;
        }
        else {
            top = top.next;
        }
        length--;
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        stack.peek();
        stack.pop();
        stack.pop();

        System.out.println("After popping");
        stack.peek();
    }
}
