package Java实现线程池;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    private final int nThreads;  //线程的个数

    private final PoolWorker[] threads;   //固定线程的个数 可用list代替

    private final LinkedBlockingQueue<Runnable> queue;  //任务队列

    public ThreadPool(int nThreads)
    {
        this.nThreads=nThreads;
        queue=new LinkedBlockingQueue();
        threads=new PoolWorker[nThreads];

        for(int i=0;i<nThreads;i++)
        {
          threads[i]=new PoolWorker();
          threads[i].start();
        }
    }


    public void execute(Runnable task)
    {
        synchronized (queue)
        {
            queue.add(task); //向队列中添加任务
            queue.notify(); //唤醒一个线程
        }
    }


    /**
     * 给工作队列加同步锁 synchronized+wait+notify 也可以lock+condition实现
     *
     */
    private class PoolWorker extends  Thread{
        public void run()
        {
            Runnable task;
            while (true)
            {
                synchronized (queue)
                {
                    while (queue.isEmpty()){
                        try {
                            queue.wait();  //线程没有任务，等待
                        }catch (InterruptedException e)
                        {
                            System.out.println("An error ocurred while queue is waiting");
                        }
                    }

                    //有任务时，线程被唤醒，
                    task=queue.poll();

                    try {
                        task.run();
                    }catch (RuntimeException e)
                    {
                        System.out.println("Thread Pool is interrupted dut to an issue");
                    }
                }
            }
        }
    }
}
