/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int leng1=0;
        int leng2=0;
        int sum=0;
        int carry=0;
       ListNode temp1=l1;
        ListNode temp2=l2;
        while(temp1!=null||temp2!=null){
            if(temp1!=null){
                 leng1++;
                 temp1=temp1.next;
                 }
            if(temp2!=null){
                leng2++;
                temp2=temp2.next;
            }
            
            
        }
        temp1=l1;
        temp2=l2;
        
        if(leng1>=leng2){
             while(temp1!=null){
                int value=(temp2!=null)?temp2.val:0;
            sum=temp1.val+value+carry;
            temp1.val=sum%10;
            sum=sum/10;
            carry=sum;
            if(temp1.next==null){
                break;
            }
            temp1=temp1.next;
            temp2=(temp2!=null)?temp2.next:null;
        }
        if(carry!=0){
            ListNode newHead = new ListNode(carry);
            temp1.next = newHead;
            
            
        }
        return l1;

        }
        else {
             while(temp2!=null){
                int value = (temp1!=null)?temp1.val:0;
            sum=temp2.val+value+carry;
            temp2.val=sum%10;
            sum=sum/10;
            carry=sum;
            if(temp2.next==null){
                break;
            }
            temp2=temp2.next;
            temp1=(temp1!=null)?temp1.next:null;
        }
        if(carry!=0){
            ListNode newHead = new ListNode(carry);
            temp2.next = newHead;
            
        }
        return l2;

        }
       
    }
}
