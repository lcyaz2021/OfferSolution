/**
 * @Author ChenYang Li
 * @Date 2020/3/27 11:59
 * 股票的最大利润
 * 假设某股票按时间顺序存储在数组中
 * 请问买卖一次股票可能的最大利润是多少
 * 例如
 * {9,11,8,5,7,12,16,14} 如果我们能在价格为5时买入 价格为16时卖出 最大利润11
 **/
public class Offer63 {
    public static void main(String[] args) {
        int[] a = {9,11,8,5,7,12,16,14};
        System.out.println(getMaxProfit(a));
    }
    public static int getMaxProfit(int[] numbers){
        if(numbers.length < 2){
            return 0;
        }
        // 初始化两个价格
        // 最小买入价
        int min = numbers[0];
        // 最大卖出价
        int maxDif = numbers[1] - min;
        for (int i = 2; i < numbers.length; i++) {
            if(numbers[i - 1] < min){
                min = numbers[i - 1];
            }
            int curDif = numbers[i] - min;
            if(curDif > maxDif){
                maxDif = curDif;
            }
        }
        return maxDif;
    }
}
