import java.util.*;
import java.lang.*;
import java.io.*;



public class PalindromeList
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
    static boolean isPalindrome(ListNode head)
    {
        if(head == null)
            return true;
        ListNode slow = head;
        ListNode prev = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode savePrev = prev.next;
        prev.next = null;
        ListNode newHead1 = reverseList(savePrev);
        while(newHead1 != null && head != null)
        {
            if(newHead1.val != head.val)
                return false;
            newHead1 = newHead1.next;
            head = head.next;
        }
        return true;
    }
    public static void main(String[] args)
    {
        List list = new List();
        ListNode listNode1 = list.addNodes();
        System.out.println(isPalindrome(listNode1));
    }
}