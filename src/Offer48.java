import java.util.Arrays;

/**
 * @Author ChenYang Li
 * @Date 2020/3/25 19:16
 * 最长不含重复字符的子字符串
 * 请从字符串中找出，计算最长子字符串的长度。
 * 假设字符串只包含a-z的字符。
 * 例如：arabcacfr 中 最长的不含重复字符的子字符串是 acfr 长度为4
 **/
public class Offer48 {
    public static void main(String[] args) {
        String s = "arabcacfr";
        System.out.println(getLongestSubstring(s));
    }

    /**
     * 动态规划
     * @param str
     * @return
     */
    public static int getLongestSubstring(String str){
        int curLength = 0; // 当前的长度
        int maxLength = 0; // 最大长度
        int [] position = new int[26];
        // 初始化为-1
        Arrays.fill(position, -1);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int preIndex = position[chars[i] - 'a']; // 读取上一次出现的位置
            if(preIndex < 0 || i - preIndex > curLength){ // 如果从未出现过或上次出现的位置与当前位置相距较远
                curLength ++;
            }else{
                if (curLength > maxLength){
                    maxLength = curLength;
                }
                curLength = i - preIndex;
            }
            position[chars[i] - 'a'] = i; // 记录上一次出现的位置
        }
        if (curLength >maxLength){
            maxLength = curLength;
        }
        return maxLength;
    }
}
