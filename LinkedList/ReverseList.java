import java.util.*;
import java.lang.*;
import java.io.*;




public class ReverseList
{
    static ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static ListNode reverseListRecursion(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode temp = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void main(String[] args)
    {
        List list = new List();
        ListNode listNode = list.addNodes();
        ListNode head = reverseListRecursion(listNode);
        list.printNodes(head);
    }
}