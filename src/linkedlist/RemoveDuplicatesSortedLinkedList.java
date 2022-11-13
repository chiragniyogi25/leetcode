package linkedlist;

public class RemoveDuplicatesSortedLinkedList {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    /**Brute Force Approach*/
    public static ListNode removeDuplicatesFromSortedLL(ListNode head){
//        ListNode curr=head;
//        while(curr!=null){
//            ListNode temp=curr.next;
//            while(temp!=null && temp.val==curr.val){
//                temp=temp.next;
//            }
//            curr.next=temp;
//            curr=curr.next;
//        }
//        return head;
        ListNode curr=head;
        if(curr==null)return null;
        while(curr.next!=null){
            if(curr.val==curr.next.val){
                curr.next=curr.next.next;
            }
            curr=curr.next;
        }
        return head;
    }
    public static void main(String[] args) {
//        int[] arr={1,1,1,2,3,3,4,4,4,5};
        int[] arr={2,2,2,2};
        ListNode node =new ListNode(arr[0],null);
        ListNode temp=node;
        for(int i=1;i<arr.length;i++){
            temp.next=new ListNode(arr[i],null);
            temp=temp.next;
        }
        node=removeDuplicatesFromSortedLL(node);
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
