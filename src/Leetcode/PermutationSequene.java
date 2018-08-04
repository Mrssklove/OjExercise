package Leetcode;

public class PermutationSequene {
    public String getPermutation(int n, int k) {
        int maxnum=1;
        StringBuilder res=new StringBuilder();
        for(int i=1;i<n;i++)
        {
            maxnum*=i;
            res.append(String.valueOf(i));
        }
        res.append(String.valueOf(n));
        StringBuilder sb=new StringBuilder();
        for(int i=n-1;i>=1;i--)
        {
            int tar=(k-1)/maxnum;
            k=k-tar*maxnum;
            sb.append(res.charAt(tar));
            res.delete(tar,tar+1);
            maxnum/=i;
        }
        sb.append(res.charAt(0));
        return sb.toString();
    }
}
