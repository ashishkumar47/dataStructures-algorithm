import java.util.*;
import java.lang.*;
import java.io.*;




public class RemoveNthFromEnd
{

    static ListNode removeNodeOnepass(ListNode head, int n)
    {
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        int i = 0;
        while(i != n)
        {
            fast = fast.next;
            i++;
        }
        if(fast == null)
        {
            return slow.next;
        }
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return temp;
    }

    public static void main(String[] args)
    {
        List list = new List();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ListNode listNode = list.addNodes();
        ListNode head = removeNodeOnepass(listNode, n);
        list.printNodes(head);
    }
}