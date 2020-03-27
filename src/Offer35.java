/**
 * @Author ChenYang Li
 * @Date 2020/3/9 12:18
 * 复杂链表复制
 **/
public class Offer35 {
    static class ComplexLinked{
        int value;
        ComplexLinked next;
        ComplexLinked sibling;
        public ComplexLinked(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ComplexLinked l1 = new ComplexLinked(1);
        l1.next = new ComplexLinked(2);
        l1.next.next = new ComplexLinked(3);
        l1.next.next.next = new ComplexLinked(4);
        l1.next.next.next.next = new ComplexLinked(5);
        ComplexLinked l2 = l1.next.next.next.next;
        l1.next.next.next.next.next = new ComplexLinked(6);
        l1.next.next.next.next.next.sibling = l2;
        l1.next.next.next.next.next.next = new ComplexLinked(7);
        ComplexLinked clone = clone(l1);
        while(clone != null){
            System.out.print(clone.value + " ");
            if(clone.sibling != null){
                System.out.print("sibling:" + clone.sibling.value);
            }
            System.out.println();
            clone = clone.next;
        }
    }


    public static ComplexLinked clone(ComplexLinked complexLinked){
        firstAddToLinked(complexLinked);
        secondAddSiblingPoint(complexLinked);
        return thirdSplit(complexLinked);
    }

    public static void firstAddToLinked(ComplexLinked complexLinked){
        ComplexLinked linked = complexLinked;
        if(linked == null){
            return;
        }
        // 在原链表中每个节点后面追加一个相同得节点
        while(linked != null){
            ComplexLinked temp = new ComplexLinked(linked.value);
            temp.sibling = null;
            temp.next = linked.next;
            linked.next = temp;
            linked = temp.next;
        }
    }
    public static void secondAddSiblingPoint(ComplexLinked complexLinked){
        ComplexLinked linked = complexLinked;
        // 遍历新链表将每个新节点得sibling指向正确得节点
        while(linked != null){
            ComplexLinked temp = linked.next;
            if(linked.sibling != null){
                // 指向
                temp.sibling = linked.sibling.next;
            }
            linked = temp.next;
        }
    }
    public static ComplexLinked thirdSplit(ComplexLinked complexLinked){
        ComplexLinked linked = complexLinked;
        ComplexLinked cloneHead = null;
        ComplexLinked cloneNode = null;
        // 链表拆分
        if(linked != null){
            cloneHead = cloneNode = linked.next;
            linked.next = cloneNode.next;
            linked = linked.next;
        }
        while(linked != null){
            cloneNode.next = linked.next;
            cloneNode = cloneNode.next;
            linked.next = cloneNode.next;
            linked = linked.next;
        }
        return cloneHead;
    }
}
