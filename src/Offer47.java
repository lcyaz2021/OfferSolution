/**
 * @Author ChenYang Li
 * @Date 2020/3/23 18:36
 * 礼物的最大值，在一个m*n的棋盘的每一格都放有礼物，每个礼物都有一个大于0的价值
 * 从左上角出发，到右下角结束，求最多能拿多少价值的礼物。
 **/
public class Offer47 {
    public static void main(String[] args) {
        int[][] val = {{1,10,3,8},
                       {12,2,9,6},
                       {5,7,4,11},
                       {3,7,16,5}};
        System.out.println(getMaxValue_1(val,4,4));
        System.out.println(getMaxValue_2(val,4,4));
    }

    /**
     * 动态规划未优化解法
     * @param value
     * @param rows
     * @param cols
     * @return
     */
    public static int getMaxValue_1(int [][] value,int rows,int cols){
        if(value.length == 0 || rows <= 0 || cols <= 0){
            return 0;
        }
        int [][] maxValues = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if(i > 0){
                    up = maxValues[i - 1][j];
                }
                if(j > 0){
                    left = maxValues[i][j - 1];
                }
                maxValues[i][j] = Math.max(left,up) + value[i][j];
            }
        }
        int maxValue = maxValues[rows -1][cols -1];
        return maxValue;
    }

    /**
     * 动态规划优化后解法,二维数组变一维
     * @param value
     * @param rows
     * @param cols
     * @return
     */
    public static int getMaxValue_2(int [][] value,int rows,int cols){
        if(value.length == 0 || rows <= 0 || cols <= 0){
            return 0;
        }
        int [] maxValues = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if(i > 0){
                    up = maxValues[j];
                }
                if(j > 0){
                    left = maxValues[j - 1];
                }
                maxValues[j] = Math.max(left,up) + value[i][j];
            }
        }
        int maxValue = maxValues[cols -1];
        return maxValue;
    }
}
