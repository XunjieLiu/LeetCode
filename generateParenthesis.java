package LeetCode;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Xunjie
 * ����˼·�����������������ѧ��������������λ�������⣬�������������ŵ���Ϸ�ʽ��һ�������ַ�
 * ��һ���ַ������һ���ַ�����ȷ�����м��ĸ�λ�ã��������������ŵ�����������������Ч��������������
 * �ؼ��������������Ƕ�׵�ѭ��������ȷ����forѭ����û�취д��3�����ž���2��ѭ����5�����ž���4��ѭ��
 * ����ô����
 *
 */

public class generateParenthesis {

	public static void main(String[] args) {
		

	}
	
	public static List<String> solution(int n){
		List<String> result = new ArrayList<String>();
		int num = 2 * n;
		
		if(n < 1) {
			return null;
		}else if(n == 1) {
			String re = "()";
			result.add(re);
			
			return result;
		}
		
		String[] combo = new String[num];
		combo[0] = "(";
		combo[num - 1] = ")";
		
		
		
		
		
		
		return null;
	}

}
