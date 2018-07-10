package 秋招2017;

import Model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 反序列化时 由于不好确定左右部分 采取list的结构 构造一个节点 删除一个元素
 */
public class 二叉树的序列化 {
    public String serialize(TreeNode root) {
        // write your code here
       StringBuilder sb=new StringBuilder();
       serialize(root,sb);
       return sb.toString();
    }

    public String serialize(TreeNode root,StringBuilder sb) {
        // write your code here
       if(root==null)
       {
           sb.append('#');
           sb.append('!');
           return sb.toString();
       }
       else
       {
           sb.append(root.val);
           sb.append('!');
       }
       serialize(root.left,sb);
       serialize(root.right,sb);
       return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        String[] src=data.split("!");
        List<String> srclist=new ArrayList<>();
        for(int i=0;i<src.length;i++)
            srclist.add(src[i]);
        TreeNode res=deserialize(srclist);
        return res;
    }


    public TreeNode deserialize(List<String> src) {
        // write your code here
        if(src.get(0).equals("#"))
        {
            src.remove(0);
            return null;
        }
        else
        {
            int value=Integer.parseInt(src.get(0));
            src.remove(0);
            TreeNode res=new TreeNode(value);
            res.left=deserialize(src);
            res.right=deserialize(src);
            return res;
        }
    }

}
