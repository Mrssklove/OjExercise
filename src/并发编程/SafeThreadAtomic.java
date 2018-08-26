package 并发编程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SafeThreadAtomic {

    //总连接请求
    private final static int ClientTotal=5000;

    //最高允许并发线程200
    private final static int ThreadTotal=100;

    private static AtomicInteger count=new AtomicInteger(0);

    public static void main(String[] args) throws  Exception
    {
        Semaphore semaphore=new Semaphore(ThreadTotal);

        //等待全部线程执行结束才打印count值，不然会发生线程未执行完就打印count的值了
        CountDownLatch countDownLatch=new CountDownLatch(ClientTotal);

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
                    }
                    countDownLatch.countDown();
                }
            });
        }
         countDownLatch.await();
        executorService.shutdown();
         System.out.println(count);
    }

    public static void add()
    {
      count.getAndIncrement();
    }
}
