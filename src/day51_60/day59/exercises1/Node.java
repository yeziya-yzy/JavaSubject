package day59.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/18
 */
class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
