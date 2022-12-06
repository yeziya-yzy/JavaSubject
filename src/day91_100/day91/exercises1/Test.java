package day91.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/15
 */
public class Test {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(5);
        System.out.println(myCircularDeque.insertFront(7));
        System.out.println(myCircularDeque.insertLast(0));
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.insertLast(3));
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.insertFront(9));
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.getRear());
    }
}
