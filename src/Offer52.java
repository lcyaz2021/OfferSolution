/**
 * @Author ChenYang Li
 * @Date 2020/3/23 20:26
 * 输入两个链表，找出他们的第一个公共节点
 **/
public class Offer52 {
    static class ListNode{
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next.next.next = l4;

        ListNode l2 = new ListNode(10);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(8);
        l2.next.next.next = new ListNode(7);
        l2.next.next.next.next = new ListNode(6);
        l2.next.next.next.next.next = new ListNode(5);
        l2.next.next.next.next.next.next = l4;
        l4.next = new ListNode(11);
        l4.next.next = new ListNode(12);
        l4.next.next.next = new ListNode(13);
        System.out.println("findFirstSameNode(l1,l2).value = " + findFirstSameNode(l1,l2).value);
    }
    public static ListNode findFirstSameNode(ListNode l1,ListNode l2){
        int l1Length = getLength(l1);
        int l2Length = getLength(l2);
        ListNode LongList = l1;
        ListNode ShortList = l2;
        int dif = l1Length - l2Length;
        if(l1Length < l2Length){
            LongList = l2;
            ShortList = l1;
            dif = l2Length - l1Length;
        }
        for (int i = 0; i < dif; i++) {
            LongList = LongList.next;
        }
        while(LongList != null && ShortList != null && LongList != ShortList){
            LongList = LongList.next;
            ShortList = ShortList.next;
        }
        ListNode res = LongList;
        return res;
    }

    private static int getLength(ListNode l) {
        ListNode node = l;
        int length = 0;
        while(node != null){
            length ++;
            node = node.next;
        }
        return length;
    }
}
