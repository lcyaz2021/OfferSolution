/**
 * 旋转数组中最小数字
 * 示例输入：{3,4,5,1,2}
 * 输出：{1,2,3,4,5} 找到最小的数字为 1
 */

public class Offer11 {
    public static void main(String[] args) {
        int [] arr = {3,4,5,1,2};
//        int [] arr = {1,0,1,1,1};
        int mid = findMid(arr);
        print(arr,mid);
    }
    public static int findMid(int [] arr){
        int start = 0;
        int end = arr.length - 1;
        int mid = start;
        while(arr[start] >= arr[end]){
            if(end - start == 1) {
                mid = end;
                return mid;
            }
            mid = (end + start) / 2;
            if(arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // 执行遍历查找
                return forFindMid(arr,start,end);
            }
            if(arr[mid] >= arr[start]){
                start = mid;
            }
            else if (arr[mid] <= arr[end]) {
                end = mid;
            }
        }
        return -1;
    }

    private static int forFindMid(int[] arr, int start, int end) {
        int res = arr[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if(res > arr[i]){
                res = arr[i];
                index = i;
            }
        }
        return index;
    }
    public static void print(int [] arr,int index){
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = 0; i < index; i++) {
            if (i == index - 1 ){
                System.out.println(arr[i]);
            }
            else{
                System.out.print(arr[i] + " ");
            }
        }
    }
}
