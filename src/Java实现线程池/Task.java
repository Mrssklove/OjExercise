package Java实现线程池;

public class Task implements Runnable {

    private int num;

    public Task(int n)
    {
        this.num=n;
    }

    @Override
    public void run() {
         System.out.println("Task "+num+" is Running");
    }
}
