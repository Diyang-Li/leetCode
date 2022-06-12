package binarySearch;

/**
 * @author Diyang Li
 * @create 2022-06-11 11:10 AM
 */
public class _278_FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid = 0;
        int bad = 0;

        while(start <= end){
            mid = start + (end - start)/2;
            if(isBadVersion(mid)){
                bad = mid;
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return bad;
    }

    //This is given API of leetcode
    public boolean isBadVersion(int n){
        return false;
    }
}
