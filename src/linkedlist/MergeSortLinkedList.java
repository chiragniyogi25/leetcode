package linkedlist;

import java.util.LinkedList;
import java.util.List;

/**Sorting linked List in ascending order*/
public class MergeSortLinkedList {
    private static class ListNode{
        private int val;
        private ListNode next;
        ListNode(){}
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    //performing merge sort on linked List
    public static ListNode mergeSortLinkedList(ListNode head){
        if(head==null || head.next==null)
            return head;
        //finding the middle element
        //1 2 3 4 5
        //1 2 3->null
        ListNode mid=findMiddle(head);
        ListNode newHead=mid.next;
        mid.next=null;
        ListNode l1=mergeSortLinkedList(head);
        ListNode l2=mergeSortLinkedList(newHead);
        return mergeTwoSortedList(l1,l2);
    }
    //performing merging
    public static ListNode mergeTwoSortedList(ListNode first,ListNode second){
        if(first==null || second==null)return first!=null?first:second;
        ListNode result=new ListNode(0,null);
        ListNode temp=result;
        while(first!=null && second!=null){
            if(first.val<=second.val){
                temp.next=new ListNode(first.val,null);
                first=first.next;
            }else{
                temp.next=new ListNode(second.val,null);
                second=second.next;
            }
            temp=temp.next;
        }
        while(first!=null){
            temp.next=new ListNode(first.val,null);
            first=first.next;
            temp=temp.next;
        }
        while(second!=null){
            temp.next=new ListNode(second.val,null);
            second=second.next;
            temp=temp.next;
        }
        return result.next;
    }
    //finding middle Element
    public static ListNode findMiddle(ListNode curr){
        if(curr==null || curr.next==null)
            return curr;
        ListNode slowPtr=curr;
        ListNode fastPtr=curr.next.next;
        while(fastPtr!=null && fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
        }
        return slowPtr;
    }

    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        ListNode node =new ListNode(arr[0],null);
        ListNode temp=node;
        ListNode start=node;
        ListNode end=null;
        for(int i=1;i<arr.length;i++){
            temp.next=new ListNode(arr[i],null);
            temp=temp.next;
        }
        node=mergeSortLinkedList(node);
        //        /**For Printing The Linked List*/
        while(node!=null){
            if(node.next==null)
                System.out.println(node.val);
            else
                System.out.print(node.val+"->");
            node=node.next;
        }
    }
}
