package Leetcode;

/*
统计素数
 */
public class CountPrimes {
    public int countPrimes(int n) {
        int count=0;
        boolean[] notprime=new boolean[n];
        for(int i=2;i<n;i++)
        {
            if(notprime[i]==false)
            {
                count++;
                for(int j=2;i*j<n;++j)
                    notprime[i*j]=true;
            }

        }
        return count;
    }


    /**
     * 超时
     * @param n
     * @return
     */
    public boolean isPrime(int n)
    {
        if(n==1)
            return false;
        if(n==2||n==3)
            return true;
        for(int i=2;i<=n/2;i++)
            if(n%i==0)
                return false;
        return true;
    }
}
