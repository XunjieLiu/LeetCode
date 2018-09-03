package LeetCode;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

/*问题描述：
 *给定数组中找到三个数，使之的和等于0，找出所有不重复的组合
 *
 *分析：
 *先对数组进行排序，然后选取一个数a为候选，寻找两个数的组合使之的和为-a, 
 *使用双指针寻找，i指向a下一个数字，j从数组末尾开始
 *if (num(i) + num(j)) < -a ,说明此时需要更大一点的数,则i++；
 *if (num(i) + num(j)) > -a ,说明此时需要更小一点的数,则j++；
 *if ((num(i) + num(j)) == -a,已经找到一个答案，注意当前c循环下可能还会有其它答案，应该继续寻找，而不是break去枚举下一个a
 *
 *这个算法是如何避免重复的：假设a是数组第一个数，从a后面的n个数中找到了所有的合法组合（由于双指针没可能重复指向两个数，所以这里不存在重复）
 *然后下一轮循环从a下一个数开始，这样便可以避免重复，原因是，如果a后面的某个数，在寻找组合的时候，需要a,这说明在指针指向a的时候，那个数就已经被选到了，所以
 *不可能会需要前面的数*/

public class threeSum {

	public static void main(String[] args) {
		int[] nums = {2, 0, -2, -5, -5, -3, 2, -4};//-5, -5, -4, -3, -2, 0, 2, 2
		
		for(List<Integer> i: solution(nums)) {
			System.out.println(i.toString());
		}
	}
	
	public static List<List<Integer>> solution(int[] nums) {	
		Arrays.sort(nums);
		List<List<Integer>> result = new LinkedList<>();
		LinkedList<Integer> combination;
		int left, right, length;
		length = nums.length;
		
		if(nums.length == 3) {
			if(nums[0] + nums[1] + nums[2] == 0) {
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
		
//		for(Integer i: nums) {
//			System.out.print(i + " ");
//		}
//		
//		System.out.println();
//		
		for(int i = 0; i < length - 2; i++) {
			left = i + 1;
			right = length - 1;
			
			w: while(left < right) {
				if(i != 0) {
//					System.out.println(i);
//					System.out.println(nums[i] + " " + nums[i - 1] + (nums[i] == nums[i - 1]));
					
					if(nums[i] == nums[i - 1]) {
						break w;
					}
				}
				
				//点睛之笔
				if(nums[i] >0) {
					break w;
				}
				
//				System.out.println("Left: " + nums[left] + "  Right: " + nums[right] + "  -a: " + -nums[i]);
				if((nums[left] + nums[right]) < (-nums[i])) {			
					left++;
				}else if((nums[left] + nums[right]) > (-nums[i])) {
					right--;
				}else {
					combination = new LinkedList<Integer>();
					combination.add(nums[i]);
					combination.add(nums[left]);
					combination.add(nums[right]);
					result.add(combination);
					
					left++;
					if(nums[left] != nums[left-1]) {
						continue;
					}else {
						while(nums[left] == nums[left-1]) {//-5, -5, -4, -3, -2, 0, 2, 2
							left++;
							
							if(left >= right) {
								break w;
							}
							
						}
					}
				}
			}
		}
		
//		for(List<Integer> i : result) {
//			System.out.println(i.toString());
//		}
		
		return result;
    }

}
