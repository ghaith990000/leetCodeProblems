package trees;

class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData(){
        return data;
    }

    public BinaryTreeNode getLeft(){
        return left;
    }

    public BinaryTreeNode getRight(){
        return right;
    }

    public void setLeft(BinaryTreeNode left){
        this.left = left;
    }

    public void setRight(BinaryTreeNode right){
        this.right = right;
    }

}

class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree(){
        this.root = null;
    }

    public BinaryTreeNode getRoot(){
        return root;
    }

    public void insert(int data){
        root = insertRecursive(root, data);
    }

    private BinaryTreeNode insertRecursive(BinaryTreeNode current, int data){
        if(current == null){
            return new BinaryTreeNode(data);
        }

        if(data < current.getData()){
            current.setLeft(insertRecursive(current.getLeft(), data));
        }else if (data > current.getData()){
            current.setRight(insertRecursive(current.getRight(), data));
        }

        return current;
    }

    public boolean search(int data){
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(BinaryTreeNode current, int data){
        if(current == null){
            return false;
        }

        if(data == current.getData()){
            return true;
        }

        if(data < current.getData()){
            return searchRecursive(current.getLeft(), data);
        }else {
            return searchRecursive(current.getRight(), data);
        }
    }
}
public class BinaryTreeApp {
    public static void main(String[] args)
    {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(10);
        binaryTree.insert(5);
        binaryTree.insert(15);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(12);
        binaryTree.insert(12);
        binaryTree.insert(20);

        BinaryTreeNode root = binaryTree.getRoot();

        System.out.println("binary tree: ");
        printInOrder(root);

        int searchData =  7;
        System.out.println("\nSearching for " + searchData + ": " + binaryTree.search(searchData));

    }

    public static void printInOrder(BinaryTreeNode node){
        if(node != null){
            printInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrder(node.getRight());
        }
    }
}
