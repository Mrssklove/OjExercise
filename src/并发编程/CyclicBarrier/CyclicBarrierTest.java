package 并发编程.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 互相等待 形成一个环
 * countdownlacth 一个线程等待其他线程
 */
public class CyclicBarrierTest {
    static CyclicBarrier cyclicBarrier=new CyclicBarrier(5);
    public static void main(String[] args) throws Exception
    {

        ExecutorService executorService=Executors.newCachedThreadPool();
        for(int i=0;i<10;i++)
        {
            final int threadNum=i;
            Thread.sleep(1000);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        test(threadNum);
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }

    private static void test(int threadnum) throws Exception
    {
        System.out.println("waiting");
        Thread.sleep(1000);
        cyclicBarrier.await();
        System.out.println("continue");
    }
}
