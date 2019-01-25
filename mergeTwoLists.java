package LeetCode;

public class mergeTwoLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		
		l1.next = new ListNode(2);
		l2.next = new ListNode(3);
		l1.next.next = new ListNode(4);
		l2.next.next = new ListNode(4);
		
		print(betterSolution(l1, l2));

	}
	
	public static ListNode solution(ListNode l1, ListNode l2) {
		ListNode node1, node2, curr, dummyHead;
		dummyHead = new ListNode(0);
		curr = dummyHead;
		node1 = l1;
		node2 = l2;
		
		while(node1 != null || node2 != null) {
			if(node1 == null) {
				curr.next = node2;
				break;
			}
			
			if(node2 == null) {
				curr.next = node1;
				break;
			}
			
			if(node1.val < node2.val) {
				curr.next = new ListNode(node1.val);
				node1 = node1.next;
			}else {
				curr.next = new ListNode(node2.val);
				node2 = node2.next;
			}
			
			curr = curr.next;
		}
		
		return dummyHead.next;
	}
	
	public static ListNode betterSolution(ListNode l1, ListNode l2) {
		ListNode newLd =  new ListNode(0);
        ListNode n = newLd;
        
        while(l1!=null || l2!=null){
            if(l1==null){
                newLd.next = l2;
                newLd = newLd.next;
                l2 = l2.next;
                continue;
                }
            if(l2==null){
                newLd.next = l1;
                newLd = newLd.next;
                l1 = l1.next;
                continue;
            }
            
            if(l1.val>=l2.val){
                newLd.next = l2;
                newLd = newLd.next;
                l2 = l2.next;
            }else{
                newLd.next = l1;
                newLd = newLd.next;
                l1 = l1.next;
            }
        }
        
        return n.next;
	}
	
	public static void print(ListNode node) {
		while(node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
	}

}
