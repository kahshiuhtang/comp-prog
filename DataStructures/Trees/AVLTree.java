package DataStructures.Trees;

import java.util.Stack;

public class AVLTree<T extends Comparable<T>> implements Tree<T>{
    
    private class Node<S extends Comparable<T>> {
        S value;
        Node<S> left;
        Node<S> right;
        Node<S> parent;
        int balanceFactor;

        public Node(S val) {
            this.value = val;
            left = null;
            right = null;
            parent = null;
        }

        public int balanceFactor(){
            return balanceFactor;
        }
    }

    private Node<T> root;

    public AVLTree(){
        root = null;
    }

    @Override
    public void insert(T value) {
        Node<T> node = new Node<>(value);

        if(root == null){
            root = new Node<>(value);
            return;
        }
        Node<T> temp = root;
        Stack<Node<T>> stk = new Stack<>();
        while(temp != null){
            if(node.value.compareTo(temp.value) > 0){
                if(temp.left == null){
                    temp.left = node;
                    node.parent = temp.left;
                    rebalanceTree(stk);
                    break;
                }else{
                    stk.add(temp);
                    temp = temp.left;
                    temp.balanceFactor++;
                }
            }else if(node.value.compareTo(temp.value) < 0){
                if (temp.right == null){
                    temp.right = node;
                    node.parent = temp.right;
                    rebalanceTree(stk);
                    break;
                } else {
                    stk.add(temp);
                    temp = temp.right;
                    temp.balanceFactor--;
                }
            }else{
              //   
            }
        }
    }
    
    private void rebalanceTree(Stack<Node<T>> stk){
        while(!stk.empty()){
            Node<T> node = stk.pop();
            if (Math.abs(node.balanceFactor()) > 1) {

            }
        }
        return;
    }

    @Override
    public void delete(T value) {
    
    }

    @Override
    public boolean find(T value) {
        return false;
    }

    @Override
    public String print() {
        return "";
    }
    private Node<T> rotateLeft(Node<T> X, Node<T> Z){
        Node<T> t = Z.left;
        X.right = t;
        if(t != null){
            t.parent = X;
        }
        Z.left = X;
        X.parent = Z;
        if(Z.balanceFactor() == 0){
            X.balanceFactor = 1;
            Z.balanceFactor = -1;
        }else{
            X.balanceFactor = 0;
            Z.balanceFactor = 0;
        }
        return Z;
    }
    
    private Node<T> rotateRight(Node<T> X, Node<T> Z){
        return null;
    }

    private Node<T> rotateLeftRight(Node<T> X, Node<T> Z) {
        return null;
    }

    private Node<T> rotateRightLeft(Node<T> X, Node<T> Z) {
        Node<T> Y = Z.left;
        Node<T> t = Y.right;
        Z.left = t;
        if(t != null){
            t.parent = Z;
        }
        Z.parent = Y;
        Node<T> t1 = Y.left;
        X.right = Z;
        if(t1 != null){
            t1.parent = X;
        }
        Y.left = X;
        X.parent = Y;
        if(Y.balanceFactor == 0){
            X.balanceFactor = 0;
            Z.balanceFactor = 0;
        }else{
            if(Y.balanceFactor > 0){
                X.balanceFactor = -1;
                Z.balanceFactor = 0;
            }else{
                X.balanceFactor = 0;
                Z.balanceFactor = 1;
            }
        }
        Y.balanceFactor = 0;
        return Y;
    }

    private int height(Node<T> node){
        if(node == null){
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}