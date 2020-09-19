import java.util.*;
import java.lang.*;
import java.io.*;



class Node{
    Node next;
    Node prev;
    int data;
    int key;
    Node(int key,int data){
        this.data=data;
        this.key=key;
        this.prev=null;
        this.next=null;
    }
}
class LRUCache {
    int size;
    Map<Integer,Node>lru;
    Node head,tail;
    public LRUCache(int capacity) {
        size=capacity;
        lru=new HashMap<>(capacity);    
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        Node cacheNode=lru.get(key);
        if(cacheNode!=null){
            //remove the existing node fro the linkedList,if present in map.
            removeNode(cacheNode);
            //add node to the tail.
            addNodeToTail(cacheNode);
            return cacheNode.data;
        }
        return -1;        
    }
    
    public void put(int key, int value) {
        Node newNode= new Node(key,value);
        // when we are just updating the previous node.
        if(lru.get(key)!=null){
            removeNode(lru.get(key));
            addNodeToTail(newNode);
            lru.put(key,newNode);
        }
        else{
            //when the map is full with capacity, remove from map and remove the head node.
            if(lru.size()==size){
            lru.remove(head.next.key);
            addNodeToTail(newNode);
            removeNode(head.next);
            lru.put(key,newNode);
            }
            else{
                //add node to the tail and add in map.
               addNodeToTail(newNode);
               lru.put(key,newNode);
            }
        }
    }
    public void addNodeToTail(Node node){
        Node savePrev=tail.prev;
        node.next=tail;
        tail.prev=node;
        savePrev.next=node;
        node.prev=savePrev;       
    }
    public void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        }
    }



public class LruCache{
	public static void main(String[] args) {
		
	}
}