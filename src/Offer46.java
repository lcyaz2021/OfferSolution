/**
 * @Author ChenYang Li
 * @Date 2020/3/23 18:16
 * 给定一个数字按照如下规则：
 * 0-a,1-b,2-c...,11-l,...,25-z
 * 给定一个数字求有多少种不同的翻译方式
 **/
public class Offer46 {
    public static void main(String[] args) {
        getTranslationCount(12258);
    }
    public static int getTranslationCount(int number){
        if(number < 0){
            return 0;
        }
        String str = String.valueOf(number);
        return getTranslationCount(str);
    }

    public static int getTranslationCount(String str) {
        int length = str.length();
        char[] numbers = str.toCharArray();
        int [] counts = new int[length];
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            count = 0;
            if(i < length - 1){
                count = counts[i + 1];
            }else{
                count = 1;
            }
            if(i < length - 1){
                int digit1 = numbers[i] - '0';
                int digit2 = numbers[i + 1] - '0';
                int converted = digit1 * 10 + digit2;
                if(converted >=10 && converted <= 25){
                    if (i < length - 2){
                        count += counts[i+2];
                    }else{
                        count += 1;
                    }
                }
            }
            counts[i] = count;
        }
        count = counts[0];
        for (int i : counts) {
            System.out.println(i);
        }
        return count;
    }
}
