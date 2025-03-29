package mx.uv.fiee.iinf.poo.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < 8; i++) {
            int element = ThreadLocalRandom.current().nextInt(10, 100);
            if (ThreadLocalRandom.current().nextBoolean()) {
                deque.offerFirst(element);
                System.out.println("deque.offerFirst(" + element + ") --> deque = " + deque);
            } else {
                deque.offerLast(element);
                System.out.println("deque.offerLast(" + element + ")  --> deque = " + deque);
            }
        }

        System.out.println();
        System.out.println("deque.isEmpty()   = " + deque.isEmpty());
        System.out.println("deque.peekFirst() = " + deque.peekFirst());
        System.out.println("deque.peekLast()  = " + deque.peekLast());
        System.out.println();

        while (!deque.isEmpty()) {
            if (ThreadLocalRandom.current().nextBoolean()) {
                System.out.println("deque.pollFirst() = " + deque.pollFirst() + " --> deque = " + deque);
            } else {
                System.out.println("deque.pollLast()  = " + deque.pollLast() + " --> deque = " + deque);
            }
        }

        System.out.println();
        System.out.println("deque.isEmpty()   = " + deque.isEmpty());
        System.out.println("deque.peekFirst() = " + deque.peekFirst());
        System.out.println("deque.peekLast()  = " + deque.peekLast());
    }
}