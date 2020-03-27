import java.util.Arrays;

/**
 * @Author ChenYang Li
 * @Date 2020/3/27 11:13
 * 从扑克牌中随机抽取五张
 * 判断是否是顺子 11=J,12=Q,13=K,大小王可以充当任意数字
 * 0=大小王
 **/
public class Offer61 {
    public static void main(String[] args) {
        int[] a = {0,0,0,0,0};
        System.out.println(isContinuous(a));
    }
    public static boolean isContinuous(int[] numbers){
        if(numbers.length < 1){
            return false;
        }
        Arrays.sort(numbers);
        // 记录0的个数
        int numberOfZero = 0;
        // 记录缺口的个数
        int numberOfGap = 0;
        // 统计数组中0的个数
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numberOfZero ++;
        }
        // 统计数组中间隔的个数
        int small = numberOfZero;
        int big = small + 1;
        while(big < numbers.length){
            if(numbers[small] == numbers[big]){
                return false;
            }
            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big ++;
        }
        // 缺口大于0的个数 无法连成顺子
        return numberOfGap <= numberOfZero;
    }
}
