import java.util.*;
import java.lang.*;
import java.io.*;





public class AddTwoNumbers
{
    static ListNode addTwoNumbers(ListNode newNode1, ListNode newNode2)
    {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while(newNode1 != null && newNode2 != null)
        {
            int sum = newNode1.val + newNode2.val + carry;
            carry = sum / 10;
            ListNode ans = new ListNode(sum % 10);
            if(head == null)
            {
                head = ans;
                tail = ans;
            }
            else
            {
                tail.next = ans;
                tail = tail.next;
            }
            newNode1 = newNode1.next;
            newNode2 = newNode2.next;
        }
        while(newNode1 != null)
        {
            int sum = newNode1.val + carry;
            carry = sum / 10;
            ListNode ans = new ListNode(sum % 10);
            tail.next = ans;
            tail = tail.next;
            newNode1 = newNode1.next;
        }
        while(newNode2 != null)
        {
            int sum = newNode2.val + carry;
            carry = sum / 10;
            ListNode ans = new ListNode(sum % 10);
            tail.next = ans;
            tail = tail.next;
            newNode2 = newNode2.next;
        }
        while(carry != 0)
        {
            ListNode ans = new ListNode(carry);
            tail.next = ans;
            tail = tail.next;
            carry = carry / 10;
        }
        return head;
    }

    public static void main(String[] args)
    {
        List list = new List();
        ListNode listNode1 = list.addNodes();
        ListNode listNode2 = list.addNodes();
        ListNode temp = addTwoNumbers(listNode1, listNode2);
        list.printNodes(temp);
    }
}