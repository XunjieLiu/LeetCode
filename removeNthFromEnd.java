package LeetCode;

import java.util.ArrayList;

public class removeNthFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//������ս��ֻ��һ��ѭ�� ��ɲ���
	//�������������ռ任ʱ��İ취��������洢ÿ���ڵ㣬Ѱַɾ������������
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
		
		// ���ɾ���������һ���ڵ㣬����Ҫ�Ե����ڶ����ڵ��next�޸�Ϊnull
		if(n == 1) {
			nodes.get(nodes.size() - 1).next = null;
		}
		
		int length = nodes.size();
		
		// ���ֻ��һ��Ԫ�� ֱ�ӷ���
		if(length == 1) {
			return nodes.get(0);
		}
		
		for(int i = 0; i < length - 1; i ++) {
			nodes.get(i).next = nodes.get(i + 1);
		}
		
		return nodes.get(0);
	}

}
