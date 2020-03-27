import java.util.Scanner;

/**
 * 二维数组：每一行都从左到右递增，每一列都从上到下递增。
 * 输入一个整数，判断数组中是否含有这个数
 */
public class Offer4 {
    public static void main(String[] args) {
        int [][] a = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int i = 0;
        int j = 3;
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        while(i >= 0 && j >= 0){
            if(a[i][j] == x) break;
            if(a[i][j] < x) {
                i++;
            }else{
                j--;
            }
        }
        if(i < 0 || j < 0){
            System.out.println("未找到！");
        }else{
            System.out.println(a[i][j] + " 在 " + "a[" + i + "][" + j + "] 位置！");
        }
    }
}
