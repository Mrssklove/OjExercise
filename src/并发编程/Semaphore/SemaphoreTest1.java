package 并发编程.Semaphore;

import 牛客网2018.网易2018.C;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 * acquire阻塞
 * tryacquire 尝试获取
 * tryacquire(Timeout)
 */
public class SemaphoreTest1 {
    public static void main(String[] args)
    {
        Semaphore semaphore=new Semaphore(3);
        ExecutorService executorService=Executors.newCachedThreadPool();
        int ClientTotal=200;
        for(int i=0;i<ClientTotal;i++)
        {
            final int threadNum=i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        test(threadNum);
                        semaphore.release();
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }

    public static void test(int num) throws Exception
    {
        Thread.sleep(1000);
        System.out.println(num);
    }
}
