import java.util.*;
import java.lang.*;
import java.io.*;



public class IntersectionNode
{
    static ListNode intersectionNode(ListNode headA, ListNode headB)
    {
        int length1 = 0, length2 = 0;
        ListNode trav1 = headA;
        ListNode trav2 = headB;
        while(trav1 != null)
        {
            length1++;
            trav1 = trav1.next;
        }
        while(trav2 != null)
        {
            length2++;
            trav2 = trav2.next;
        }
        int d = Math.abs(length2 - length1);
        if(length1 <= length2)
        {
            int i = 0;
            while(i != d)
            {
                headB = headB.next;
                i++;
            }
        }
        else
        {
            int i = 0;
            while(i != d)
            {
                headA = headA.next;
                i++;
            }
        }
        while(headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public static void main(String[] args)
    {

    }
}