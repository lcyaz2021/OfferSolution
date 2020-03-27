/**
 * @Author ChenYang Li
 * @Date 2020/3/3 15:52
 * 正则匹配  .*
 **/
public class Offer19 {
    public static void main(String[] args) {
        System.out.println("match(\"\") = " + match("aaa".toCharArray(),"a.a".toCharArray()));
        System.out.println("match(\"\") = " + match("aaa".toCharArray(),"ab*ac*a".toCharArray()));
        System.out.println("match(\"\") = " + match("aaa".toCharArray(),"aa.a".toCharArray()));
        System.out.println("match(\"\") = " + match("aaa".toCharArray(),"ab*a".toCharArray()));
        System.out.println("match(\"\") = " + match("abcde".toCharArray(),"a*b*c.*e".toCharArray()));
    }
    public static boolean match(char[] str,char[] pattern){
        if(str.length == 0 || pattern.length == 0){
            return false;
        }
        return matchCore(str,pattern,0,0);
    }
    public static boolean matchCore(char[] str,char[] pattern,int sindex,int pindex){
//        System.out.println("sindex = " + sindex);
//        System.out.println("s = " + str.length);
//        System.out.println("pindex = " + pindex);
//        System.out.println("p = " + pattern.length);
        if(sindex == str.length && pindex == pattern.length){
            return true;
        }
        if(sindex < str.length && pindex == pattern.length){
            return false;
        }
        if(sindex == str.length && pindex < pattern.length){
            return false;
        }
        if(pindex + 1 < pattern.length){
            if(pattern[pindex + 1] == '*'){
                if(pattern[pindex] == str[sindex] || (pattern[pindex] == '.' && str.length != sindex)){
                    return matchCore(str,pattern,sindex +1 ,pindex +2) // 只匹配1个 并后移
                            || matchCore(str,pattern,sindex + 1,pindex) // 匹配到了一次 后移
                            || matchCore(str,pattern,sindex,pindex + 2); // 匹配0个
                }else{
                    return matchCore(str,pattern,sindex,pindex + 2);
                }
            }
        }
//        System.out.println("sindex = " + sindex);
//        System.out.println(pindex);
        if (str[sindex] == pattern[pindex] || (pattern[pindex] == '.' && sindex != str.length)){
            return matchCore(str,pattern,sindex + 1,pindex + 1);
        }
        return false;
    }
}
