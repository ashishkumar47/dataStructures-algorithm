import java.util.*;
import java.lang.*;
import java.io.*;




public class MiddleNode
{
    static ListNode middleNodeOptimise(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static ListNode middleNode(ListNode head)
    {
        ListNode temp = head;
        int count = 0;
        while(temp != null)
        {
            count++;
            temp = temp.next;
        }
        int i = 0;
        while(i != (count / 2))
        {
            head = head.next;
            i++;
        }
        return head;
    }
    public static void main(String[] args)
    {
        List list = new List();
        ListNode listNode = list.addNodes();
        ListNode head = middleNodeOptimise(listNode);
        System.out.println(head.val);
    }
}