import java.util.Arrays;

/**
 * @Author ChenYang Li
 * @Date 2020/3/25 21:30
 * 寻找第一个只出现一次的字符
 * abaccdeff 输出 b
 **/
public class Offer50 {
    public static void main(String[] args) {
        System.out.println(findOnlyOne("abaccdeff"));
    }

    /**
     * 简单哈希表实现
     * @param string
     * @return
     */
    public static char findOnlyOne(String string){
        char[] chars = string.toCharArray(); // 转为char数组
        int[] hash = new int[256]; // 构建简单哈希表
        Arrays.fill(hash, 0);
        for (char c : chars) {
            hash[c] += 1;
        }
        for (char c : chars) {
            if (hash[c] == 1){
                return c;
            }
        }
        return ' ';
    }
}
