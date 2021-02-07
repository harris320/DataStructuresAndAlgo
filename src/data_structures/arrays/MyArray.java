package arrays;

public class MyArray {

    private int length;
    private Object[] data;
    private int capacity;

    public MyArray(){
        length=0;
        capacity=1;
        data = new Object[1];
    }

    public Object get(int index){
        return data[index];
    }

    public void push(Object obj){
        if(length==capacity){
            Object[] tempData = new Object[capacity*2];
            for(int i=0; i<data.length; i++){
                tempData[i] = data[i];
            }
            data = tempData;
            capacity = capacity*2;
        }
        data[length] = obj;
        length++;
    }

    public void pop(){
        if(length>0){
            data[length-1] = null;
            length--;
        }
    }

    public Object popAndReturn(){
        Object popped = data[length-1];

        if(length>0){
            data[length-1] = null;
            length--;
        }
        return popped;
    }

    public Object delete(int index){
        Object deleted = data[index];
        shiftItems(index);
        return deleted;
    }

    public void shiftItems(int index){
        for(int i=index; i<length-1;i++){
            data[i]=data[i+1];
        }
        data[length-1] = null;
        length--;
    }


    public static void main(String[] args) {
        MyArray arr = new MyArray();
        arr.push(3);
        arr.push(5);
        arr.push(2);
        arr.push(7);

        System.out.println("Array formed is :");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr.get(i));
        }

//        arr.pop();
//        System.out.println("After pop :");
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr.get(i));
//        }

        arr.delete(1);
        System.out.println("After deleting index 1 :");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr.get(i));
        }

    }
}
