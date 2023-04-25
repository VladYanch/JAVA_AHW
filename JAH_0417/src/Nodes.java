import java.awt.*;
import java.util.Arrays

public class Nodes {

    public static ListNodes1 list = null;

    public static void main(String[] args) {

        ListNodes1 list1 = new ListNodes1(1);
        list1.next = new ListNodes1(2);
        list1.next.next = new ListNodes1(7);

        ListNodes1 list2 = new ListNodes1(3);
        list2.next = new ListNodes1(3);
        list2.next.next = new ListNodes1(11);

        System.out.println(list1);
        System.out.println(list1.next);
        System.out.println(list1.next.next);

        System.out.println(list2);
        System.out.println(list2.next);
        System.out.println(list2.next.next);

//        System.out.println(mergeTwo(list1, list2).toString());
//        System.out.println(list.toString());
    }
    public static ListNodes1 mergeTwo(ListNodes1 l1, ListNodes1 l2) {
//        ListNodes1 list = null;
            if (l1.next == null && l2.next == null) return list;
            if (l1 == null) list = new ListNodes1(l2.val);
            if (l2 == null) list = new ListNodes1(l1.val);
            if (l1.val <= l2.val) list = new ListNodes1(l1.val);
            else list = new ListNodes1(l2.val);
            System.out.println(list);
            mergeTwo(l1.next, l2.next);
        return list;
    }

//    public static void addOne(ListNodes1 node, int num) {
//        node = new ListNodes1(num);
////        node.next = null;
//    }
}

@toString
class ListNodes1 {
    int val;
    ListNodes1 next;

    public ListNodes1(int val) {
        this.val = val;
    }

//    @Override
//    public String toString() {
//        return "ListNodes{" +
//                "val=" + val +
//                '}';
//    }
}
