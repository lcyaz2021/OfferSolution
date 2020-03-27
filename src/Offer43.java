/**
 * @Author ChenYang Li
 * @Date 2020/3/22 16:40
 * 给定一个n，求1 - n中1出现的次数
 * 比如 n = 12 ，1,2,3,4,5,6,7,8,9,10,11,12 出现了五次
 **/
public class Offer43 {
    public static void main(String[] args) {
        System.out.println(numberOf1BetweenAndN(13));
    }
    public static int numberOf1BetweenAndN(int n){
        if(n <= 0){
            return 0;
        }
        char[] str = String.valueOf(n).toCharArray();
        return numberOf1(str,0);
    }

    private static int numberOf1(char[] str,int index) {
        if(str.length - index == 0){
            return 0;
        }
        int first = (str[index] - '0');
        if(str.length - index == 1 && first == 0){
            return 0;
        }
        if(str.length - index == 1 && first > 0){
            return 1;
        }
        int numFirstDigit = 0;
        if(first > 1){
            numFirstDigit = powerBase10(str.length - index - 1);
        }else if(first == 1){
            numFirstDigit = Integer.parseInt(String.valueOf(str,index + 1,str.length - index - 1)) + 1;
        }
        int numOtherDigits = first * (str.length - index - 1) * powerBase10(str.length - index - 2);
        int numRecursive = numberOf1(str,index + 1);
        return numFirstDigit + numOtherDigits + numRecursive;
    }

    private static int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }
}
