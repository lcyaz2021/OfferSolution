/**
 * @Author ChenYang Li
 * @Date 2020/3/26 20:49
 * 翻转字符串
 * 翻转字符串但 单词顺序不变
 * 例如 I am a student.
 * 反转后 student. a am I
 **/
public class Offer58 {
    public static void main(String[] args) {
        String s = "I am a student.";
        char[] chars = reverse(s);
        for (char c : chars) {
            System.out.print(c);
        }
        System.out.println();
        char[] chars1 = leftRotate(s, 2);
        for (char c : chars1) {
            System.out.print(c);
        }
    }
    public static char[] reverse(String string){
        if(string == null){
            return null;
        }
        char [] chars = string.toCharArray();
        // 第一次翻转先翻转整个句子
        reverseCore(chars,0,chars.length - 1);
        // 逐个翻转每个单词
        int start = 0,end = 0;
        while(start < chars.length){
            if(chars[start] == ' '){
                start ++;
                end ++;
            }else if(end == chars.length || chars[end] == ' '){ // 第一个判定条件要在前 否则可能抛异常
                reverseCore(chars,start,--end);
                start = ++end;
            }else{
                end ++;
            }
        }
        return chars;
    }

    /**
     * 返回字符串左旋n位的结果
     * 分三次翻转
     * 例abcdef左旋2位
     * 第一次 将左边两位翻转 bacdef
     * 第二次 将右边所有翻转 bafedc
     * 第三次 全部翻转 cdefab
     * @param string
     * @param n
     */
    public static char[] leftRotate(String string,int n){
        char[] chars = string.toCharArray();
        if(chars.length == 0){
            return null;
        }
        int length = chars.length;
        if(n > 0 && n < length){
            int firstStart = 0;
            int firstEnd = n - 1;
            int secondStart = n;
            int secondEnd = length - 1;
            // 三次翻转
            reverseCore(chars,firstStart,firstEnd);
            reverseCore(chars,secondStart,secondEnd);
            reverseCore(chars,0,length - 1);
        }
        return chars;
    }
    /**
     * 翻转函数
     * @param chars
     * @param start
     * @param end
     */
    public static void reverseCore(char[] chars,int start,int end){
        if(chars == null ||  start > end){
            return;
        }
        while(start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start ++ ;
            end --;
        }
    }
}
