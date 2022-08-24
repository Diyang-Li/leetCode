package bfs;

import java.util.*;

/**
 * @author Diyang Li
 * @create 2022-08-23 3:45 PM
 */
public class _207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //  course aftercourses list
        Map<Integer, List<Integer>> map = new HashMap<>();
        // record the number of indegree(number of prerequest courses), verdex is indegree = 0,
        int[] inDegree = new int[numCourses];

        for(int[] courses: prerequisites){
            int start = courses[1];
            int end = courses[0];
            // {1:[0], 0:[1]}
            map.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            //update the indegree of end class
            inDegree[end]++;

        }

        // store the vertex
        Queue<Integer> q = new LinkedList<>();

        //put the vertex into the q, poll out means has already taken this class
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0) q.offer(i);
        }

        // courses has already taken
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            count++;

            for(int course: map.getOrDefault(cur, new ArrayList<>())){
                inDegree[course]--;
                // reduce the out degree of the aftercourses, because the pre courses has already taken,
                // if the inDegree is 0, the after course become vertex, and offer into the queue
                if(inDegree[course] == 0) q.offer(course);
            }
        }
        return count == numCourses;

    }
}
