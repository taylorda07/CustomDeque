import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

public class CustomDeque implements Iterable<Integer> {

    private final Deque<Integer> deque;

    public CustomDeque() {
        deque = new LinkedList<>();
    }

    public void enqueueFront(int data) {
        deque.addFirst(data);
    }

    public void enqueueRear(int data) {
        deque.addLast(data);
    }

    public int dequeueFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return deque.removeFirst();
    }

    public int dequeueRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return deque.removeLast();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Integer> {

        private final Iterator<Integer> iterator =
                deque.iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return iterator.next();
        }
    }

    public void display() {
        Iterator<Integer> iterator = iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        CustomDeque customDeque = new CustomDeque();
        Random random = new Random();

        int[] numbers = new int[10];

        System.out.println("CSC 400 – Module 6");
        System.out.println("Option 2: Custom Deque ADT");
        System.out.println("--------------------------");

        System.out.println("\nTen Random Integers:");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100) + 1;
            System.out.print(numbers[i] + " ");
        }

        System.out.println("\n\nInserting into Deque:");

        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                customDeque.enqueueFront(numbers[i]);
            } else {
                customDeque.enqueueRear(numbers[i]);
            }
        }

        customDeque.display();

        System.out.println("\nRemoving Front Element:");
        System.out.println(customDeque.dequeueFront());

        System.out.println("\nRemoving Rear Element:");
        System.out.println(customDeque.dequeueRear());

        System.out.println("\nDeque After Deletions:");
        customDeque.display();

        System.out.println("\nIterator Traversal:");
        Iterator<Integer> iterator =
                customDeque.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\n\nProgram Completed Successfully.");
    }
}
