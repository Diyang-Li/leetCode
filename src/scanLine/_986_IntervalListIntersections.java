package scanLine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-15 12:30 PM
 */
public class _986_IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int f = 0;
        int s = 0;

        List<int[]> list = new ArrayList<>();

        while(f < firstList.length && s < secondList.length){
            int[] fa = firstList[f];
            int[] sa = secondList[s];

            int start = Math.max(fa[0], sa[0]);
            int end = Math.min(fa[1], sa[1]);

            if(start <= end)  list.add(new int[]{start, end});

            if(fa[1] <sa[1]) f++;
            else s++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
