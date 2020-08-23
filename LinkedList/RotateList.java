import java.util.*;
import java.lang.*;
import java.io.*;




public class RotateList
{
    static ListNode rotate(ListNode head, int k)
    {
        if(head == null)
            return null;
        ListNode newHead = head;
        ListNode tail = head;
        int i = 0;
        while(i != k - 1)
        {
            tail = tail.next;
            i++;
        }
        if(tail == null || tail.next == null)
            return head;
        ListNode rotatedHead = tail.next;
        ListNode travHead = tail.next;
        tail.next = null;
        while(travHead.next != null)
        {
            travHead = travHead.next;
        }
        travHead.next = newHead;
        return rotatedHead;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List list = new List();
        ListNode listNode1 = list.addNodes();
        if(list.listLength(listNode1) < n)
        {
            System.out.println("Invalid test case");
        }
        else
        {
            ListNode temp = rotate(listNode1, n);
            list.printNodes(temp);
        }

    }
}