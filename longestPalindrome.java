package LeetCode;

public class longestPalindrome {

	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
        System.out.println(isPalindrome(121));
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

	}
	
	//可应对普通情况，暴力法，但是不是最优解，时间复杂度为三次方
	//尝试采用动态规划
	public static String solution(String s) {
		String max = "";
		
		int low = 0;
		int high = s.length();
		
		while(low < s.length()) {
			while(high > low) {
				String temp = s.substring(low, high);
				if(is_palindrome(temp)) {
					max = (temp.length() > max.length()) ? temp: max;
					if(max.length() == s.length()) {
						return s;
					}
				}
				
				high--;
			}
			
			low++;
			high = s.length();
		}
		return max;
	}
	
	public static boolean is_palindrome(String s) {
		boolean isTrue = true;
		
		int low = 0;
		int high = s.length() - 1;
		
		while((high - low) >= 1) {
			if(s.charAt(low) != s.charAt(high)) {
				isTrue = false;
				break;
			}
			
			low++;
			high--;
		}
		
		return isTrue;
	}
	
	
	public static boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}
		
		int a = x;
		int b = 0;
		
		
		while(x > 0) {
			b = b * 10 + x % 10;
			x = x / 10;
		}
		
		return b == a;
	}
	
	//动态规划做法
	public static String solution2(String s) {
		if(s.length() < 2) {
			return s;
		}else if(s.length() == 2) {
			if(s.charAt(0) == s.charAt(1)) {
				return s;
			}else {
				return s.substring(0, 1);
			}
		}
		
		String max = s.substring(0, 1);
		int index = 1;
		int right = index + 1;
		int left = index - 1;
		
		while(index < s.length() - 1) {
			
			//首先判断相邻字母是否相同
			String indexChar = s.substring(index, index + 1);//单个字母
			String temp = indexChar;//用indexChar连接
			//如果左边相同，就一直向左边比下去
			while(left >= 0 && s.substring(left, index).equals(indexChar)) {
				temp = temp + indexChar;
				max = (temp.length() > max.length()) ? temp: max;
				left--;
			}
			
			//右边同理
			while(right < s.length() && s.substring(right, right+1).equals(indexChar)) {
				temp = temp + indexChar;
				max = (temp.length() > max.length()) ? temp: max;
				right++;
			}
			
			while(left >= 0 && right < s.length()) {
				if(s.charAt(left) == s.charAt(right)) {
					String sub = s.substring(left, right + 1);
					max = (sub.length() > max.length()) ? sub: max;
					left--;
					right++;
				}else {
					break;
				}
			}
			
			index++;
			left = index - 1;
			right = index + 1;
		}
		
		return max;
	}

}
