package LeetCode;

import java.util.Stack;
import java.util.HashMap;

public class validBrace {

	public static void main(String[] args) {
		isValid("()");

	}
	
	public static boolean isValid(String s) {
		Stack<String> stack = new Stack<String>();
		HashMap<String, String> map = new HashMap<String, String>();
		String[] array = s.split("");
		
		if(s.equals("")) {
			return true;
		}
		
		if(array.length == 1) {
			return false;
		}
		
		map.put("(", ")");
		map.put("{", "}");
		map.put("[", "]");
		
		for(String ch: array) {
			if(map.containsValue(ch)) {
				if(stack.isEmpty()) {
					return false;
				}else {
					if(!map.get(stack.pop()).equals(ch)) {
						return false;
					}
				}
			}else {
				stack.push(ch);
			}
		}
		
		if(!stack.isEmpty()) {
			return false;
		}
		
		return true;
	}

}
