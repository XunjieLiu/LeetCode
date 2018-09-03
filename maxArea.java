package LeetCode;

public class maxArea {

	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
		int[] height = {1, 8};
		System.out.println(solution(height));
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

	}
	
	public static int solution(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		
		while(right > left) {
			maxArea = Math.max(maxArea,(Math.min(height[right],height[left])*(right-left)));
			
			if(height[left] < height[right]) {
				left++;
			}else {
				right--;
			}
		}
		
		return maxArea;
	}

}
