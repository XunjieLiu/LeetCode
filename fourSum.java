package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class fourSum {

	public static void main(String[] args) {
		int[] nums = {-1,-5,-5,-3,2,5,0,4};
		Arrays.sort(nums);
		for(Integer i: nums) {
			System.out.print(i + " ");
		}
		System.out.println();
		solution(nums, 4);
//		System.out.println(threeSum(nums, 9).toString());;
		
	}
	
	public static List<List<Integer>> solution(int[] nums, int target){
		Arrays.sort(nums);
		List<List<Integer>> result = new LinkedList<>();
		//arraycopy(Object src,int srcPos,Object dest, int destPos,int length);
		int length = nums.length;
		
		for(int i = 0; i < length - 3; i++) {
			if(i != 0) {
				if(nums[i] == nums[i - 1]) {
					continue;
				}
			}
			int[] temp = new int[length - i - 1];
			System.arraycopy(nums, i + 1, temp, 0, length - i - 1);
			
			
//			System.out.println(target - nums[i]);
//			System.out.println(threeSum(temp, target - nums[i]).toString());
			
			for(List<Integer> m: threeSum(temp, target - nums[i])) {
				if(!m.isEmpty()) {
//					System.out.println(target - nums[i]);
//					System.out.println(m.toString());
					m.add(nums[i]);
					result.add(m);
				}
//				System.out.println(m.toString());
			}
		}
		
		for(List<Integer> n: result) {
			System.out.println(n.toString());
		}
		
		return result;
	}
	
	public static List<List<Integer>> threeSum(int[] nums, int target) {
//		Arrays.sort(nums);
		List<List<Integer>> result = new LinkedList<>();
		LinkedList<Integer> combination;
		int left, right, length;
		length = nums.length;
		
		if(nums.length == 3) {
			if(nums[0] + nums[1] + nums[2] == target) {
				combination = new LinkedList<Integer>();
				combination.add(nums[0]);
				combination.add(nums[1]);
				combination.add(nums[2]);
				result.add(combination);
				
				return result;
			}else {
				return result;
			}
		}else if(length < 3) {
			return result;
		}
		
		for(int i = 0; i < length - 2; i++) {
			left = i + 1;
			right = length - 1;
            
			w: while(left < right) {
				if(i != 0) {
					if(nums[i] == nums[i - 1]) {
						break w;
					}
				}
//				System.out.println(nums[i]);
//                System.out.println(nums[left] + " " + nums[right] + " " + (target-nums[i]));
				if((nums[left] + nums[right]) < (target-nums[i])) {
					left++;
				}else if((nums[left] + nums[right]) > (target-nums[i])) {
					right--;
				}else {
					combination = new LinkedList<Integer>();
					combination.add(nums[i]);
					combination.add(nums[left]);
					combination.add(nums[right]);
//					System.out.println(combination.toString());
					result.add(combination);
					
					left++;
					if(nums[left] != nums[left-1]) {
						continue;
					}else {
						while(nums[left] == nums[left-1]) {
							left++;
							
							if(left >= right) {
								break w;
							}
							
						}
					}
				}
			}
		}
		
		return result;
    }

}
