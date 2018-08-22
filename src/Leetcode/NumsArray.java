package Leetcode;

/**
 * 线段树
 */
public class NumsArray {
    static class SegmentTree{
        public int start;
        public int end;
        public SegmentTree left,right;
        public int sum;

        public SegmentTree(int start,int end)
        {
            this.start=start;
            this.end=end;
            this.sum=0;
            this.left=null;
            this.right=null;
        }
    }

    public SegmentTree root=null;

    public NumsArray(int[] nums) {
          root=buildTree(nums,0,nums.length-1);
    }

    //构造线段树
    private SegmentTree buildTree(int[] nums,int start,int end)
    {

        if(start>end)
            return null;
        if(start==end)
        {
            SegmentTree temp=new SegmentTree(start,end);
            temp.sum=nums[start];
            return temp;
        }
        else
        {
            int mid=(start+end)/2;
            SegmentTree root=new SegmentTree(start,end);
            SegmentTree left=buildTree(nums,start,mid);
            SegmentTree right=buildTree(nums,mid+1,end);
            root.left=left;
            root.right=right;
            root.sum=left.sum+right.sum;
            return root;
        }
    }

    public void update(int i, int val) {
          update(root,i,val);
    }

    //更新值 顺带sum也要更新
    private void update(SegmentTree root,int i,int val)
    {
        if(root==null)
            return;
        if(root.start==root.end&&root.start==i)
            root.sum=val;
        else
        {
            int mid=(root.start+root.end)/2;
            if(i>mid)
                update(root.right,i,val);
            else
                update(root.left,i,val);
            root.sum=root.left.sum+root.right.sum;
        }
    }

    //求区间和
    public int sumRange(int i, int j) {
      return sumRange(root,i,j);
    }

    private int sumRange(SegmentTree root,int i,int j)
    {
        if(root==null)
            return 0;
        if(root.start==i&&root.end==j)
            return root.sum;
        int mid=(root.start+root.end)/2;
        if(i>mid)
            return sumRange(root.right,i,j);
        else if(j<mid)
            return sumRange(root.left,i,j);
        else
            return sumRange(root.left,i,mid)+sumRange(root.right,mid+1,j);
    }


}
