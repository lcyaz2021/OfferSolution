/**
 * @Author ChenYang Li
 * @Date 2020/3/27 11:31
 * 圆圈中最后剩下的数字
 * 0,1，·····，n-1这几个数字排成一个圆圈，每次从圆圈里删除一第m个数字，求最后剩下的数字
 * {0,1,2,3,4} 删除得前四个分别为2,0,4,1 最后剩下的是3
 * 约瑟夫环
 **/
public class Offer62 {
    public static void main(String[] args) {
        CirLinked last = findLast(4, 3);
        System.out.println(last.value);
        System.out.println(getLast(4,3));
    }
    static class CirLinked{
        int value;
        CirLinked next;
        public CirLinked(int value){
            this.value = value;
        }
    }

    /**
     * 环形链表模拟圆圈
     * @param n
     * @param m
     * @return
     */
    public static CirLinked findLast(int n,int m){
        if(n <= 0){
            return null;
        }
        CirLinked l = new CirLinked(0);
        if(n == 1){
            return l;
        }
        CirLinked node = l;
        for (int i = 1; i <= n; i++) {
            node.next = new CirLinked(i);
            node = node.next;
        }
        node.next = l;
        return findCore(l,n,m);
    }

    private static CirLinked findCore(CirLinked cirLinked, int n,int m) {
        CirLinked fast = cirLinked.next;
        CirLinked slow = cirLinked;
        for (int i = 0; i < m - 2; i++) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = fast.next;
        fast = slow.next;
        n--;
        while(n > 0){
            for (int i = 0; i < m - 1; i++) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = fast.next;
            fast = slow.next;
            n--;
        }
        return fast;
    }

    /**
     * 数学公式循环
     * @param n
     * @param m
     * @return
     */
    public static int getLast(int n,int m){
        n++;
        if(n < 1 || m < 1){
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
