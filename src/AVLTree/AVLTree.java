package AVLTree;

import java.util.LinkedList;
import java.util.Queue;
public class AVLTree {
    BinaryNode root;
    public BinaryNode getRoot(){
        return root;
    }

    AVLTree(){
        root = null;
    }

    // Insert values in AVL tree
    void insert(int value){
        root= insert(root, value);
    }

    BinaryNode insert(BinaryNode currentNode, int value){
        if(currentNode == null){
            System.out.println("Successfully inserted: " + value + " in AVL Tree");
            return createNewNode(value);
        }else if(value <= currentNode.getValue()){
            currentNode.setLeft(insert(currentNode.getLeft(), value));
        }else {
            currentNode.setRight(insert(currentNode.getRight(), value));
        }
    }

    private BinaryNode leftRotate(BinaryNode currentNode){
        BinaryNode newRoot = currentNode.getRight();
        currentNode.setRight(currentNode.getRight().getLeft());
        newRoot.setLeft(currentNode);
        currentNode.setHeight(calculateHeight(currentNode));
        newRoot.setHeight(calculateHeight(newRoot));
        return newRoot;
    }

    private BinaryNode rightRotate(BinaryNode currentNode){
        BinaryNode newRoot = currentNode.getLeft();
        currentNode.setLeft(currentNode.getLeft().getRight());
        newRoot.setRight(currentNode);
        currentNode.setHeight(calculateHeight(currentNode));
        newRoot.setHeight(calculateHeight(newRoot));
        return newRoot;
    }

    private int checkBalance(BinaryNode rootLeft, BinaryNode rootRight){
        if((rootLeft == null) && (rootRight == null)){
            return 0;
        }else if(rootLeft == null){
            return -1 * (rootRight.getHeight() + 1);
        }else if(rootRight == null){
            return rootLeft.getHeight() + 1;
        }else {
            return rootLeft.getHeight() - rootRight.getHeight();
        }
    }

    private int calculateHeight(BinaryNode currentNode){
        if(currentNode == null){
            return 0;
        }
        return 1 + Math.max((currentNode.getLeft() != null ? currentNode.getLeft().getHeight(): -1),
                (currentNode.getRight() != null ? currentNode.getRight().getHeight(): -1));
    }

    public BinaryNode createNewNode(int value){
        BinaryNode node = new BinaryNode();
        node.setValue(value);
        node.setHeight(0);
        return node;
    }
}