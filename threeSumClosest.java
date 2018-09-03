package LeetCode;

import java.util.Arrays;

public class threeSumClosest {

	public static void main(String[] args) {
		int[] nums = {4, 0, -5, 5, 3, 3, 0, -4, -5};//
		
		System.out.println(solution(nums, -2));

	}
	
	//尝试使用双指针法
	public static int solution(int[] nums, int target) {
		int left, right, result, diff, newDiff, sum, length;
		Arrays.sort(nums);
		diff = Integer.MAX_VALUE;
		length = nums.length;
		result = 0;
		
		for(int i = 0; i < length; i++) {
			left = i + 1;
			right = length - 1;
			
			while(left < right) {
				sum = nums[i] + nums[left] + nums[right];
				newDiff = Math.abs(target - sum);
				
				if(newDiff < diff) {
					diff = newDiff;
					result = sum;
				}
				
				if(sum > target) {
					right--;
				}else if(sum < target){
					left++;
				}else {
					return target;
				}
			}
		}
		
		return result;
	}

}
