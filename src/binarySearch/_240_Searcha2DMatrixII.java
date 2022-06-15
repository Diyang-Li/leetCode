package binarySearch;

/**
 * @author Diyang Li
 * @create 2022-06-14 10:00 PM
 */
public class _240_Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 1. target>=start

        int start = findMatrix(matrix, target);
        for(int i = 0; i<=start; i++){
            boolean find =findArray(matrix[i], target);
            if(find){
                return true;
            }
        }

        return false;
    }

    public int findMatrix(int[][] matrix, int target){
        int left = -1;
        int right = matrix.length;
        while(left+1!=right){
            int mid = (left+right)/2;
            if(matrix[mid][0] > target){
                right = mid;
            }else{
                left = mid;
            }
        }

        return left;
    }

    public boolean findArray(int[] matrix, int target){
        int left = 0;
        int right = matrix.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[mid] > target){
                right = mid-1;
            }else if(matrix[mid] < target){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }

}
