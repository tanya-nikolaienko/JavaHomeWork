package com.pb.nikolaenko.hw15;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ChatServer implements TCPConnectionListener {//и чат сервер и слушатель

    public static void main(String[] args) {
        new ChatServer();

    }

    private final ArrayList<TCPConnection> connections = new ArrayList<>();//список соединений


    private ChatServer(){
        System.out.println("Server running...");
        try(ServerSocket serversocket = new ServerSocket(8189)){//создаем сервер сокет которій слушает порт
            while (true){
                try{
                    new TCPConnection(this,serversocket.accept());//ждем успешного соединения, как только установилось, возвращаем обїект сокета

                }catch (IOException e){
                    System.out.println("TCPConnection exception: " + e);
                }
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void onConnectionReady(TCPConnection tcpConnection) {
        connections.add(tcpConnection);
        sendToAllconnections("Client connected: " + tcpConnection);

    }

    @Override
    public synchronized void onReceiveString(TCPConnection tcpConnection, String value) {
        sendToAllconnections(value);


    }

    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        connections.remove(tcpConnection);
        sendToAllconnections("Client disconnected: " + tcpConnection);

    }

    @Override
    public synchronized void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println("TCPConnection exception: " +e);

    }
    private void sendToAllconnections(String value){
        System.out.println(value);
        for(int i=0; i<connections.size();i++){
            connections.get(i).sendString(value);
        }

    }
}
