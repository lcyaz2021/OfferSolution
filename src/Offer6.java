import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class Offer6 {
    public static void main(String[] args) {
        method1(); // 栈实现
        method2(); // 递归实现
    }
    static void method1(){
        List<Integer> l = new LinkedList<Integer>();
        for (int i = 0; i < 88; i++) {
            l.add(i);
        }
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        for (int j = 0;j < l.size() ;j++){
            stack.push(l.get(j));
        }
        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
    }
    static void method2(){
        List<Integer> l = new LinkedList<Integer>();
        for (int i = 0; i < 88; i++) {
            l.add(i);
        }
        print(l,0);
    }
    static void print(List<Integer> list,int index){
        if(index == list.size()) return;
        print(list,index + 1);
        System.out.println(list.get(index));
    }
}
