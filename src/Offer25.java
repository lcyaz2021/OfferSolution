/**
 * @Author ChenYang Li
 * @Date 2020/3/6 16:55
 * 合并两个有序链表
 **/
public class Offer25 {
    public static class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(7);
        l1.next.next.next = new ListNode(11);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(7);
        l2.next.next.next = new ListNode(8);
//        ListNode newL = recuMerge(l1,l2);
        ListNode newL = merge(l1,l2);
        while(newL!=null){
            System.out.println("newL.value = " + newL.value);
            newL = newL.next;
        }
    }

    /**
     * 普通合并
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode merge(ListNode l1,ListNode l2){
        // 非空判断
        if(l1 == null || l2 == null){
            return null;
        }
        ListNode newL = null;
        if(l1.value < l2.value){
            newL = l1;
            l1 = l1.next;
        }else{
            newL = l2;
            l2 = l2.next;
        }
        ListNode newN = newL;
        while(l1 != null && l2 != null){
            if(l1.value < l2.value){
                newN.next = l1;
                l1 = l1.next;
            }else{
                newN.next = l2;
                l2 = l2.next;
            }
            newN = newN.next;
        }
        while(l1 != null){
            newN.next = l1;
            l1 = l1.next;
            newN = newN.next;
        }
        while(l2 != null){
            newN.next = l2;
            l2 = l2.next;
            newN = newN.next;
        }
        return newL;
    }

    /**
     * 递归合并
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode recuMerge(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        else if (l2 == null){
            return l1;
        }
        ListNode pMergeNode = null;
        if(l1.value < l2.value){
            pMergeNode = l1;
            pMergeNode.next = merge(l1.next,l2);
        }else{
            pMergeNode = l2;
            pMergeNode.next = merge(l1,l2.next);
        }
        return pMergeNode;
    }
}
