
import java.util.*;
import java.lang.*;
import java.io.*;



public class ReverseKGroup
{
    static ListNode reverseList(ListNode head, ListNode prev)
    {
        ListNode previous = prev;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null)
        {
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        return previous;
    }
    static ListNode reverseKGroup(ListNode head, int k)
    {
        if(k == 1)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode saveHead = null;
        ListNode lastNode = null;
        ListNode prev = null;
        while(fast != null && fast.next != null)
        {
            int i = 0;
            while(fast != null && i != k - 1)
            {
                fast = fast.next;
                i++;
            }
            if(fast == null)
                break;
            prev = fast.next;
            fast.next = null;
            ListNode temp = reverseList(slow, prev);
            if(lastNode != null)
            {
                lastNode.next = temp;
            }
            if(saveHead == null)
            {
                saveHead = fast;
            }
            lastNode = slow;
            slow = prev;
            fast = prev;
        }
        return saveHead;
    }

    public static void main(String[] args)
    {
    	Scanner input= new Scanner(System.in);
    	int n=input.nextInt();
        List list = new List();
        ListNode listNode1 = list.addNodes();
        if(list.listLength(listNode1)<n){
        	System.out.println("Invalid test case");
        }
        else{
        	ListNode temp = reverseKGroup(listNode1,n);
        	list.printNodes(temp);
        }       
    }
}



