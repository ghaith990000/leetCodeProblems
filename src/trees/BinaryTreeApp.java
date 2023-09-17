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

    public boolean delete(int key)
    {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while(current.iData != key)
        {
            parent = current;
            if(key < current.iData) // go left?
            {
                isLeftChild = true;
                current = current.leftChild;
            }else { // or go right
                isLeftChild = false;
                current = current.rightChild;
            }

            if(current == null)
                return false;

        }
        // found node to delete

        // 1) if no children, delete it directly
        if(current.leftChild == null && current.rightChild == null)
        {
            if(current == root) // if root
                root = null;    // tree is empty
            else if(isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }

        // if no right child, replace with left subtree
        else if(current.rightChild == null)
        {
            if(current == root)
                root = current.leftChild;
            else if(isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        }
        // if no left child, replace with right subtree
        else if(current.leftChild == null){
            if(current == root)
                root = current.rightChild;
            else if(isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        }else { // two children, so replace with inorder successor
            // get successor of node to delete (current)
            Node successor = getSuccessor(current);

            // connect parent of current to successor instead
            if(current == root)
                root = successor;
            else if(isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;

            // connect successor to current's left child
            successor.leftChild = current.leftChild;
        }

        return true;

    }

    /**
     * returns node with next-highest value after delNode
     * goes to right child, then right child's left descendents
     */
    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != delNode.rightChild)
        {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

}
public class BinaryTreeApp {
    public static void main(String[] args) {
    }
}
