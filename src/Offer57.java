import java.util.ArrayList;
import java.util.List;

/**
 * @Author ChenYang Li
 * @Date 2020/3/26 20:16
 * 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得他们的和正好是s
 * 如果有多对，输出任意一对即可
 **/
public class Offer57 {
    public static void main(String[] args) {
        int [] a = {1,2,4,7,11,15};
        System.out.println(findTwoNumber(a,15));
    }
    public static List<Integer> findTwoNumber(int[] numbers,int key){
        if(numbers.length < 1 ){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int ahead = numbers.length - 1;
        int behind = 0;
        while(ahead > behind){
            int curSum = numbers[ahead] + numbers[behind];
            if(curSum == key){
                list.add(numbers[ahead]);
                list.add(numbers[behind]);
                break;
            }
            else if(curSum > key){
                ahead --;
            }else{
                behind ++;
            }
        }
        return list;
    }
}
