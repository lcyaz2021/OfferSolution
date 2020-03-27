/**
 * 长度为n的数组所有数字都在0~n-1范围内。数组中某些数字是重复的，但不知道有几个重复，也不知道重复几次
 * 请找出任意重复数字
 */
public class Offer3 {
    public static void main(String[] args) {
        int a[] = {3,1,2,0,2,5,3};
        for (int i = 0; i < a.length; i++) {
            while(a[i] != i){
                if(a[i] == a[a[i]]) {
                    System.out.println(a[i]);
                    break;
                }
                int tmp = a[a[i]];
                a[a[i]] = a[i];
                a[i] = tmp;
            }
        }
    }
}
