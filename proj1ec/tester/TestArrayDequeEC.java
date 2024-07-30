package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {

    @Test
    public void addFirstTest1() {
        String message = "";
        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> rightArray = new ArrayDequeSolution<>();

        for (int i = 0; i < 100; i++) {
            int randomNumber = StdRandom.uniform(1000);
            testArray.addFirst(randomNumber);
            rightArray.addFirst(randomNumber);
            message = message + "addFirst(" + Integer.toString(randomNumber) + ")\n";
        }

        for (int i = 0; i < 100; i++) {
            message = message + "removeFirst()\n";
            assertEquals(message, testArray.removeFirst(), rightArray.removeFirst());
        }
    }

    @Test
    public void addFirstTest2() {
        String message = "";
        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> rightArray = new ArrayDequeSolution<>();

        for (int i = 0; i < 100; i++) {
            int randomNumber = StdRandom.uniform(1000);
            testArray.addFirst(randomNumber);
            rightArray.addFirst(randomNumber);
            message = message + "addFirst(" + Integer.toString(randomNumber) + ")\n";
        }

        for (int i = 0; i < 100; i++) {
            message = message + "removeLast()\n";
            assertEquals(message, testArray.removeLast(), rightArray.removeLast());
        }
    }

    @Test
    public void addLastTest1() {
        String message = "";
        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> rightArray = new ArrayDequeSolution<>();

        for (int i = 0; i < 100; i++) {
            int randomNumber = StdRandom.uniform(1000);
            testArray.addLast(randomNumber);
            rightArray.addLast(randomNumber);
            message = message + "addFirst(" + Integer.toString(randomNumber) + ")\n";
        }

        for (int i = 0; i < 100; i++) {
            message = message + "removeFirst()\n";
            assertEquals(message, testArray.removeFirst(), rightArray.removeFirst());
        }
    }

    @Test
    public void addLastTest2() {
        String message = "";
        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> rightArray = new ArrayDequeSolution<>();

        for (int i = 0; i < 100; i++) {
            int randomNumber = StdRandom.uniform(1000);
            testArray.addLast(randomNumber);
            rightArray.addLast(randomNumber);
            message = message + "addFirst(" + Integer.toString(randomNumber) + ")\n";
        }

        for (int i = 0; i < 100; i++) {
            message = message + "removeLast()\n";
            assertEquals(message, testArray.removeLast(), rightArray.removeLast());
        }
    }
}
