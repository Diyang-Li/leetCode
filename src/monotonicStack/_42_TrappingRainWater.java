package monotonicStack;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author Diyang Li
 * @create 2022-08-30 11:12 AM
 */
public class _42_TrappingRainWater {

    public int trap(int[] height) {
        Deque<Integer> q = new ArrayDeque<>();
        int res = 0;

        for(int i = 0; i < height.length; i++){
            while(!q.isEmpty() && height[q.peekLast()] < height[i]){
                // buttom
                int buttom = height[q.pollLast()];
                if(q.isEmpty()) break; // there is no leftwall
                // walls on both sides
                int right = height[i];
                int left = height[q.peekLast()];
                // the height of the pool;
                int h = Math.min(left, right) - buttom;
                int len = i - q.peekLast() - 1;
                res += h * len;
            }
            q.offerLast(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        _42_TrappingRainWater t = new _42_TrappingRainWater();
        System.out.println(t.trap(height));
    }

}
