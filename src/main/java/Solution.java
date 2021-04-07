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
	
	public int[] fairCandySwap(int[] A, int[] B) {
		int totalA = 0, totalB = 0, diff;
		for (int i = 0; i < A.length; i++) {
			totalA += A[i];
		}
		for (int i = 0; i < B.length; i++) {
			totalB += B[i];
		}
		diff =  (totalA - totalB)/2;
		if(diff > 0) {
			for (int i = 0; i < A.length; i++) {
				if(A[i] <= diff)
					continue;
				else {
					int a = A[i];
					for (int j = 0; j < B.length; j++) {
						int b = B[j];
						if (b == a-diff) {
							return new int [] {a,b};
						}
					}
				}
			}
		}else {
			diff = -diff;
			for (int i = 0; i < B.length; i++) {
				if(B[i] <= diff)
					continue;
				else {
					int a = B[i];
					for (int j = 0; j < A.length; j++) {
						int b = A[j];
						if (b == a-diff) {
							return new int [] {b,a};
						}
					}
				}
			}
		}
		
		return null;
    }

	public static void main(String[] args) {
		int[] fairCandySwap = new Solution().fairCandySwap(new int[]{1,1}, new int[]{2,2});
		for (int i = 0; i < fairCandySwap.length; i++) {
			System.out.println(fairCandySwap[i]);
		}
	}
}
