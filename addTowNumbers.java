package LeetCode;

public class addTowNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(9);
		
		ListNode l2 = new ListNode(0);
		
		ListNode l3 = solution(l1, l2);
		
		while(l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
		
		

	}
	
	public static ListNode solution(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		}else if(l2 == null) {
			return l1;
		}
		
		ListNode dummyHead = new ListNode(0);
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode curr = dummyHead;
		int carry = 0;
		int remainder;
		
		while(p1 != null || p2 != null) {
			int val1 = (p1 == null) ? 0: p1.val;
			int val2 = (p2 == null) ? 0: p2.val;
			
			System.out.println("Val1:  " + val1 + " Val2:  " + val2);
			int sum = val1 + val2 + carry;
			
			carry = sum / 10; // 计算进位
			remainder = sum % 10; // 计算余数，留作Value值 
			curr.next = new ListNode(remainder);
			
			// 转移指针
			if (p1 != null) p1 = p1.next;
	        if (p2 != null) p2 = p2.next;
		    curr = curr.next;
		}
		
		if(carry > 0) {
			curr.next = new ListNode(carry);
		}
		
		return dummyHead.next;
	}
	

}
