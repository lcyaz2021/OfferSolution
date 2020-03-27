/**
 * @Author ChenYang Li
 * @Date 2020/3/3 13:36
 * O(1)删除链表中的节点
 * 删除链表中的重复节点
 **/
public class Offer18 {
    public static class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        ListNode nl = new ListNode(3);
        l.next.next = nl;
        nl.next = new ListNode(3);
        nl.next.next = new ListNode(4);
        nl.next.next.next = new ListNode(4);
        nl.next.next.next.next = new ListNode(5);
//        deleteNode(l,nl);
//        while(l != null){
//            System.out.println("l.value = " + l.value);
//            l = l.next;
//        }
        deleteDuplicationNode(l);
        while(l != null){
            System.out.println("l.value = " + l.value);
            l = l.next;
        }

    }
    public static void deleteNode(ListNode listHead,ListNode listNode){
        if(listHead == null || listNode == null) return;
        // 要删除的节点不是尾结点
        if(listNode.next != null){
           ListNode pNext = listNode.next;
           listNode.value = pNext.value;
           listNode.next = pNext.next;
           pNext = null;
        }
        // 链表只有一个头结点
        else if(listHead == listNode){
            listNode = null;
            listHead = null;
        }
        // 链表中有多个节点 要删除的是尾结点
        else{
            ListNode pNode = listHead;
            while(pNode.next != listNode){
                pNode = pNode.next;
            }
            pNode.next = null;
            listNode = null;
        }
    }
    public static void deleteDuplicationNode(ListNode listHead){
        if(listHead == null){
            return;
        }
        ListNode pPreNode = null;
        ListNode pNode = listHead;
        while(pNode != null){
            ListNode pNext = pNode.next;
            boolean needDelete = false;
            if(pNext != null && pNext.value == pNode.value){
                needDelete = true;
            }
            if(!needDelete){
                pPreNode = pNode;
                pNode = pNode.next;
            }
            else{
                int value = pNode.value;
                ListNode pToBeDel = pNode;
                while(pToBeDel != null && pToBeDel.value == value){
                    pNext = pToBeDel.next;
                    pToBeDel = null;
                    pToBeDel = pNext;
                }
                if(pPreNode == null){
                    listHead = pNext;
                }else{
                    pPreNode.next = pNext;
                }
                pNode = pNext;
            }
        }
    }
}
