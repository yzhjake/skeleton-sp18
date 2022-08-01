import javax.swing.plaf.BorderUIResource;

public class LinkedListDeque <T> {
    private Node sentinel;
    private int size;

    public  class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(sentinel,null, sentinel;
        size = 0;
    }

    public LinkedListDeque(T x) {
        size = 1;
        sentinel = new Node(sentinel,null, sentinel);
        sentinel.next = new Node(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, item, sentinel.next);
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {return false;}
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size == 0) {
            System.out.print("");
        } else {
            int i = 0;
            Node p = sentinel;
            while (i < size) {
                System.out.print(p.next.item + " ");
                p = p.next;
                i++;
            }
        }
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T x = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return x;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T x = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return x;
    }

    public T get(int index) {
        if (index < 0 || index > size-1) {
            return null;
        }
        int i = 0;
        while (i< index) {
            sentinel = sentinel.next;
        }
        return sentinel.next.item;
    }

    public Node getNode(Node current, int index) {
        if (index == 0) {
            return current.next;
        }
        return getNode(current.next, index-1);
    }

    public T getRecursive(int index) {
        if (index + 1 > size) {
            return null;
        }
        return getNode(sentinel, index).item;
    }
}
