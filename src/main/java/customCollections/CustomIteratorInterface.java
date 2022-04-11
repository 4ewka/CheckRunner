package customCollections;

public interface CustomIteratorInterface<E> {
    boolean hasNext();
    E next();
    void remove();
    E addBefore(E object);
    E addAfter(E object);
}
