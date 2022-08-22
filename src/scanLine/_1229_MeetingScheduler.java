package scanLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-15 11:57 AM
 */
public class _1229_MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b)->{
            return a[0] - b[0];
        });

        Arrays.sort(slots2, (a, b)->{
            return a[0] - b[0];
        });

        List<Integer> res = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while(p1 < slots1.length && p2 < slots2.length){
            int[] a = slots1[p1];
            int[] b = slots2[p2];

            int start = Math.max(a[0], b[0]);
            int end = Math.min(a[1], b[1]);

            if(end - start >= duration){
                res.add(start);
                res.add(start+duration);
                return res;
            }else if(a[1] > b[1]) p2++;
            else p1++;
        }

        return res;
    }
}
