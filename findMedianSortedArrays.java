package LeetCode;

public class findMedianSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {};
		int[] nums2 = {2, 4};
		
		System.out.println(solution(nums1, nums2));
		

	}
	
	public static double solution(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		
		if(m == 0 || n == 0) {
			int[] temp = (n == 0) ? nums2: nums1;
			if(temp.length % 2 == 0) {
				double a = temp[(int)(temp.length / 2)];
				double b = temp[(int)(temp.length / 2) - 1];
				
				return (a + b) / 2;
			}else {
				return (double)(temp[(int)(temp.length / 2)]);
			}
		}
		
		int i, j, k;
		i = j = k = 0;
		int[] comb = new int[n + m];
		
		while(i < n && j < m) {
			if(nums1[i] < nums2[j]) {
				comb[k++] = nums1[i++];
			}else {
				comb[k++] = nums2[j++];
			}
		}
		
		while(i < n) {
			comb[k++] = nums1[i++];
		}
		
		while(j < m) {
			comb[k++] = nums2[j++];
		}
		
		int median = ((m + n) /2);

		if((m + n) % 2 == 0) {
			double a = comb[median];
			double b = comb[median - 1];
			double result = (a+b) / 2;
			
			return result;
		}else {
			return (double)comb[median];
		}
	}

}
