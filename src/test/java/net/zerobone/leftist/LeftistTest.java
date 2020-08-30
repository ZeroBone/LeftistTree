package net.zerobone.leftist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeftistTest {

    @Test
    void isEmpty() {

        Leftist<Integer> l = new Leftist<>();

        assertTrue(l.isEmpty());

        l.insert(1);

        assertFalse(l.isEmpty());

        assertEquals(new Integer(1), l.deleteMin());

        assertTrue(l.isEmpty());

    }

    @Test
    void insert() {

        Leftist<Integer> l = new Leftist<>();

        for (int i = 100; i >= 1; i--) {
            l.insert(i);
            assertEquals(new Integer(i), l.getMin());
        }

        for (int i = 200; i <= 300; i++) {
            l.insert(i);
            assertEquals(new Integer(1), l.getMin());
        }

    }

    @Test
    void merge() {

        Leftist<Integer> l1 = new Leftist<>();
        Leftist<Integer> l2 = new Leftist<>();

        for (int i = 1; i <= 100; i++) {
            l1.insert(i);
            l2.insert(i < 50 ? i + 200 : i - 100);
        }

        l1.merge(l2);

        for (int i = 0; i < 40; i++) {
            assertEquals(new Integer(-50 + i), l1.getMin());
            assertEquals(new Integer(-50 + i), l1.deleteMin());
        }

    }

}