import java.util.*;
import java.lang.*;
import java.io.*;


class ListNode
{
    int val;
    ListNode next;
    ListNode()
    {

    }
    ListNode(int val)
    {
        this.val = val;
        this.next = null;
    }
}

public class List
{
    static ListNode addNodes()
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ListNode head = null;
        ListNode tail = null;
        while(n != -1)
        {
            ListNode node = new ListNode(n);
            if(head == null)
            {
                head = node;
                tail = node;
            }
            else
            {
                tail.next = node;
                tail = tail.next;
            }
            n = input.nextInt();
        }
        return head;
    }
    static int listLength(ListNode head)
    {
        int count = 0;
        while(head != null)
        {
            head = head.next;
            count++;
        }
        return count;
    }
    static void printNodes(ListNode head)
    {
        while(head != null)
        {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        ListNode listNode = addNodes();
        printNodes(listNode);
    }
}