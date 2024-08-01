package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {


    @Test
    public void smallLDequeTest11() {
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
        for (int i = 0; i < 9; i++) {
            lld1.addLast(i);
            lld2.addLast(i);
        }

        assertTrue(lld1.equals(lld2));



    }
}
