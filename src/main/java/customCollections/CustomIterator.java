package customCollections;

public class CustomIterator<E> {
    private Object[] elementData;
    private int currentId;

    public CustomIterator(E[] array) {
        elementData = array;
        currentId = 0;
    }

    @SuppressWarnings("unchecked")
    public E next() {
        return (E) elementData[currentId++];
    }

    public boolean hasNext() {
        return currentId == elementData.length - 1;
    }

    public void remove(){

    }
}
