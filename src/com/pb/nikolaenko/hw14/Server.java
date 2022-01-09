package com.pb.nikolaenko.hw14;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

class Server {

    public static int port = 4333;
    public static LinkedList<ServerWork> connectList = new LinkedList<>();

    // Серверная часть (старт)
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("ЭХО-сервер запущен");
        try {
            while (true) {
                Socket socket = server.accept();
                try {
                    connectList.add(new ServerWork(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}