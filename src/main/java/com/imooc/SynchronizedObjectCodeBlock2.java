package com.imooc;

/**
 * @author 孤狼杰 : clj
 * @create_date: 2021/3/16 23:41
 * @desc:
 * @modifier:
 * @modifier_date:
 * @desc:
 */
public class SynchronizedObjectCodeBlock2 implements Runnable {

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while(t1.isAlive() || t2.isAlive()){}
        System.out.println("线程执行完毕");
    }

    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run() {
        synchronized(lock1){
            System.out.println("我是lock1。 我叫 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "lock1 运行结束");
        }
        synchronized(lock2){
            System.out.println("我是lock2。 我叫 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "lock2 运行结束");
        }
    }
}
