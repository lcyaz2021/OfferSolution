/**
 * @Author ChenYang Li
 * @Date 2020/3/23 17:37
 * 数字以012345678910112131415...的格式序列化到一个字符串中。在这个序列中第5位是5，第13位是1，第19位是4
 * 请写一个函数，求任意n位的数字
 **/
public class Offer44 {
    public static void main(String[] args) {
        System.out.println(digitAtIndex(1001));
    }
    public static int digitAtIndex(int index){
        if(index < 0){
            return -1;
        }
        int digits = 1;
        while(true){
            int numbers = countOfInteger(digits);
            if(index < numbers * digits){
                return digitAtIndex(index,digits);
            }
            index -= digits * numbers;
            digits ++;
        }
    }

    private static int digitAtIndex(int index, int digits) {
        int number = beginNumber(digits) + index / digits;
        int indexFromRight = digits - index % digits;
        for (int i = 0; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    private static int beginNumber(int digits) {
        if(digits == 1){
            return 10;
        }
        return (int) Math.pow(10,digits - 1);
    }

    private static int countOfInteger(int digits) {
        if(digits == 1){
            return 10;
        }
        int count = (int) Math.pow(10,digits - 1);
        return 9 * count;
    }
}
