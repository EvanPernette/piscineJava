package fr.epita.assistants.linkedlist;

public class LinkedList<T extends Comparable<T>> {

    public class Node<B extends Comparable<B>> {
        private B value;
        private Node<B> next;

        public Node(B value) {
            this.value = value;
        }

        public B getValue() {
            return value;
        }

        public Node<B> getNext() {
            return next;
        }

        public void setValue(B value) {
            this.value = value;
        }

        public void setNext(Node<B> next) {
            this.next = next;
        }
    }

    public Node<T> head;
    public int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Inserts the specified element into the list.
     * The elements must be sorted in ascending order.
     * null elements should be at the end of the list.
     *
     * @param e Element to be inserted
     **/
    public void insert(T e) {
        if (head == null) {
            head = new Node<>(e);
            size++;
            return;
        }
        else{
            Node<T> current = head;
            Node<T> previous = null;
            while (current != null && current.getValue() != null && current.getValue().compareTo(e) < 0) {
                previous = current;
                current = current.getNext();
            }
            if (current == null) {
                previous.setNext(new Node<>(e));
                size++;
            }
            else if (current.getValue() == null) {
                current.setValue(e);
                size++;
            }
            else if (current.getValue().compareTo(e) > 0) {
                if (previous == null) {
                    Node<T> newNode = new Node<>(e);
                    newNode.setNext(current);
                    head = newNode;
                    size++;
                }
                else {
                    Node<T> newNode = new Node<>(e);
                    newNode.setNext(current);
                    previous.setNext(newNode);
                    size++;
                }
            }
        }

    }

    /**
     * Returns the n-th element in the list.
     *
     * @param i Index
     * @return The element at the given index
     * @throws IndexOutOfBoundsException if there is no element at this
     *                                   index.
     **/
    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int j = 0; j < i; j++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    /**
     * Removes the first occurrence of the specified element in the list.
     *
     * @param e Element to remove
     * @return returns the element that has been removed or null
     **/
    public T remove (T e) {
        if (head == null) {
            return null;
        }
        else {
            Node<T> current = head;
            Node<T> previous = null;
            while (current != null && current.getValue() != null && current.getValue().compareTo(e) != 0) {
                previous = current;
                current = current.getNext();
            }
            if (current == null) {
                return null;
            }
            else if (current.getValue() == null) {
                return null;
            }
            else if (current.getValue().compareTo(e) == 0) {
                if (previous == null) {
                    head = current.getNext();
                    size--;
                    return current.getValue();
                }
                else {
                    previous.setNext(current.getNext());
                    size--;
                    return current.getValue();
                }
            }
        }
        return null;

    }

    /**
     * Returns the size of the list.
     *
     * @return Number of elements in the list
     **/
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the list.
     **/
    public void clear() {
        while (head != null) {
            remove(head.getValue());
        }
    }
}
