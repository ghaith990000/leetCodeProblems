package trees;

class Node {
    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public void displayNode()
    {
        System.out.print('{');
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("} ");
    }

}

class Tree {
    private Node root;

    public Tree(){
        root = null;
    }

    public Node find(int key){
        Node current = root;
        while(current.iData != key){
            if(key < current.iData)
                current = current.leftChild;
            else
                current = current.rightChild;

            if(current == null)
                return null;
        }
        return current;
    }

    public void insert(int id, double dd)
    {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if(root == null)
            root = newNode;
        else{
            Node current = root;
            Node parent;
            while(true)
            {
                parent = current;
                if(id < current.iData) { // go left
                    current = current.leftChild;
                    if(current==null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else{ // go right
                    current = current.rightChild;
                    if(current == null)
                    {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

}
public class BinaryTreeApp {
    public static void main(String[] args) {
    }
}
