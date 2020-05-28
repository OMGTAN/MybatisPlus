import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;


class Solution {
	
	public int minTimeToVisitAllPoints(int[][] points) {
		int result = 0;
		for (int i = 1; i < points.length; i++) {
			
			result+=Math.max(Math.abs(points[i][0]-points[i-1][0]), Math.abs(points[i][1]-points[i-1][1]));
		}
		
		return result;
    }

	public static void main(String[] args) {
		System.out.println(new Solution().minTimeToVisitAllPoints(new int[][]{{}}));
	}
}
