package test;

import java.util.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName copyRandomList
 * @Description TODO
 * @Auther danni
 * @Date 2019/10/11 22:26]
 * @Version 1.0
 **/

public class copyRandomList {
    public static class Node {
        int val;
        Node next;
        Node random;

        Node() {}

        Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
    public Node copyRandomList(Node head){
        Node newhead=null;
        Node newlast=null;
        Node node=head;
        Map<Node,Node> map=new HashMap<>();
        while(node!=null){
            Node cur=new Node();
            cur.val=node.val;
            if(newhead==null){
                newhead=cur;
            }else{
                newlast.next=cur;
            }
            newlast=cur;
            map.put(node,cur);
            node=node.next;
        }
        node=newhead;
        Node temp=head;
        while(node!=null){
            if(temp.random!=null){
                node.random=map.get(temp.random);
            }else{
                node.random=null;
            }
            node=node.next;
            temp=temp.next;
        }
        return newhead;
    }
    public static void main(String[] args) {

    }
}
