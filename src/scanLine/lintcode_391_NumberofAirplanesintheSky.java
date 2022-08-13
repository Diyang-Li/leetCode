package scanLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-12 3:10 PM
 */
public class lintcode_391_NumberofAirplanesintheSky {
    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        List<Point> list = new ArrayList<>(airplanes.size()*2);

        for(Interval i: airplanes){
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, -1));
        }

        Collections.sort(list, (Point p1, Point p2) ->{
            if(p1.S == p2.S) return p1.T - p2.T;
            return p1.S - p2.S;
        });

        int max = 0;
        int cur = 0;
        for(Point p: list){
            if(p.T == 1) cur ++;
            else cur--;

            max = Math.max(cur, max);
        }

        return max;

    }

    class Point{
        int S;
        int T;

        public Point(int S, int T){
            this.S = S;
            this.T = T;
        }


    }
}
