package LeetCode;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Stack;

/*
 * ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������
 * 
 * ʾ����
 * ���� numbers = [2, 7, 11, 15], target = 9
 * ��Ϊ numbers[0] + numbers[1] = 2 + 7 = 9
 * ���Է��� [0, 1]
 * */

public class two_sum {
	
	public static void main(String[] args) {

	}
	
	public static int[] solution(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // (nums�е����֣� ��Ӧ��λ�ã�
		int[] result = new int[2];// �������
		boolean equals = true; // �����ж���������ǲ����Ѿ��������������ȫ��ֻ��һ����
		int[] copy = new int[nums.length]; //��������
		
		// ��¼����������������ǰ��ԭλ��
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		//��������
		for(int i = 0; i < nums.length; i++) {
			copy[i] = nums[i];
		}
		
		Arrays.sort(copy); // ��������
		print(copy);
		
		// �ж�ԭ�����ǲ�����������
		for(int i = 0; i < nums.length; i++) {
			if(copy[i] != nums[i]) {
				equals = false;
			}
		}
		
		int high = 0;
		int low = 0;
		
		if(copy[0] >= 0) {
			
			// ��������������С��������target��˵���޽�
			if(copy[low] > target) {
				return null;
			}
			
			// �ҵ����������б�targetС�������У���������λ��
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
			low = 0; // lowָ����㣬��ʼ��һ��ѭ��
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
	
	//7ms�Ľⷨ
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
