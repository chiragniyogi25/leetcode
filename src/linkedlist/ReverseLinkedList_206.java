package linkedlist;

/**Reverse a Linked List*/
public class ReverseLinkedList_206 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    //Recursive
    //1-> 2 ->3-> 4-> 5->null
    //5->4->null
    public static ListNode reverseWithRecursion(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode newHead=reverseWithRecursion(head.next);
        //point headNext to next of head
        ListNode headNext=head.next;
        headNext.next=head;
        head.next=null;
        return newHead;
    }
    //Iterative
    private static ListNode reverseListWithoutRecursion(ListNode head){
        ListNode curr=head;//intially current will point to fisrt index
        ListNode prev=null;//initially prev will be null
        while(curr!=null){
            ListNode temp=curr.next;//to keep a track of the next element of the current element
            curr.next=prev;
            prev=curr;//assigning prev to curr incrementing
            curr=temp;
        }

        return prev;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        //creating a new Node
        ListNode node=new ListNode(arr[0],null);
        ListNode temp=node;
        for(int i=1;i<arr.length;i++){
            temp.next=new ListNode(arr[i],null);
            temp=temp.next;
        }
//        node=reverseListWithoutRecursion(node);
        node = reverseWithRecursion(node);

//        /**For Printing The Linked List*/
        while(node!=null){
            if(node.next==null)
                System.out.println(node.val);
            else
                System.out.print(node.val+"->");
            node=node.next;
        }
//        System.out.println();
//        while(temp!=null){
//            if(temp.next==null)
//                System.out.println(temp.val);
//            else
//                System.out.print(temp.val+"->");
//            temp=temp.next;
//        }
    }
}
