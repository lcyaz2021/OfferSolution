import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author ChenYang Li
 * @Date 2020/3/27 10:41
 * n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的概率点数之和是s
 * 输入n求出s所有可能的概率
 **/
public class Offer60 {
    static final int MAXVALUE = 6;
    public static void main(String[] args) {
        printProbability(6);
    }

    /**
     * 递归 重复计算
     * 循环方法暂时不太理解
     * @param number
     */
    public static void printProbability(int number){
        if(number < 1){
            return;
        }
        int maxSum = number * MAXVALUE;
        int [] probabilities = new int[maxSum - number + 1];// 创建一个数组保存数值
        Arrays.fill(probabilities,0);
        probability(number,probabilities);
        int total = (int)Math.pow(MAXVALUE,number);
        for (int i = number; i <= maxSum ; i++) {
            double ratio = (double)probabilities[i - number]/total;
            System.out.println(i + ":" + ratio + "  " + probabilities[i - number] + "  " + total);
        }
    }

    private static void probability(int number, int[] probabilities) {
        for (int i = 1; i <= MAXVALUE; i++) {
            probability(number,number,i,probabilities);
        }
    }

    private static void probability(int original, int current, int sum, int[] probabilities) {
        if(current == 1){
            probabilities[sum - original]++;
        }else{
            for (int i = 1; i <= MAXVALUE; i++) {
                probability(original,current - 1,i + sum,probabilities);
            }
        }

    }
}
