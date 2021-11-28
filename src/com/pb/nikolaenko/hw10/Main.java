package com.pb.nikolaenko.hw10;

public class Main {
    public static void main(String[] args) {
        demoInt();
        demoLong();
        demoFloat();
        demoDouble();
    }

    private static void demoInt() {
        System.out.println("---Integer---");
        NumBox<Integer> intBox = new NumBox<>(4, Integer.class);
        intBox.add(1);
        intBox.add(2);
        intBox.add(3);
        intBox.add(4);
        intBox.printArr();
        System.out.println("arr[2]: " + intBox.get(2));
        System.out.println("length: " + intBox.length());
        System.out.println("average: " + intBox.average());
        System.out.println("sum: " + intBox.sum());
        System.out.println("max: " + intBox.max());
    }

    private static void demoLong() {
        System.out.println("---Long---");
        NumBox<Long> longBox = new NumBox<>(5, Long.class);
        longBox.add(28L);
        longBox.add(39L);
        longBox.add(200L);
        longBox.add(45L);
        longBox.add(10L);
        longBox.printArr();
        System.out.println("get[3]: " + longBox.get(3));
        System.out.println("length: " + longBox.length());
        System.out.println("average: " + longBox.average());
        System.out.println("sum: " + longBox.sum());
        System.out.println("max: " + longBox.max());
    }

    private static void demoFloat() {
        System.out.println("---Float---");
        NumBox<Float> floatBox = new NumBox<>(6, Float.class);
        floatBox.add(10F);
        floatBox.add(41F);
        floatBox.add(12F);
        floatBox.add(1F);
        floatBox.add(147F);
        floatBox.add(400F);

        floatBox.printArr();
        System.out.println("get[5]: " + floatBox.get(5));
        System.out.println("length: " + floatBox.length());
        System.out.println("average: " + floatBox.average());
        System.out.println("sum: " + floatBox.sum());
        System.out.println("max: " + floatBox.max());
    }

    private static void demoDouble() {
        System.out.println("---Double---");
        NumBox<Double> doubleBox = new NumBox<>(5, Double.class);
        doubleBox.add(2.4);
        doubleBox.add(3.0);
        doubleBox.add(1.5);
        doubleBox.add(0.6);
        doubleBox.add(0.3);

        doubleBox.printArr();
        System.out.println("get[1]: " + doubleBox.get(1));
        System.out.println("length: " + doubleBox.length());
        System.out.println("average: " + doubleBox.average());
        System.out.println("sum: " + doubleBox.sum());
        System.out.println("max: " + doubleBox.max());
    }

}


