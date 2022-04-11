package customCollections;

public class CustomList<E> implements CustomListInterface<E> {
    private static final int DEFAULT_CAPACITY = 10;
    public static final int DEFAULT_CAPACITY_STEP = 5;
    private Object[] elementData;
    private int currentId;
    private int maxSize;

    public CustomList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.maxSize = 0;
        this.currentId = 0;
    }

    public CustomList(int capacity) {
        if (capacity < 0) {
            capacity = 0;
        }
        this.elementData = new Object[capacity];
        this.maxSize = 0;
        this.currentId = 0;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        if (elementData.length > maxSize) {
            elementData = copy(elementData, maxSize);
            currentId = maxSize;
        }
    }

    public boolean add(E object) {
        if (currentId == maxSize && currentId != 0) {
            System.out.println("limit reached");
            return false;
        }
        if (currentId == elementData.length) {
            elementData = grow();
        }
        elementData[currentId] = object;
        currentId++;
        System.out.println(elementData.length);
        return true;
    }

    public void addAll(CustomList object) {
        for (int i = 0; i < object.elementData.length; i++) {
            if (currentId == maxSize && currentId != 0) {
                System.out.println("limit reached");
                break;
            }
            if (currentId == elementData.length) {
                elementData = grow();
            }
            elementData[currentId] = object.get(i);
            if (elementData[currentId] != null) {
                currentId++;
            }
        }
    }

    public void addAll(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }

    }

    private Object[] grow() {
        int newCapacity = elementData.length + DEFAULT_CAPACITY_STEP;
        if (maxSize != 0 && newCapacity > maxSize) {
            newCapacity = maxSize;
        }
        return copy(elementData, newCapacity);
    }

    private Object[] copy(Object[] oldElementData, int newLength) {
        Object[] newElementData = new Object[newLength];
        for (int i = 0; i < oldElementData.length && i < newLength; i++) {
            newElementData[i] = oldElementData[i];
        }
        return newElementData;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        if (index > elementData.length) {
            System.out.println("too big index");
            return null;
        }
        E interim =(E) elementData[index];
        elementData[index] = element;
        return interim;
    }

    public Object remove(int index) {
        if (index > elementData.length) {
            System.out.println("too big index");
            return null;
        }
        Object interim = elementData[index];
        elementData[index] = null;
        return interim;
    }

    public void clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        currentId = 0;
    }

    public int find(E element) {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public Object[] toArray() {
        return elementData;
    }

    public int size() {
        return currentId;
    }

    public void trim() {
        int counter=0;
        for (Object element : elementData) {
            if (element != null) {
                counter++;
            }
        }
        currentId=counter;
        Object[] newElementData = new Object[counter];
        for (int i=elementData.length-1;i>=0;i--){
            if (elementData[i]!=null){
                newElementData[counter-1]=elementData[i];
                counter--;
            }
        }
        elementData=newElementData;
    }

    private void swap(int nullIndex, int notNullIndex) {
        elementData[nullIndex] = elementData[notNullIndex];
        elementData[notNullIndex] = null;
    }
}