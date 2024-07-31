package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {
        if (size() == 0) {
            return null;
        } else {
            T max = this.get(0);
            for (int i = 0; i < this.size(); i++) {
                if (comparator.compare(max, this.get(i)) < 0) {
                    max = get(i);
                }
            }
            return max;
        }
    }

    public T max(Comparator<T> c) {
        T max = this.get(0);
        for (int i = 0; i < this.size(); i++) {
            if (c.compare(max, this.get(i)) < 0) {
                max = get(i);
            }
        }
        return max;
    }
}
