package DataStructures.Trees;

import java.util.Stack;

public class AVLTree<T extends Comparable<T>> implements Tree<T>{
    
    private class Node<S extends Comparable<T>> {
        S value;
        Node<S> left;
        Node<S> right;
        int leftHeight;
        int rightHeight;

        public Node(S val) {
            this.value = val;
            left = null;
            right = null;
        }

        public int balanceFactor(){
            return leftHeight - rightHeight;
        }

    }

    private Node<T> root;

    public AVLTree(){
        root = null;
    }

    @Override
    public void insert(T value) {
        Node<T> node = new Node<>(value);
        Node<T> temp = root;
        Stack<Node<T>> stk = new Stack<>();
        while(temp != null){
            if(node.value.compareTo(temp.value) > 0){
                if(temp.left == null){
                    temp.left = node;
                    rebalanceTree(stk);
                    break;
                }else{
                    stk.add(temp);
                    temp = temp.left;
                }
            }else if(node.value.compareTo(temp.value) < 0){
                if (temp.right == null){
                    temp.right = node;
                    rebalanceTree(stk);
                    break;
                } else {
                    stk.add(temp);
                    temp = temp.right;
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
    private void rotateLeft(Node<T> left, Node<T> right){

    }
}