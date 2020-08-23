import java.util.*;
import java.lang.*;
import java.io.*;



public class MergeTwoLists
{
    static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode head = null;
        ListNode tail = null;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                if(head == null)
                {
                    tail = l1;
                    head = l1;
                }
                else
                {
                    tail.next = l1;
                    tail = tail.next;
                }
                l1 = l1.next;
            }
            else
            {
                if(head == null)
                {
                    tail = l2;
                    head = l2;
                }
                else
                {
                    tail.next = l2;
                    tail = tail.next;
                }
                l2 = l2.next;
            }
        }
        while(l1 != null)
        {
            if(head == null)
            {
                tail = l1;
                head = l1;
            }
            else
            {
                tail.next = l1;
                tail = tail.next;
            }
            l1 = l1.next;
        }
        while(l2 != null)
        {
            if(head == null)
            {
                tail = l2;
                head = l2;
            }
            else
            {
                tail.next = l2;
                tail = tail.next;
            }
            l2 = l2.next;
        }
        return head;
    }
    public static void main(String[] args)
    {
        List list = new List();
        ListNode listNode1 = list.addNodes();
        ListNode listNode2 = list.addNodes();
        ListNode head = mergeTwoLists(listNode1, listNode2);
        list.printNodes(head);
    }
}