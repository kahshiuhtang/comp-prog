package DataStructures.Stack;

public class Stack<T> {
    private Object arr[];
    private int size = 0;
    private int capacity = 16;

    public Stack(){
        arr = new Object[capacity];
    }
    public void push(T value){
        if(size == capacity){
            @SuppressWarnings("unchecked")
            Object temp[] = (T[])new Object[capacity * 2];
            System.arraycopy(arr, 0, temp, 0, capacity);
            capacity = capacity * 2;
            this.arr = temp;
        }
        arr[size] = value;
        size++;
    }
    public T pop(){
        if(size > 0){
            size--;
            return (T) this.arr[size];
        }
        return null;
    }
    public int size(){
        return this.size;
    }
    public int capacity(){
        return this.capacity;
    }
}
