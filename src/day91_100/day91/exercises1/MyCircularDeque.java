package day91.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/15
 */
class MyCircularDeque {
    private int maxSize;
    private int size;
    private Node head;
    private Node tail;

    public MyCircularDeque(int k) {
        maxSize = k;
        head = null;
        tail = null;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        ++size;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        if (tail == null) {
            head = node;
        } else {
            node.pre = tail;
            tail.next = node;
        }
        tail = node;
        ++size;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = head.next;
        if (head != null) {
            head.pre = null;
        } else {
            tail = null;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = tail.pre;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (head == null) {
            return -1;
        }
        return head.number;
    }

    public int getRear() {
        if (tail == null) {
            return -1;           // 9 7 0 3
        }
        return tail.number;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}