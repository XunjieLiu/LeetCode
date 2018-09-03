package LeetCode;

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Comparator;
/*
 * Given a string, find the length of the longest substring without repeating characters.
 * */

public class lengthOfLongestSubstring {

	public static void main(String[] args) {
		System.out.print(solution("abcabcabc"));

	}
	
	//优化：可以不使用优先队列，每次调用Math.Max(int i, int j)即可
	public static int solution(String s) {
		if(s.length() < 1) {
			return 0;
		}else if(s.length() == 1) {
			return 1;
		}
		
		Comparator<Integer> cmp;
	    cmp = new Comparator<Integer>() {
	      public int compare(Integer e1, Integer e2) {
	        return e2 - e1;
	      }
	    };
		
		HashSet<Byte> set = new HashSet<Byte>();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(cmp);
			
		byte[] bs = s.getBytes();
		
		for(int i = 0; i < bs.length; i++) {
			for(int j = i; j < bs.length; j++) {
				if(!set.contains(bs[j])) {
					set.add(bs[j]);
				}else {
					break;
				}
			}
			
			queue.add(set.size());
			set.clear();
		}
		
		return queue.peek();
	}

}
