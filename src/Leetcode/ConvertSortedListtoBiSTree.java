package Leetcode;

import Model.ListNode;
import Model.TreeNode;

import java.util.List;

/**
 * 链表中点 快慢指针
 */
public class ConvertSortedListtoBiSTree {
    public TreeNode sortedListToBST(ListNode head) {
     if(head==null)
         return null;
     ListNode slow=head;
     ListNode fast=head;
     ListNode left=slow;
     ListNode right=fast;
     ListNode prev=head;
     if(head.next==null)
     {
         TreeNode root=new TreeNode(head.val);
         root.left=sortedListToBST(null);
         root.right=sortedListToBST(null);
         return root;
     }
     else {
         while (fast!=null&&fast.next!=null)
         {
             prev=slow;
             slow=slow.next;
             fast=fast.next.next;
         }
         TreeNode root=new TreeNode(slow.val);
         right=slow.next;
         prev.next=null;
         root.left=sortedListToBST(left);
         root.right=sortedListToBST(right);
         return root;
     }
    }
}
