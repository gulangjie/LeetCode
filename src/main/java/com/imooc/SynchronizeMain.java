package com.imooc;

public  class SynchronizeMain implements Runnable {

    static SynchronizeMain instance = new SynchronizeMain();

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);

    }

    public void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }
}
