package com.pb.nikolaenko.hw14;
class Client {

    public static String ipAddr = "localhost";
    public static int port = 4333;

    // Клиентская часть (старт)
    public static void main(String[] args) {
        new ClientWork(ipAddr, port);
    }
}