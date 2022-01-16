package com.pb.nikolaenko.hw15;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;


public class TCPConnection {
    private final Socket socket;
    private final Thread rxThread;
    private final TCPConnectionListener eventListener;// слушатель
    private final BufferedReader in;
    private final BufferedWriter out;

    public TCPConnection(TCPConnectionListener eventListener, String ipAddr, int port) throws IOException{
         this(eventListener,new Socket(ipAddr,port));
    }



    public TCPConnection(TCPConnectionListener eventListener,Socket socket) throws IOException {//constructor принимает уже готовій сокет созданній cнаружи
        this.socket=socket;
        this.eventListener=eventListener;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("UTF-8")));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),Charset.forName("UTF-8")));

        rxThread= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    eventListener.onConnectionReady(TCPConnection.this);
                    while (!rxThread.isInterrupted()) {//пока поток не прерван
                       //получаем строчку
                        eventListener.onReceiveString(TCPConnection.this,in.readLine());//отдаем ее слушателю, передаем обьект соединения и саму строчку
                    }
                }catch(IOException e) {
                    eventListener.onException(TCPConnection.this, e);

                } finally {
                    eventListener.onDisconnect(TCPConnection.this);

                }
            }
        });
        rxThread.start();
    }

    public synchronized void sendString(String value){
        try {
            out.write(value + "\r\n");//записали в буфер+возврат каретки и перевод строки для опредедения конца строки
            out.flush();//передали из буфера

        } catch (IOException e) {
            eventListener.onException(TCPConnection.this, e);
            disconnect();
        }

    }

    public synchronized void disconnect(){
        rxThread.interrupt();//преріваем поток и закріваем сокет
        try {
            socket.close();
        } catch (IOException e) {
            eventListener.onException(TCPConnection.this, e);
        }

    }

    @Override
    public String toString() {
        return "TCPConnection: " + socket.getInetAddress() + ": " + socket.getPort();
    }
}
