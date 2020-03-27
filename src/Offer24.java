/**
 * @Author ChenYang Li
 * @Date 2020/3/6 16:46
 * 反转链表
 **/
public class Offer24 {
    public static class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode r = reverse(listNode);
        while(r != null){
            System.out.println(r.value);
            r = r.next;
        }
    }
    public static ListNode reverse(ListNode pHead){
        if(pHead == null){
            return null;
        }
        if(pHead.next == null){
            return pHead;
        }
        ListNode rHead = null;
        ListNode pNode = pHead;
        ListNode preNode = null;
        while(pNode != null){
            ListNode pNext = pNode.next;
            if(pNext == null){
                rHead = pNode;
            }
            pNode.next = preNode;
            preNode = pNode;
            pNode = pNext;
        }
        return rHead;
    }

}
