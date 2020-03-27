/**
 * @Author ChenYang Li
 * @Date 2020/3/25 20:58
 * 丑数:我们把只包含因子2/3/5的数称为丑数。
 * 按从小到大的顺序求出第1500个丑数。
 * 例如：6/8都是丑数,但14不是，因为他只包含因子7。我们把1当做第一个丑数。
 **/

/**
 * 有空在研究，不太理解
 */
public class Offer49 {
    public static void main(String[] args) {
//        System.out.println(findUgly_1());
        System.out.println("findUgly_2() = " + findUgly_2());
    }
    public static int findUgly_1(){
        int count = 0;
        int num =  0;
        while(count != 1500){
            num ++;
//            System.out.println(num);
            if(isUgly(num)){
                count ++;
            }
            System.out.println("count = " + count);
        }
        return num;
    }
    public static boolean isUgly(int num){
        while(num % 2 == 0){
            num /= 2;
        }
        while(num % 3 == 0){
            num /= 2;
        }
        while(num % 5 == 0){
            num /= 2;
        }
        return num == 1;
    }
    // 丑数解法二 不太理解
    public static int findUgly_2(){
        int [] uglyNumber = new int[1500];
        uglyNumber[0] = 1;
        int nextUglyIndex = 1;
        int index2 = 0,index3 = 0,index5 = 0;
        while(nextUglyIndex < 1500){
//            System.out.println("nextUglyIndex = " + nextUglyIndex);
            int m = min(uglyNumber[index2] * 2,uglyNumber[index3] * 3,uglyNumber[index5] * 5);
            uglyNumber[nextUglyIndex] = m;
            while(uglyNumber[index2] * 2<= uglyNumber[nextUglyIndex]){
                index2++;
            }
            while(uglyNumber[index3] * 3<= uglyNumber[nextUglyIndex]){
                index3++;
            }
            while(uglyNumber[index5] * 5<= uglyNumber[nextUglyIndex]){
                index5++;
            }
            nextUglyIndex++;
        }
//        for (int i = 0; i < uglyNumber.length; i++) {
//            System.out.println(uglyNumber[i]);
//        }
        int ugly = uglyNumber[nextUglyIndex - 1];
        return ugly;
    }
    public static int min(int n1,int n2,int n3){
        int m = Math.min(n1, n2);
        m = Math.min(m, n3);
        return m;
    }
}
