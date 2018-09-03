package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class longestCommonPrefix {

	public static void main(String[] args) {
		String[] str = {"flower","flow","flight"};
		System.out.println(solution(str) + "\n");
		System.out.println("Done");
	}
	
	public static String solution(String[] strs) {
		String result = "";
		int length = strs.length;
		
		if(Arrays.asList(strs).contains(result) || strs.length < 1) {
			return result;
		}else if(strs.length == 1){
			return strs[0];
		}
		
		Comparator<String> myComparator = new Comparator<String>() {
			public int compare(String str1, String str2) {
				if(str1.length() > str2.length()) {
					return 1;
				}else {
					return -1;
				}
			}
		};
		
		Arrays.sort(strs, myComparator);
		
		String sample = strs[0];
		int sampleLen = sample.length();
		
		//从第二个字符串开始 从头开始匹配
		//如果第j个字符不匹配，则截取sample字符串到j位置，作为下一轮的sample，以优化过程
		for(int i = 1; i < length; i++) {
			for(int j = 0; j < sampleLen; j++) {
				if(strs[i].charAt(j) != sample.charAt(j)) {
					sample = sample.substring(0, j);
					break;
				}
				
				//如果sample只有0位 直接返回
				if(sample.length() < 1) {
					return sample;
				}
			}
			
			//更新sample length, 以更新下一次循环次数，理论上循环次数会越来越少
			sampleLen = sample.length();
		}
		
		return sample;
	}

}
