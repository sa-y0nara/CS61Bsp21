package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class filk {
    @Test
    public void test() {
        for (int i = 0; i < 50000; i++) {
            int a = (int) Math.random();
            assertTrue(Flik.isSameNumber(a,a));
        }
        assertTrue(Flik.isSameNumber(128,128));
    }
}
