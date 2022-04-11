package customCollections;

public class CustomLinkedList<E> implements CustomListInterface {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private int maxSize;

    public CustomLinkedList() {
        first = null;
        last = null;
        size = 0;
        maxSize = 0;
    }

    @Override
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        if (size > maxSize) {
            Node newNode = first;
            for (int i = 1; i < maxSize; i++) {
                newNode = newNode.next;
            }
            last = newNode;
            last.next = null;
            size = maxSize;
        }
    }

    @Override
    public boolean add(Object object) {
        if (maxSize != 0 && size >= maxSize) {
            System.out.println("max size reached");
            return false;
        }
        if (size == 0) {
            first = new Node<>(null, (E) object, null);
            last = first;
            size++;
            return true;
        } else if (size == 1) {
            Node<E> newNode = new Node<>(first, (E) object, null);
            first.next = newNode;
            last = newNode;
            size++;
            return true;
        } else if (size > 1) {
            Node<E> newNode = new Node<>(last, (E) object, null);
            last.next = newNode;
            last = newNode;
            size++;
            return true;
        } else
            return false;

    }

    @Override
    public void addAll(CustomList object) {
        Object[] objects = object.toArray();
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    @Override
    public void addAll(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    @Override
    public Object set(int index, Object element) {
        if (index > size) {
            System.out.println("Incorrect index");
            return null;
        }
        Node<E> newNode = first;
        for (int i = 0; i < index; i++) {
            newNode = newNode.next;
        }
        E temp = newNode.item;
        newNode.item = (E) element;
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        return temp;
    }

    public void seeAll() {
        Node newNode = first;
        while (newNode.next != null) {
            System.out.println(newNode.item);
            newNode = newNode.next;
        }
        System.out.println(last.item);
    }


    @Override
    public Object remove(int index) {
        if (index > size) {
            System.out.println("Incorrect index");
            return null;
        }
        Node<E> newNode = first;
        for (int i = 0; i < index; i++) {
            newNode = newNode.next;
        }
        newNode.prev.next = newNode.next;
        newNode.next.prev = newNode.prev;
        size--;
        return newNode.item;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int find(Object element) {
        Node newNode=first;
        int counter=0;
        while (newNode.next!=null){
            if (newNode.item==(E)element){
                return counter;
            }
            newNode=newNode.next;
            counter++;
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        Node<E> newNode = first;
        for (int i = 0; i < index; i++) {
            newNode = newNode.next;
        }
        return newNode.item;
    }

    @Override
    public Object[] toArray() {
        Object[] objects=new Object[size];
        Node node=first;
        for (int i=0;i<size;i++){
            objects[i]=node.item;
            node=node.next;
        }
        return objects;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void trim() {
        Node node=first;
        for (int i=0;i<size;i++){
            if (node.item==null){
                node.prev.next=node.next;
                node.next.prev=node.prev;
                size--;
            }
        }

    }

    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

