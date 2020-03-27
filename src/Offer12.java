/**
 * 回溯算法实现矩阵路径
 * 矩阵如下：
 * a b t g
 * c f c s
 * j d e h
 * 判断路径是否存在
 * 回溯经典问题
 */
public class Offer12 {
    public static void main(String[] args) {
        char [] chars = {'a','b','t','g',
                         'c','f','c','s',
                         'j','d','e','h'};
        char [] str = "bfce ".toCharArray();
        boolean b = hasPath(chars, 3, 4, str);
        System.out.println(b);
    }
    public static boolean hasPath(char [] matrix,int rows,int cols, char[] str){
        boolean[] visited = new boolean[rows * cols]; //新建一个大小一样的boolean数组用来存放访点是否被访问过
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++){
                if (hasPathCore(matrix,rows,cols,row,col,str,pathLength,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
        if (str[pathLength] == ' '){
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows &&col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength]
        && !visited[row * cols + col]){
            ++pathLength;
            visited[row * cols + col] = true;
            hasPath = hasPathCore(matrix,rows,cols,row,col - 1,str,pathLength,visited)
                      || hasPathCore(matrix,rows,cols,row,col + 1,str,pathLength,visited)
                      || hasPathCore(matrix,rows,cols,row - 1,col,str,pathLength,visited)
                      || hasPathCore(matrix,rows,cols,row + 1,col,str,pathLength,visited);
            if (!hasPath){
                --pathLength;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }
}
