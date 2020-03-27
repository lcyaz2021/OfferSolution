/**
 * @Author ChenYang Li
 * @Date 2020/3/7 19:34
 * 顺时针打印数组
 **/
public class Offer29 {
    public static void main(String[] args) {
        int a[][] =  {{1,2,3,4,11,},
                {5,6,7,8,11,},
                {9,10,11,12,11,},
                {13,14,15,16,11,},
                {11,11,11,11,11}};
        printCircle(a,5,5);
        // 第一圈 0 * 4 + 0
//        0 1 2 3 7 11 15
    }
    public static void printCircle(int [][]numbers,int columns,int rows){
        if(numbers == null || columns <= 0 || rows <=0){
            return;
        }
        int start = 0;
        while(columns > 2 * start && rows > 2* start){
            print(numbers,columns,rows,start);
            start++;
        }
    }

    private static void print(int[][] numbers, int columns, int rows, int start) {
        int endX = columns - start - 1;
        int endY = rows - start - 1;
        // 从左到右打印一遍
        for (int i = start; i <= endX ; i++) {
            int x = numbers[start][i];
            System.out.print(x + " ");
        }
        System.out.println();
        // 从上到下打印一遍
        if(start < endY){
            for (int i = start + 1; i <= endY; i++) {
                int y = numbers[i][endX];
                System.out.print(y + " ");
            }
        }
        System.out.println();
        // 从右到左打印一遍
        if(start < endY && start < endX){
            for (int i = endX - 1; i >= start; i--) {
                int x = numbers[endY][i];
                System.out.print(x + " ");
            }
        }
        System.out.println();
        // 从上到下打印一遍
        if(start < endX && start < endY - 1){
            for (int i = endY - 1;i >= start + 1 ; i--){
                int y = numbers[i][start];
                System.out.print(y + " ");
            }
        }
        System.out.println();
    }
}
