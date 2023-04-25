public class NodeMich {

    @ToString
    class ListNodes {
        int val;
        ListNodes next;

        public ListNodes(int val) {
            this.val = val;
        }

        public static void main(String[] args) {
            ListNodes l1 = new ListNodes(1);
            l1.next = new ListNodes(3);

            ListNodes l2 = new ListNodes(2);

            ListNodes res = mergeTwo(l1, l2);
            System.out.println(res);
        }

        /**
         * 1 -> 2 -> 3
         * 4 -> 5 -> 6
         * output 1 - 2 - 3 - 4 - 5 - 6
         *
         * 1 -> 2 - > 7
         * 3 -> 3 -> 11
         * output 1 - 2 - 3 - 3 - 7 - 11
         */

        public static ListNodes mergeTwo(ListNodes l1, ListNodes l2) {
            ListNodes tempNode = new ListNodes(0);
            ListNodes currentNode = tempNode;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    currentNode.next = l1;
                    l1 = l1.next;
                } else {
                    currentNode.next = l2;
                    l2 = l2.next;
                }

                currentNode = currentNode.next;
            }
            if (l1 != null) {
                currentNode.next = l1;
            }

            if (l2 != null) {
                currentNode.next = l2;
            }

            return tempNode.next;
        }
    }
}
