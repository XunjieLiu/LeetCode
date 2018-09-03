package LeetCode;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

/*����������
 *�����������ҵ���������ʹ֮�ĺ͵���0���ҳ����в��ظ������
 *
 *������
 *�ȶ������������Ȼ��ѡȡһ����aΪ��ѡ��Ѱ�������������ʹ֮�ĺ�Ϊ-a, 
 *ʹ��˫ָ��Ѱ�ң�iָ��a��һ�����֣�j������ĩβ��ʼ
 *if (num(i) + num(j)) < -a ,˵����ʱ��Ҫ����һ�����,��i++��
 *if (num(i) + num(j)) > -a ,˵����ʱ��Ҫ��Сһ�����,��j++��
 *if ((num(i) + num(j)) == -a,�Ѿ��ҵ�һ���𰸣�ע�⵱ǰcѭ���¿��ܻ����������𰸣�Ӧ�ü���Ѱ�ң�������breakȥö����һ��a
 *
 *����㷨����α����ظ��ģ�����a�������һ��������a�����n�������ҵ������еĺϷ���ϣ�����˫ָ��û�����ظ�ָ�����������������ﲻ�����ظ���
 *Ȼ����һ��ѭ����a��һ������ʼ����������Ա����ظ���ԭ���ǣ����a�����ĳ��������Ѱ����ϵ�ʱ����Ҫa,��˵����ָ��ָ��a��ʱ���Ǹ������Ѿ���ѡ���ˣ�����
 *�����ܻ���Ҫǰ�����*/

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
				
				//�㾦֮��
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
