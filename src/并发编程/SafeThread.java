package 并发编程;

import 牛客网2018.网易2018.C;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**二种解决方案
 * 1.Semaphore=1，控制最大并发线程位1
 * 2.AtomicInteger，
 */
public class SafeThread {

    public final static int ClientTotal=5000;

    public final static int ThreadTotal=1;

    public  static int count=0;

    public final static CountDownLatch countDownLatch=new CountDownLatch(ClientTotal);

    public static void main(String[] args) throws Exception
    {
        Semaphore semaphore=new Semaphore(ThreadTotal);

        ExecutorService executorService=Executors.newCachedThreadPool();

        for(int i=0;i<ClientTotal;++i)
        {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        add();
                        semaphore.release();
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    };
                   countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println(count);


    }

    private static void add()
    {
        count++;
    }
}
