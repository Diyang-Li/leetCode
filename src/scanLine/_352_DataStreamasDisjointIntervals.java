package scanLine;

import java.util.*;

/**
 * @author Diyang Li
 * @create 2022-08-15 10:07 AM
 */
public class _352_DataStreamasDisjointIntervals {
    TreeSet<int[]> set = new TreeSet<>((a, b)->{
        if(a[0] == b[0]) return a[1] - b[1];
        return a[0] - b[0];
    });
    public _352_DataStreamasDisjointIntervals() {

    }

    public void addNum(int val) {
        int[] intervals = {val, val};
        if(set.contains(intervals)) return;

        // find the left array
        int[] low = set.lower(intervals);
        // find the right array
        int[] high = set.higher(intervals);

        if(high != null && high[0] == val) return;
        if(low != null && low[1] + 1 == val && high != null && high[0] - 1 == val){
            low[1] = high[1];
            set.remove(high);
        }else if(low != null && low[1] + 1>= val) low[1] = Math.max(low[1], val);
        else if(high != null && val + 1 == high[0]){
            high[0] = val;
        }else{
            set.add(intervals);
        }

    }

    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>();
        for(int[] intervals: set) res.add(intervals);
        return res.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        TreeSet<int[]> set = new TreeSet<>((a, b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        set.add(new int[]{1,4});
        set.add(new int[]{5,7});
        set.add(new int[]{14,15});
        set.add(new int[]{24,25});
        int[] a = new int[]{7,7};

        System.out.println(Arrays.toString(set.lower(a)));
        System.out.println(Arrays.toString(set.higher(a)));
    }
}
