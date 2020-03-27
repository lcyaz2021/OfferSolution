/**
 * 替换char数组中的空格为%20 要求时间复杂度为O(n)
 */
public class Offer5 {
    public static void main(String[] args) {
        char [] s1 = "we are happy".toCharArray();
        // 实现 从后往前替换
        int len = s1.length;
        for (int i = 0; i < s1.length; i++) {
            if(s1[i] == ' ')  len += 2;
        }
        char [] s2 = new char[len];
        len --;
        for (int i = s1.length - 1; i >= 0; i--) {
            if(s1[i] == ' '){
                s2[len--] = '0';
                s2[len--] = '2';
                s2[len--] = '%';
            }else{
                s2[len--] = s1[i];
            }
        }
        for (int i = 0; i < s2.length; i++) {
            System.out.print(s2[i]);
        }
        // 从后向前考虑问题

    }
}
