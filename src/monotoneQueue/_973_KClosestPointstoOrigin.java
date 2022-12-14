package monotoneQueue;

import org.testng.internal.collections.Pair;

import java.util.PriorityQueue;

/**
@author Diyang Li
@create 2022-12-13 4:52 PM
*/public class _973_KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(int)((b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])));
        for(int[] arr: points){
            q.offer(arr);
            if(q.size() > k){
                q.poll();
            }
        }

        int[][] res = new int[k][2];
        while(k > 0){
            res[k-1] = q.poll();
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][2];
        arr[0] = new int[]{3,3};
        arr[1] = new int[]{5,-1};
        arr[2] = new int[]{-2,4};
        _973_KClosestPointstoOrigin t = new _973_KClosestPointstoOrigin();
        t.kClosest(arr, 2);
    }
}
