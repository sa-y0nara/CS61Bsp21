package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {


    @Test
    public void smallLDequeTest11() {
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
        for (int i = 0; i < 90000; i++) {
            int a = StdRandom.uniform(100);
            lld1.addLast(a);
            lld2.addLast(a);
        }
        for (int i = 0; i < 900; i++) {
            lld1.removeLast();
            lld1.removeFirst();
            lld2.removeLast();
            lld2.removeFirst();
        }
        assertTrue(lld1.equals(lld2));



    }
}
