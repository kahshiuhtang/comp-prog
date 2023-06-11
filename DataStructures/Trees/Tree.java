package DataStructures.Trees;

public interface Tree<T> {
    public void insert(T value);

    public void delete(T value);

    public boolean find(T value);

    public String print();
}
