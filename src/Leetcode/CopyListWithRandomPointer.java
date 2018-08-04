package Leetcode;

import Model.RandomListNode;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        //复制节点 不含random
        RandomListNode root=head;
        while (root!=null)
        {
            RandomListNode temp=new RandomListNode(root.label);
            temp.next=root.next;
            root.next=temp;
            root=temp.next;
        }
        //补上random指针的指向
        root=head;
        while (root!=null)
        {
            if(root.random!=null)
            {
                RandomListNode randomNode=root.random.next;
                root.next.random=randomNode;
            }
            root=root.next.next;
        }

        //断开
        root=head;
        RandomListNode copystart=root.next;
        RandomListNode res=copystart;
        while (copystart.next!=null)
        {
            root.next=copystart.next;
            root=root.next;
            copystart.next=copystart.next.next;
            copystart=copystart.next;
        }
        root.next=null;
        return res;
    }
}
