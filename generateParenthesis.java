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
 * 9.8更新： 上述算法有瑕疵，需判定生成结果是否有效
 *
 */

public class generateParenthesis {
	
	private static ArrayList<Integer> tmpArr = new ArrayList<>();

	public static void main(String[] args) {
		String[] test = {"(", ")"};
		
		System.out.println(test.toString());

	}
	
	public static List<String> solution(int n){
		List<String> result = new ArrayList<String>();
		
		
		
		return null;
	}
	
	public static void addResult(List<String> result) {
		
	}

}
