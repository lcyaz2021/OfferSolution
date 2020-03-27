/**
 * @Author ChenYang Li
 * @Date 2020/3/4 11:34
 * 如果一个链表包含环 找出链表的环的入口节点
 **/
public class Offer23 {
    public static class Node{
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Node l = new Node(1);
        l.next = new Node(2);
        Node n = new Node(3);
        l.next.next = n;
        l.next.next.next = new Node(4);
        l.next.next.next.next = new Node(5);
        l.next.next.next.next.next = new Node(6);
        l.next.next.next.next.next.next = n;
        System.out.println("n = " + n);
        System.out.println("findEntryNode(l) = " + findEntryNode(l));
        System.out.println(n == findEntryNode(l));
    }

    /**
     * 使用快慢指针找出链表中两指针相遇的节点
     * @return
     */
    public static Node meetingNode(Node pHead){
        if(pHead == null) return null;
        Node pSlow = pHead;
        if(pSlow.next == null) return pHead;
        Node pFast = pHead.next;
        while(pFast != null && pSlow != null){
            if(pFast == pSlow){
                return pFast;
            }
            pSlow = pSlow.next;
            pFast = pFast.next;
            if(pFast != null){
                pFast = pFast.next;
            }
        }
        return null;
    }

    /**
     * 根据相遇的节点找出环的节点数目 并找到环的入口节点
     * @param pHead
     * @return
     */
    public static Node findEntryNode(Node pHead){
        Node meetingNode = meetingNode(pHead);
        if(meetingNode == null) return null;
        // 计算环中节点数量
        int nodesInLoop = 1;
        Node pNode = meetingNode;
        while(pNode.next != meetingNode){
            pNode = pNode.next;
            nodesInLoop++;
        }
        // 先移动pNode1 次数为环中节点个数
        Node pNode1 = pHead;
        for (int i = 0; i < nodesInLoop; i++) {
            pNode1 = pNode1.next;
        }
        Node pNode2 = pHead;
        while(pNode1 != pNode2){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }
}
