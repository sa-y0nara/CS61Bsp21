package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> testSimple = new AListNoResizing<>();
        testSimple.addLast(4);
        testSimple.addLast(5);
        testSimple.addLast(6);
        assertEquals(6, (int) testSimple.removeLast());
        assertEquals(5, (int) testSimple.removeLast());
        assertEquals(4, (int) testSimple.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> test = new BuggyAList<>();
        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                test.addLast(randVal);
            } else if (operationNumber == 1) {
                int size = L.size();
                int sizeTest = test.size();
                assertEquals(size, sizeTest);
            } else if (operationNumber == 2) {
                if (L.size() != 0 && test.size() != 0) {
                    int remove1 = L.removeLast();
                    int remove2 = test.removeLast();
                    assertEquals(remove1, remove2);
                }
            } else {
                if (L.size() != 0 && test.size() != 0) {
                    int get1 = L.getLast();
                    int get2 = test.getLast();
                    assertEquals(get1, get2);
                }
            }
        }
    }
}
