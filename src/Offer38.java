/**
 * @Author ChenYang Li
 * @Date 2020/3/13 16:33
 * 字符串排列
 * 例如输入字符串abc
 * 打印由字符abc所能排列出来的所有字符串如abc,acb,bac……
 **/
public class Offer38 {
    public static void main(String[] args) {
        StringArrange("abc");
    }
    public static void StringArrange(String string){
        char[] chars = string.toCharArray();
        if(chars.length == 0){
            return;
        }
        Arrange(chars,0);
    }

    private static void Arrange(char[] chars, int index) {
        if(index == chars.length){
           print(chars);
        }
        else{
            for(int i = index;i<chars.length ; i++){
                char temp = chars[i];
                chars[i] = chars[index];
                chars[index] = temp;
                Arrange(chars,index + 1);
                temp = chars[i];
                chars[i] = chars[index];
                chars[index] = temp;
            }
        }
    }

    private static void print(char[] chars) {
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
