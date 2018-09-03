package LeetCode;

import java.util.ArrayList;

public class removeNthFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//进阶挑战：只用一次循环 完成操作
	//可以试试牺牲空间换时间的办法，用数组存储每个节点，寻址删除，再连起来
	public static ListNode solution(ListNode head, int n) {
		ArrayList<ListNode> nodes = new ArrayList<ListNode>();
		ListNode curr = head;
		
		while(curr != null) {
			nodes.add(curr);
			curr = curr.next;
		}
		
		if(nodes.size() == 1 && n == 1) {
			return null;
		}
		
		nodes.remove(nodes.size() - n);
		
		// 如果删除的是最后一个节点，则需要对倒数第二个节点的next修改为null
		if(n == 1) {
			nodes.get(nodes.size() - 1).next = null;
		}
		
		int length = nodes.size();
		
		// 如果只有一个元素 直接返回
		if(length == 1) {
			return nodes.get(0);
		}
		
		for(int i = 0; i < length - 1; i ++) {
			nodes.get(i).next = nodes.get(i + 1);
		}
		
		return nodes.get(0);
	}

}
