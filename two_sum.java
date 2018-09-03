package LeetCode;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Stack;

/*
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 
 * 示例：
 * 给定 numbers = [2, 7, 11, 15], target = 9
 * 因为 numbers[0] + numbers[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * */

public class two_sum {
	
	public static void main(String[] args) {

	}
	
	public static int[] solution(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // (nums中的数字， 对应的位置）
		int[] result = new int[2];// 输出数组
		boolean equals = true; // 首先判断这个数组是不是已经是有序数组或者全部只有一种数
		int[] copy = new int[nums.length]; //拷贝数组
		
		// 记录数组中数字在排序前的原位置
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		//拷贝数组
		for(int i = 0; i < nums.length; i++) {
			copy[i] = nums[i];
		}
		
		Arrays.sort(copy); // 排序数组
		print(copy);
		
		// 判断原数组是不是有序数组
		for(int i = 0; i < nums.length; i++) {
			if(copy[i] != nums[i]) {
				equals = false;
			}
		}
		
		int high = 0;
		int low = 0;
		
		if(copy[0] >= 0) {
			
			// 如果这个数组中最小的数都比target大，说明无解
			if(copy[low] > target) {
				return null;
			}
			
			// 找到有序数组中比target小的数字中，最大的数的位置
			for(int i = copy.length - 1; i >= 0; i--) {
				if(copy[i] <= target) {
					high = i;
					break;
				}
			}
		}else {
			high = copy.length - 1;
		}
		
		print(copy);
		System.out.println("High: " + high);
	
		while(high > 0) {
			while(low < high) {
				if(((copy[low] + copy[high]) == target) && (low != high)) {
					int num1 = copy[low];
					int num2 = copy[high];
					
					if(equals) {
						result[0] = low;
						result[1] = high;
					}else {
						
						if(num1 == num2) {
							Stack<Integer> stack = new Stack<>();
							for(int i = 0; i < copy.length; i++) {
								if(nums[i] == num1) {
									stack.push(i);
								}
							}
							
							result[0] = stack.pop();
							result[1] = stack.pop();
						}else {
							result[0] = map.get(num1);
							result[1] = map.get(num2);
						}
						
					}
					
					Arrays.sort(result);
					
					return result;
				}else {
					low++;
				}
			}
			low = 0; // low指针归零，开始新一轮循环
			high--;
		}
		
		return null;
	}
	
	public static void print(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();
	}
	
	//7ms的解法
	public int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        if(numbers==null||numbers.length<2)
            return res;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){
            if(!map.containsKey(target-numbers[i])){
                map.put(numbers[i],i);
            }else{
                res[0]= map.get(target-numbers[i]);
                res[1]= i;
                break;
            }
        }
        return res;
    }

}
