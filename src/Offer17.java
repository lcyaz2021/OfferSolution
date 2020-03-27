import java.util.Arrays;

/**
 * @Author ChenYang Li
 * @Date 2020/3/3 11:30
 * 输入数字n 按顺序打印从1到最大n位的十进制数,比如输入3 打印 1,2,3,…………,999
 **/
public class Offer17 {
    public static void main(String[] args) {
//        printN(5); // 非递归
        recursionPrintN(5); // 递归
    }

    /**
     * 普通解法
     * @param n
     */
    public static void printN(int n){
        if(n <= 0) return;
        char [] chars = new char[n];
        Arrays.fill(chars, '0');
        while(Increment(chars)){
            print(chars);
        }
    }

    /**
     * 计算当前数值
     * @param chars
     * @return
     */
    public static boolean Increment(char[] chars){
        boolean f = true;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '9'){
                continue;
            }else{
                f = false;
                break;
            }
        }
        if(f) return false;
        for (int i = chars.length - 1; i > 0; i--) {
            if(chars[i] < '9'){
                chars[i] = (char)((chars[i]) + 1);
                return true;
            }
            else{
                if(chars[i-1] == '9'){
                    chars[i] = '0';
                    chars[i-1] = (char)(chars[i-1] + 1);
                    continue;
                }else{
                    chars[i] = '0';
                    chars[i-1] = (char)(chars[i-1] + 1);
                    return true;
                }
            }
        }
        return true;
    }

    /**
     * 打印 除去前面的0
     * @param chars
     */
    public static void print(char[] chars){
        boolean f = true;
        for (char c : chars) {
            if(c == '0' && f){
                continue;
            }else{
                f = false;
                System.out.print(c);
            }
        }
        System.out.println();
    }

    /**
     * 递归实现
     */
    public static void recursionPrintN(int n){
        if (n <= 0) return;
        char[] chars = new char[n];
        for (int i = 0; i < 10; i++) {
            chars[0] = (char)(i + '0');
            printMaxOfRecurison(chars,n,0);
        }

    }

    /**
     * 递归主体
     * @param chars
     * @param length
     * @param index
     */
    public static void printMaxOfRecurison(char[] chars,int length,int index) {
        if (index == length - 1){
            print(chars);
            return;
        }
        for (int i = 0; i < 10; i++) {
            chars[index + 1] = (char)(i + '0');
            printMaxOfRecurison(chars,length,index + 1);
        }
    }
}
