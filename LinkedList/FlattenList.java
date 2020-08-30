
import java.util.*;
import java.lang.*;
import java.io.*;




public class FlattenList
{
    static ListNode mergeSortedList(ListNode l1, ListNode l2)
    {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode head = null;
        ListNode tail = null;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                if(head == null)
                {
                    head = l1;
                    tail = l1;
                }
                else
                {
                    tail.bottom = l1;
                    tail = tail.bottom;
                }
                l1 = l1.bottom;
            }
            else
            {
                if(head == null)
                {
                    head = l2;
                    tail = l2;
                }
                else
                {
                    tail.bottom = l2;
                    tail = tail.bottom;
                }
                l2 = l2.bottom;
            }
        }

        while(l1 != null)
        {
            tail.bottom = l1;
            tail = tail.bottom;
            l1 = l1.bootom;
        }
        while(l2 != null)
        {
            tail.bottom = l2;
            tail = tail.bottom;
            l2 = l2.bottom;
        }
        return head;
    }
    public static void main(String[] args)
    {
    	List list= new List();
    	ListNode root=list.addNodes();
        ListNode l1 = null;
        ListNode l2 = root;
        while(l2 != null)
        {
            ListNode newNode = mergeSortedList(l1, l2);
            l1 = newNode;
            l2 = l2.next;
        }
        list.printNodes(l1);
    }
}