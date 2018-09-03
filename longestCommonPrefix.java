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
		
		//�ӵڶ����ַ�����ʼ ��ͷ��ʼƥ��
		//�����j���ַ���ƥ�䣬���ȡsample�ַ�����jλ�ã���Ϊ��һ�ֵ�sample�����Ż�����
		for(int i = 1; i < length; i++) {
			for(int j = 0; j < sampleLen; j++) {
				if(strs[i].charAt(j) != sample.charAt(j)) {
					sample = sample.substring(0, j);
					break;
				}
				
				//���sampleֻ��0λ ֱ�ӷ���
				if(sample.length() < 1) {
					return sample;
				}
			}
			
			//����sample length, �Ը�����һ��ѭ��������������ѭ��������Խ��Խ��
			sampleLen = sample.length();
		}
		
		return sample;
	}

}
