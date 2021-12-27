package com.pb.nikolaenko.hw13;

import java.util.LinkedList;
import java.util.Random;


public class ProducerConsumer {

    static class Producer extends Thread {
        private final LinkedList<String> buffer;
        private final LinkedList<String> data;
        private int index = 0;

        public Producer(LinkedList<String> buffer, LinkedList<String> data) {
            this.buffer = buffer;
            this.data = data;
        }

        @Override
        public void run() {
            synchronized (buffer) {
                while (!data.isEmpty()) {
                    index++;
                    int cnt = 0;
                    System.out.println();

                    while (cnt < 5 && !data.isEmpty()) {
                        System.out.println(index + ") " + getName() + " - " + data.get(0));
                        buffer.add(data.get(0));
                        data.remove(0);
                        cnt++;
                    }
                    try {
                        buffer.notify();
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if (!data.isEmpty()) data.remove(0);
                    }
                }
            }
        }
    }

    static class Consumer extends Thread {

        private final LinkedList<String> buffer;
        private int index = 0;

        public Consumer(LinkedList<String> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            synchronized (buffer) {
                while (!buffer.isEmpty()) {
                    index++;
                    System.out.println();
                    int cnt = 0;

                    while (cnt < 5 && !buffer.isEmpty()) {
                        System.out.println(index + ") " + getName() + " - " + buffer.get(0));
                        buffer.remove(0);
                        cnt++;
                    }
                    try {
                        buffer.notify();
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] strings) {
        LinkedList<String> queue = new LinkedList<String>();
        LinkedList<String> data = new LinkedList<String>();
        int dataCount = 15;

        for (int i = 0; i < dataCount; i++) {
            data.add(String.valueOf(new Random().nextInt(150)));
        }

        Producer producer = new Producer(queue, data);
        producer.setName("Producer");
        producer.start();

        Consumer consumer = new Consumer(queue);
        consumer.setName("Consumer");
        consumer.start();
    }
}
