package deque;

public class ArrayDeque<T> {
    int size;
    int front;
    int last;
    T[] array;

    /**
     * The method that shows if the deque is empty.
     *
     * @return The true or not of the problem.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * The method that resizes the array to make the size bigger.
     */
    private void resizeBigger() {
        T[] newArray = (T[]) new Object[size * 2];
        if (front <= last) {
            System.arraycopy(array, 0, newArray, 0, size);
        } else {
            System.arraycopy(array, 0, newArray, 0, last + 1);
            System.arraycopy(array, front, newArray, newArray.length - array.length + front, array.length - size);
        }
        array = newArray;
    }

    /**
     * The method that check if the array needs to resize.
     */
    private void checkToResizeBigger(int a) {
        if (front == last) {
            resizeBigger();
        }
    }

    /**
     * The method that will add type T item to the first place.
     *
     * @param item The item that you wanted to add to deque.
     */
    public void addFirst(T item) {
        if (size == 0) {
            array[0] = item;
        } else {
            if (front == 0) {
                front = array.length - 1;
            } else {
                front--;
            }
            checkToResizeBigger(0);
            array[front] = item;
        }
        size++;
    }

    /**
     * The method that will add type T item to the last place.
     *
     * @param item The item that you wanted to add to deque.
     */
    public void addLast(T item) {
        if (size == 0) {
            array[0] = item;
        } else {
            if (last == array.length - 1) {

                last = 0;
            } else {
                last++;
            }

        }
    }

    /**
     * The method that return the value of the item in where is index.
     * @param index The number of index.
     * @return The value of the item in where is index.
     */
    public T get(int index) {
        if (index > size || index < 0) return null;
        int iterator = index;
        int p = front;
        while (iterator != 0) {
            if (p < array.length) p++;
            else p = 0;
            iterator--;
        }
        return array[index];
    }

    /**
     * The method that will print out all items in the deque.
     */
    public void printDeque() {
        int iterator = size;
        int p = front;
        while (iterator != 0) {
            if (p < array.length) p++;
            else p = 0;
            System.out.print(array[p]+" ");
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
     * The method that will remove the item in "first" place and return the value of it.
     *
     * @return The value of the item that just be removed.
     */
    public T removeFirst() {
        if (size == 0) return null;
        T value = array[front];
        array[front] = null;
        if (front == array.length - 1) {
            front = 0;
        } else front++;
        return value;
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
}
