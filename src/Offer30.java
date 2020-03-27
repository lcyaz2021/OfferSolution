/**
 * @Author ChenYang Li
 * @Date 2020/3/8 14:51
 * 定义栈数据结构 同时实现push pop 和 min函数 要求时间复杂度为O(1)
 **/
public class Offer30 {
    public static class MinStack {
        int [] stack ;
        int [] minStack;
        int minNum;
        int size = 0;
        public MinStack(int n) {
            stack = new int[n];
            minStack = new int[n];
        }
        public void push(int item){
            if(size == 0){
                minNum = item;
            }else {
                if(item < minNum){
                    minNum = item;
                }
            }
            stack[size] = item;
            minStack[size] = minNum;
            size ++;
        }
        public int pop(){
            if(size == 0){
                return -1;
            }
            return stack[size--];
        }
        public int min(){
            if(size == 0){
                return -1;
            }
            return minStack[size - 1];
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack(10);
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(4);
        stack.pop();
        stack.pop();

        System.out.println("stack.min() = " + stack.min());
    }
}
