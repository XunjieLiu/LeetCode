package LeetCode;

public class reverse {
	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
		System.out.println(solution2(-2147483648));
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
	}
	
	public static int solution(int x) {
		long y = (long)x;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		String value = String.valueOf(Math.abs(y));
		int length = value.length();
		//字符串拼接的画 StringBuilder比较快，String本身是不可变对象，反复拼接耗费太大
		StringBuilder reverse = new StringBuilder();
		Character charac;
		
		//反转操作
		//For循环最好不要在循环条件里面有运算操作
		for(int i = length - 1; i >= 0; i--) {
			charac = value.charAt(i);
			reverse = reverse.append(charac);
		}
		
		Long result = Long.valueOf(reverse.toString());
		
		//检查符号
		if(x < 0) {
			result = 0 - result;
			reverse = new StringBuilder(result.toString());
		}
		
		//检查范围
		if(result <= max && result >= min ) {
			return Integer.valueOf(reverse.toString());
		}else {
			return 0;
		}
	}
	
	public static int solution2(int x) {
		int a = Math.abs(x);
        long b = 0;
        
        //使用乘法为下一个数字留出位置，使用除法获取值，填到指定位置
        while(a>0){
           b = b*10+a%10; 
            a = a/10;
        }
        if(x<0){
            b=-b;
        }
        if(b>Integer.MAX_VALUE||b<Integer.MIN_VALUE){
            return 0;
        }
        return (int)b;
	}
}
