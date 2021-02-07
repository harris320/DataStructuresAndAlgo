package binarySearchTree.BSTImpl;

public class BinarySearchTreeImpl {
    Node rootNode;

    public BinarySearchTreeImpl(){
        this.rootNode=null;
    }

    public void insert(int value){
        Node newNode = new Node(value);
        if(rootNode==null){
            this.rootNode=newNode;
            return;
        }else {
            Node current = rootNode;
            while (true){
                if(value<current.value){
                    //traverse left
                    if(current.left==null){
                        current.left=newNode;
                        return;
                    }
                    current=current.left;
                }else {
                    //traverse right
                    if(current.right==null){
                        current.right=newNode;
                        return;
                    }
                    current=current.right;
                }
            }
        }
    }

    public boolean lookup(int value){
        if(this.rootNode==null){
            return false;
        }
        Node current = this.rootNode;
        while(current!=null){
            if(value<current.value){
                current = current.left;
            } else if (value>current.value){
                current=current.right;
            }else if(value==current.value){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTreeImpl bst = new BinarySearchTreeImpl();

        bst.insert(9);
        bst.insert(6);
        bst.insert(8);
        bst.insert(14);

        boolean found = bst.lookup(11);
        System.out.println("value found : " +found);
    }
}
