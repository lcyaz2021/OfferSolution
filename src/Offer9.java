import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用两个栈实现队列的功能
 */

public class Offer9 {
    static class NQueue{
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        public void insert(int x){
            stack1.push(x);
        }

        public int del_head(){
            if(!stack2.empty()){
                Integer p = stack2.pop();
                return p;
            }
            if(stack1.empty()){
                throw new RuntimeException("队列中没有元素");
            }
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        NQueue nQueue = new NQueue();
        nQueue.insert(123);
        nQueue.insert(456);
        System.out.println(nQueue.del_head());
        System.out.println(nQueue.del_head());
    }

}
