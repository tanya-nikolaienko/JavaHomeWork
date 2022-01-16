package com.pb.nikolaenko.hw15;

public interface TCPConnectionListener {//типы событий
    void onConnectionReady(TCPConnection tcpConnection);
    void onReceiveString(TCPConnection tcpConnection, String value);//получили строку
    void onDisconnect (TCPConnection tcpConnection);//разрыв соединения
    void onException(TCPConnection tcpConnection, Exception e);//что-то пошло не так
}
