package customCollections;

interface CustomListInterface<E> {
    void setMaxSize(int maxSize);

    boolean add(E object);

    void addAll(CustomList object);

    void addAll(E[] objects);

    E set(int index, E element);

    Object remove(int index);

    void clear();

    int find(E element);

    E get(int index);

    Object[] toArray();

    int size();

    void trim();
}
