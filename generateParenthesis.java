package LeetCode;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Xunjie
 * 基本思路：这个问题类似于数学排列组合里面的座位排列问题，比如求三对括号的组合方式，一共六个字符
 * 第一个字符和最后一个字符可以确定，中间四个位置，插入两个左括号的种数，就是所有有效的括号排列总数
 * 关键就是在这里，里面嵌套的循环次数不确定，for循环就没办法写，3对括号就是2层循环，5对括号就是4层循环
 * 真特么烦躁
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
