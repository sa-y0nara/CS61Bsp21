package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    private int size;
    private Node sentinel;
    private Node last;

    private class Node {
        Node before;
        T item;
        Node after;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * You can assume that item is never null.
     *
     * @param item Which will be added into first place.
     */
    public void addFirst(T item) {
        Node addInFirst = new Node();
        addInFirst.item = item;
        addInFirst.before = sentinel;
        addInFirst.after = sentinel.after;
        sentinel.after.before = addInFirst;
        sentinel.after = addInFirst;
        this.size++;
        if (addInFirst.after == sentinel) {
            last = addInFirst;
        }
    }

    /**
     * Adds an item of type T to the back of the deque.
     * You can assume that item is never null.
     *
     * @param item Which will be added into last place.
     */
    public void addLast(T item) {
        Node addInLast = new Node();
        addInLast.item = item;
        addInLast.before = this.last;
        last.after = addInLast;
        addInLast.after = sentinel;
        last = addInLast;
        this.size++;
    }

    /**
     * Returns the number of items in the deque.
     *
     * @return The number of the size of the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     *
     * @return The item that just be removed.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node delete = sentinel.after;
            sentinel.after = sentinel;
            sentinel.before = sentinel;
            size = 0;
            last = sentinel;
            return delete.item;
        } else {
            Node delete = sentinel.after;
            sentinel.after.after.before = sentinel;
            sentinel.after = sentinel.after.after;
            size--;
            return delete.item;
        }
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     *
     * @return The item that just be removed.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node delete = sentinel.after;
            sentinel.after = sentinel;
            sentinel.before = sentinel;
            size = 0;
            last = sentinel;
            return delete.item;
        } else {
            Node oldLast = last;
            oldLast.before.after = sentinel;
            sentinel.before = oldLast.before;
            last = oldLast.before;
            size--;
            return oldLast.item;
        }
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * Must not alter the deque!
     *
     * @return The item that stored in the place index.
     */
    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            Node p = sentinel.after;
            int ite = index;
            while (ite > 0) {
                p = p.after;
                ite--;
            }
            return p.item;
        }
    }

    /**
     * The helper for method getRecursive.
     *
     * @param i The .
     * @param p The .
     * @return The .
     */
    private T getRecursiveHelper(int i, Node p) {
        if (i == 0) {
            return p.item;
        } else {
            return getRecursiveHelper(i - 1, p.after);
        }
    }

    /**
     * The method the get item that stored in index.
     *
     * @param index The .
     * @return The .
     */
    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.after);
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    /**
     * Construct method of LinkedListDeque.
     */
    public LinkedListDeque() {
        Node newSentinel = new Node();
        newSentinel.before = newSentinel;
        newSentinel.after = newSentinel;
        newSentinel.item = null;
        this.sentinel = newSentinel;
        this.size = 0;
        this.last = newSentinel;
    }


    public Iterator<T> iterator() {
        return new IteratorClass();
    }

    private class IteratorClass implements Iterator<T> {
        Node p;
        int index;

        IteratorClass() {
            p = sentinel.after;
            index = 0;
        }

        public boolean hasNext() {
            return index < size();
        }

        public T next() {
            Node a = p;
            p = p.after;
            index++;
            return a.item;
        }
    }

    boolean contain(Object c) {
        if (size() == 0 || c.getClass() != get(0).getClass()) {
            return false;
        } else {
            for (int i = 0; i < size(); i++) {
                if (get(i).equals(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        boolean a = o.getClass() != ArrayDeque.class;
        boolean b = o.getClass() != LinkedListDeque.class;
        if (a && b) {
            return false;
        } else {
            if (((Deque<?>) o).size() != this.size()) {
                return false;
            } else {
                for (int i = 0; i < size(); i++) {
                    boolean flag = contain(((Deque<?>) o).get(i));
                    if (!flag) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
