package stacks.usingArrays;

public class StackImplUsingArray {
    Object[] arr;
    int length;

    public StackImplUsingArray(){
        arr = new Object[10];
        length=0;
    }

    public void push(Object value){
        if(length==0){
            arr[0] = value;
        }else if(length==10){
            System.out.println("Stack overflow!!");
            return;
        }else {
            arr[length] = value;
        }
        length++;
    }

    public void peek(){
        if(length==0){
            System.out.println("Empty stack!!");
            return;
        }
        System.out.println("PEEK : Top value in stack is " + arr[length-1] + " with a stack length of " + length);
    }

    public void pop(){
        System.out.println("Popping");
        if(length==0){
            System.out.println("Stack underflow!!");
            return;
        }else {
            arr[length-1] = null;
            length--;
        }
    }

    public static void main(String[] args) {

        StackImplUsingArray stack = new StackImplUsingArray();

        stack.push(10);
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
