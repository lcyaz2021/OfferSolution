/**
 * @Author ChenYang Li
 * @Date 2020/3/4 11:21
 * 查找链表中倒数第k个节点
 **/
public class Offer22 {
    public static class ListN{
        int value;
        ListN next;
        public ListN(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListN l = new ListN(1);
        l.next = new ListN(2);
        l.next.next = new ListN(3);
        l.next.next.next = new ListN(4);
        l.next.next.next.next = new ListN(5);
        l.next.next.next.next.next = new ListN(6);
        System.out.println("findK(l,3) = " + findK(l,3).value);
        System.out.println("findK(l,4) = " + findK(l,4).value);
        System.out.println("findK(l,1) = " + findK(l,1).value);
//        System.out.println("findK(l,0) = " + findK(l,0).value);
//        System.out.println("findK(l,10) = " + findK(l,10).value);

    }

    /**
     * 查找倒数第k个节点
     * @param listNode
     * @param k
     * @return
     */
    public static ListN findK(ListN listNode,int k){
        // 健壮性判断
        if(listNode == null || k <=0 )return null;
        ListN pHead = listNode;
        ListN pBehind = null;
        for (int i = 0; i < k - 1; i++) {
            if(pHead.next != null){
                pHead = pHead.next;
            }else{
                return null;
            }
        }
        pBehind = listNode;
        while(pHead.next != null){
            pHead = pHead.next;
            pBehind = pBehind.next;
        }
        return pBehind;

    }
}
