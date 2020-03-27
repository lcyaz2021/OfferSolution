import java.util.Stack;

/**
 * @Author ChenYang Li
 * @Date 2020/3/8 16:06
 * 判断压入栈顺序和弹出栈顺序是否符合
 **/
// 搁置 不会做
public class Offer31 {

    public static void main(String[] args) {
        int [] pushList = {1,2,3,4,5};
        int [] popList = {4,5,3,2,1};
        System.out.println(isPopOrder(pushList,popList,5));
    }
    public static boolean isPopOrder(int[] pushOrder, int[] popOrder, int length)
    {
        boolean possible = false;

        if (pushOrder != null && popOrder != null && length > 0)
        {
            int nextPush = 0; // 指向下一个要push的元素的index
            int nextPop = 0;  // 指向下一个要pop的元素的index
            int pop = 0;      // 指向popOrder的首个元素的index
            int push = 0;     // 指向pushOrder的首个元素的index

            Stack<Integer> stackData = new Stack<>();
            while (nextPop - pop < length)
            {
                // 当辅助栈的栈顶元素不是要弹出的元素
                // 先压入一些数字入栈
                while (stackData.size() == 0 || stackData.peek() != popOrder[nextPop])
                {
                    // 如果所有数字都压入辅助栈了，退出循环
                    if (nextPush - push == length)
                    {
                        break;
                    }

                    stackData.push(pushOrder[nextPush]);
                    nextPush++;
                }

                // 说明没有匹配成功
                if (stackData.peek() != popOrder[nextPop])
                {
                    break;
                }

                stackData.pop();
                nextPop++;
            }

            if (stackData.size() == 0 && nextPop - pop == length)
            {
                possible = true;
            }
        }

        return possible;
    }
}
