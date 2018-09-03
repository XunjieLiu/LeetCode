package LeetCode;

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

public class letterCombinations {
	static HashMap<String, String[]> table = init();
	static List<String> Finalresult = new LinkedList<String>();

	public static void main(String[] args) {
		solution("22");
	}
	
	//建议使用回溯法
	//我想试试preOrder遍历树，或者深度优先
	public static List<String> solution(String digits){	
		//特娘的，平台测试代码是反复测试一个方法，导致前一个测试用例的数据还存在全局变量里面
		Finalresult.clear();
		
		if(digits.length() == 0) {
			List<String> temp = new LinkedList<String>();
			return temp;
		}else if(digits.length() == 1) {
			List<String> temp = new LinkedList<String>();
			String thisDigit = ((Character)digits.charAt(0)).toString();
			String[] array = table.get(thisDigit);
			
			for(String i: array) {
				temp.add(i);
			}
			
			return temp;
		}
		
		List<String> temp = Finalresult;
		String result = "";
	    backTrack(0, digits, result);
	    
	    for(String i: temp) {
	    	System.out.println(i);
	    }
	    
	    

		return temp;
	}
	
	public static void backTrack(int depth, String digits, String result) {
		int max = digits.length();
		try {
			String thisDigit = ((Character)digits.charAt(depth)).toString();
			String[] array = table.get(thisDigit);
			int arrayLength = array.length;
			
			for(int i = 0; i < arrayLength; i++) {
				if(depth != max - 1) {
					backTrack(depth + 1, digits, result + array[i]);
				}else {
					Finalresult.add(result + array[i]);
				}
			}
		}catch(Exception e) {
			System.out.println(depth);
		}
	}
	
	public static HashMap<String, String[]> init(){
		HashMap<String, String[]> table = new HashMap<String, String[]>();
		String[] num2 = {"a", "b", "c"};
		table.put("2", num2);
		String[] num3 = {"d", "e", "f"};
		table.put("3", num3);
		String[] num4 = {"g", "h", "i"};
		table.put("4", num4);
		String[] num5 = {"j", "k", "l"};
		table.put("5", num5);
		String[] num6 = {"m", "n", "o"};
		table.put("6", num6);
		String[] num7 = {"p", "q", "r", "s"};
		table.put("7", num7);
		String[] num8 = {"t", "u", "v"};
		table.put("8", num8);
		String[] num9 = {"w", "x", "y", "z"};
		table.put("9", num9);
		
		return table;
	}

}
