import java.util.*;
import java.lang.*;
import java.io.*;




public class DetectLoop{
	static boolean hasCycleUsingHashMap(ListNode head){
		Map<ListNode,Integer>map=new HashMap<>();
        while(head!=null){
        if(map.get(head)!=null)
            return true;
        map.put(head,1);
        head=head.next;            
        }
        return false;
	}
	static boolean hasCycle(ListNode head){
		ListNode slow=head;
		ListNode fast=head;
		while(slow!=null&&fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
            if(slow==fast)
				return true;
		}
		return false;   
	}
	public static void main(String[] args) {
		
	}
}