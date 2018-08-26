package 并发编程.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**适用场景
 * 并行计算
 * 等待超时
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
