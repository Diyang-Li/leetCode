package binarySearch;

/**
 * @author Diyang Li
 * @create 2022-06-14 9:29 AM
 */
public class _275_H_IndexII {
    public static int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length-1;

        while(left < right){
            int mid =left + (right -left)/2;
            if(citations[mid] >= citations.length -mid){
                right = mid;
            }else{
                left = mid +1;
            }
        }
        //citations.left - left >= 1
        // Because the citations is ascending list, so the citations after ith is >= ith's citation,
        // so count from right to left. length - index is last nth paper
        // However, length - index >= 1, so we need to figure out if the current citation is 0;
        return citations[left] == 0?0: citations.length-left;
    }

    /**
     * official solution
     * @param citations
     * @return
     */
    public static int hIndex1(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }


    public static void main(String[] args) {
        int[] citations1 = {0,1,3,5,6};
        int[] citations2 = {1,2,100};
        int[] citations3 = {0};
        int[] citations4 = {100};
        int[] citations5 = {0,0,0};
        int[] citations6 ={0,1};
        System.out.println(hIndex1(citations5));
    }
}
