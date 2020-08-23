import java.util.*;
import java.lang.*;
import java.io.*;



public class CopyRandomList
{
    static Node copyRandomListUsingMap(Node head)
    {
        Map<Node, Node>map = new HashMap<>();
        Node temp = head;
        while(temp != null)
        {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while(temp != null)
        {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    
    public static void main(String[] args)
    {

    }
}