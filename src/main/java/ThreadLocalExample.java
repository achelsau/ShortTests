/**
 * Created by ariel on 15/12/2017.
 */
public class ThreadLocalExample {


    public static class MyRunnable implements Runnable {

        private Integer threadLocal = new Integer(0);
        //private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
        private static Object obj = new Object();

        @Override
        public void run() {
            threadLocal = (int) (Math.random() * 100D);
            //threadLocal.set((int) (Math.random() * 100D));

            System.out.println("Setting : " + Thread.currentThread().getName() + ", " + threadLocal);
            // System.out.println("Setting : " + threadLocal.get());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println("Reading " + Thread.currentThread().getName() + ", " + threadLocal);
            //System.out.println("Getting : " + threadLocal.get());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }

}
