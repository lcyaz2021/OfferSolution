/**
 * @Author ChenYang Li
 * @Date 2020/3/4 10:17
 * 给定一个字符串 判断其是否是整数
 **/
public class Offer20 {
    public static void main(String[] args) {
        System.out.println("isNumeric(\"+100.0\".toCharArray()) = " + isNumeric("+100.0".toCharArray()));
        System.out.println("isNumeric(\"5e2\".toCharArray()) = " + isNumeric("5e2".toCharArray()));
        System.out.println("isNumeric(\"3.1416\".toCharArray()) = " + isNumeric("3.1416".toCharArray()));
        System.out.println("isNumeric(\"-1E-16\".toCharArray()) = " + isNumeric("-1E-16".toCharArray()));
        System.out.println("isNumeric(\"1a3.14\".toCharArray()) = " + isNumeric("1a3.14".toCharArray()));
        System.out.println("isNumeric(\"1.2.3\".toCharArray()) = " + isNumeric("1.2.3".toCharArray()));
        System.out.println("isNumeric(\"12e\".toCharArray()) = " + isNumeric("12e".toCharArray()));
        System.out.println("isNumeric(\".12\".toCharArray()) = " + isNumeric(".12".toCharArray()));
        System.out.println("isNumeric(\"12.\".toCharArray()) = " + isNumeric("12.".toCharArray()));
    }
    public static boolean isNumeric(char[] chars){
        if(chars.length == 0) {

            return false;
        }
        boolean numeric = scanInteger(chars,0);
        int index = scanIntegerGetIndex(chars,0);
        // 形如+100
        if(index == chars.length) return numeric;
        // 获取index移动了多少
        if(chars[index] == '.'){
            index ++;
            // 小数可以没有整数部分 整数可以只有·没有小数部分
            numeric = scanUnsignedInteger(chars,index) || numeric;
            index = scanUnsignedIntegerGetIndex(chars,index);
        }
        if(index == chars.length) return numeric;
        if(chars[index] == 'e' || chars[index] == 'E'){
            index ++;
            numeric = numeric && scanInteger(chars,index);
            index = scanIntegerGetIndex(chars,index);
        }
        return numeric && index == chars.length;
    }

    /**
     * 扫描正负符号
     * @param chars
     * @param index
     * @return
     */
    private static boolean scanInteger(char[] chars,int index) {
        if(chars.length == index) return false;
        if(chars[index] == '+' || chars[index] == '-'){
            index ++;
        }
        return scanUnsignedInteger(chars, index);
    }

    /**
     * 扫描数字部分 不包含符号
     * @param chars
     * @param index
     * @return
     */
    private static boolean scanUnsignedInteger(char[] chars, int index) {
        int oldIndex = index;
        while(index < chars.length && chars[index] >= '0' && chars[index] <= '9'){
            index ++;
        }
        return index > oldIndex;
    }

    /**
     *
     * @param chars
     * @param index
     * @return
     */
    private static int scanIntegerGetIndex(char[] chars,int index) {
        if(chars.length == index) return index;
        if(chars[index] == '+' || chars[index] == '-'){
            index ++;
        }
        return scanUnsignedIntegerGetIndex(chars, index);
    }

    /**
     * 扫描数字部分 不包含符号
     * @param chars
     * @param index
     * @return
     */
    private static int scanUnsignedIntegerGetIndex(char[] chars, int index) {
        while(index < chars.length && chars[index] >= '0' && chars[index] <= '9'){
            index ++;
        }
        return index;
    }
}
