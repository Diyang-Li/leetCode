package binarySearch;

import java.awt.print.Book;
import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-06-14 11:30 AM
 */
public class _74_Searcha2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        //find the arrays start >= target;
        int start = findMatrix(matrix, target);

        return findArray(matrix[start], target);
    }

    // find the last small or equals to the target, use the right binary search
    public static int findMatrix(int[][] matrix, int target ){

        int left = 0;
        int right = matrix.length-1;

        while (left < right){
            int mid = left + (right - left)/2 + 1;
            if(matrix[mid][0] > target){
                right = mid-1;
            }else{
                left = mid;
            }
        }
        System.out.println(right);
        return right;
    }

    public static boolean findArray(int[] array, int target){
        int left = 0;
        int right = array.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if(array[mid] > target){
                right = mid-1;
            }else if(array[mid] < target){
                left = mid+1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target1 = 3;
        int[][] matrix2 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target2 = 13;
        int[][] matrix3 = {{1,3}};
        int target3 = 2;
        int[][] matrix4 = {{1}};
        int target4 = 1;
        int[][] matrix5 = {{1},{3}};
        int target5 = 3;

        System.out.println(searchMatrix(matrix4,target4));
    }
}
