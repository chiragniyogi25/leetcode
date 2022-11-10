package linkedlist;

import java.util.HashSet;

/**Remove Duplicates from unsorted Linked List**/
public class RemoveDuplicatesUnsortedLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode removeDuplicates(ListNode head){
        if(head==null)
            return null;
        ListNode curr=head;
        ListNode prev=null;
        HashSet<Integer> set=new HashSet<>();
        while(curr!=null){
            if(prev!=null && set.contains(curr.val)){
                prev.next=curr.next;
            }
            if(prev==null||(prev!=null && !set.contains(curr.val))) {
                set.add(curr.val);
                prev=curr;
            }
            curr=curr.next;

        }
        return head;
    }
    public static void main(String[] args) {
//        int[] arr={9,8,4,30,20,14,12,8,9};
        int[] arr={88,8,8,8,8};
        ListNode node =new ListNode(arr[0],null);
        ListNode temp=node;
        for(int i=1;i<arr.length;i++){
            temp.next=new ListNode(arr[i],null);
            temp=temp.next;
        }
        node=removeDuplicates(node);
        while(node!=null){
            if(node.next==null)
                System.out.print(node.val);
            else
                System.out.print(node.val+"->");
            node=node.next;
        }
    }
}
