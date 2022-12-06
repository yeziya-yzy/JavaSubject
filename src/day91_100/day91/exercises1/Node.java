package day91.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/15
 */
class Node {
    int number;
    Node pre;
    Node next;

    public Node(Node pre, int number, Node next) {
        this.number = number;
        this.pre = pre;
        this.next = next;
    }

    public Node(int number) {
        this.number = number;
    }
}
