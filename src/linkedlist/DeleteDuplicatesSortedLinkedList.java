package linkedlist;

public class DeleteDuplicatesSortedLinkedList {
    private static class ListNode{
        int val;
       ListNode next;
        ListNode(){}
        ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prev=new ListNode();
         ListNode result=prev;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            boolean f=false;
            while(temp!=null && temp.val==curr.val){
                curr=curr.next;
                temp=temp.next;
                f=true;
            }
            if(f) {
                prev.next = temp;
            }else{
                prev.next=curr;
                prev=prev.next;
            }
            curr=temp;

        }

        return result.next;
    }
    public static void main(String[] args) {
//        int[] arr={1,1,1,2,3,3,4,4,4,5};
        int[] arr={1,2,3,3,4,4,5};
       ListNode node =new ListNode(arr[0],null);
        ListNode temp=node;
        for(int i=1;i<arr.length;i++){
            temp.next=new ListNode(arr[i],null);
            temp=temp.next;
        }
        node=deleteDuplicates(node);
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
