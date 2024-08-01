package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int size;
    private int front;
    private int last;
    private T[] array;

    private void resize(T[] newArray) {
        if (front <= last) {
            System.arraycopy(array, front, newArray, 0, size);
        } else {
            System.arraycopy(array, front, newArray, 0, array.length - front);
            System.arraycopy(array, 0, newArray, array.length - front, last + 1);
        }
        front = 0;
        last = size - 1;
    }

    /**
     * The method that resizes the array to make the size bigger.
     */
    private void resizeBigger() {
        T[] newArray = (T[]) new Object[size * 2];
        resize(newArray);
        array = newArray;
    }

    /**
     * The method that check if the array needs to resize.
     */
    private void checkToResizeBigger() {
        if (size == array.length) {
            resizeBigger();
        }
    }


    /**
     * The method that pointing the next front place and change the old front index.
     */
    private void changeAddFront() {
        if (size == 0) {
            front = 0;
            last = 0;
        } else {
            if (front == 0) {
                front = array.length - 1;
            } else {
                front--;
            }
        }
    }

    /**
     * The method that will add type T item to the first place.
     *
     * @param item The item that you wanted to add to deque.
     */
    public void addFirst(T item) {
        checkToResizeBigger();
        changeAddFront();
        array[front] = item;
        size++;
    }

    /**
     * The method that pointing the next last place and change the old last index.
     */
    private void changeAddLast() {
        if (size == 0) {
            front = 0;
            last = 0;
        } else {
            if (last == array.length - 1) {
                last = 0;
            } else {
                last++;
            }
        }
    }

    /**
     * The method that will add type T item to the last place.
     *
     * @param item The item that you wanted to add to deque.
     */
    public void addLast(T item) {
        checkToResizeBigger();
        changeAddLast();
        array[last] = item;
        size++;
    }

    /**
     * The method that return the value of the item in where is index.
     *
     * @param index The number of index.
     * @return The value of the item in where is index.
     */
    public T get(int index) {
        if (index > size || index < 0) {
            return null;
        }
        int p = front;
        p += index;
        if (p >= array.length) {
            p -= array.length;
        }
        return array[p];
    }

    /**
     * The method that will print out all items in the deque.
     */
    public void printDeque() {
        int iterator = size;
        int p = front;
        while (iterator != 0) {
            System.out.print(array[p] + " ");
            if (p < array.length) {
                p++;
            } else {
                p = 0;
            }
            iterator--;
        }
        System.out.println();
    }

    /**
     * The method that return the size of items in the deque.
     *
     * @return Number of the items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * The method that called by checkToResizeSmaller to resize the array to make it smaller.
     */
    private void resizeSmaller() {
        T[] newArray = (T[]) new Object[array.length / 2];
        resize(newArray);
        array = newArray;
    }

    /**
     * Check if the array need to be resized.
     */
    private void checkToResizeSmaller() {
        if (4 * size < array.length && array.length > 8) {
            resizeSmaller();
        }
    }

    /**
     * When remove the value in "front" index, the method will be called.
     * It will update the "front" index.
     */
    private void changeRemoveFirst() {
        if (front == array.length - 1) {
            front = 0;
        } else {
            front++;
        }
    }

    /**
     * The method that will remove the item in "front" place and return the value of it.
     *
     * @return The value of the item that just be removed.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T returnValue = array[front];
        array[front] = null;
        changeRemoveFirst();
        size--;
        checkToResizeSmaller();
        return returnValue;
    }

    /**
     * Update the last index.
     */
    private void changeRemoveLast() {
        if (last == 0) {
            last = array.length - 1;
        } else {
            last--;
        }
    }

    /**
     * The method that will remove the item in "last" place and return the value of it.
     *
     * @return The value of the item that just be removed.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T returnValue = array[last];
        array[last] = null;
        changeRemoveLast();
        size--;
        checkToResizeSmaller();
        return returnValue;
    }

    /**
     * Construct method for arraydeque.
     */
    public ArrayDeque() {
        this.size = 0;
        array = (T[]) new Object[8];
        this.front = 0;
        this.last = 0;
    }

    public Iterator<T> iterator() {
        return new IteratorClass();
    }

    private class IteratorClass implements Iterator<T> {
        int index;

        IteratorClass() {
            index = 0;
        }

        public boolean hasNext() {
            return index < size;
        }

        public T next() {
            T returnValue = get(index);
            index++;
            return returnValue;
        }
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        boolean a = o instanceof Deque;
        if (!a) {
            return false;
        } else {
            if (o == this) {
                return true;
            } else {
                if (((Deque<?>) o).size() != this.size()) {
                    return false;
                } else {
                    for (int i = 0; i < size(); i++) {
                        if (!((Deque<?>) o).get(i).equals(this.get(i))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
    }
}


