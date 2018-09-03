package LeetCode;

public class reverse {
	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
		System.out.println(solution2(-2147483648));
		long endTime=System.currentTimeMillis(); //��ȡ����ʱ��
		System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms");
	}
	
	public static int solution(int x) {
		long y = (long)x;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		String value = String.valueOf(Math.abs(y));
		int length = value.length();
		//�ַ���ƴ�ӵĻ� StringBuilder�ȽϿ죬String�����ǲ��ɱ���󣬷���ƴ�Ӻķ�̫��
		StringBuilder reverse = new StringBuilder();
		Character charac;
		
		//��ת����
		//Forѭ����ò�Ҫ��ѭ�������������������
		for(int i = length - 1; i >= 0; i--) {
			charac = value.charAt(i);
			reverse = reverse.append(charac);
		}
		
		Long result = Long.valueOf(reverse.toString());
		
		//������
		if(x < 0) {
			result = 0 - result;
			reverse = new StringBuilder(result.toString());
		}
		
		//��鷶Χ
		if(result <= max && result >= min ) {
			return Integer.valueOf(reverse.toString());
		}else {
			return 0;
		}
	}
	
	public static int solution2(int x) {
		int a = Math.abs(x);
        long b = 0;
        
        //ʹ�ó˷�Ϊ��һ����������λ�ã�ʹ�ó�����ȡֵ���ָ��λ��
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
