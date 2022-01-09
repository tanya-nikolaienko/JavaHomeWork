package com.pb.nikolaenko.hw14;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

class ClientWork {

    // Объявляем рабочие переменные
    private Socket socket;
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток чтения в сокет
    private BufferedReader inputUser; // поток чтения с консоли
    private String addr; // ip адрес клиента
    private int port; // порт соединения
    private String clientName; // имя клиента
    private Date dateTime;
    private String stringTime;
    private SimpleDateFormat time;

    // Обмен сообщениями клиент-сервер
    public ClientWork(String addr, int port) {
        this.addr = addr;
        this.port = port;
        try {
            this.socket = new Socket(addr, port);
        } catch (IOException e) {
            System.err.println("Ошибка подключения");
        }
        try {
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.inputClientName();
            new ReadMsg().start();
            new WriteMsg().start();
        } catch (IOException e) {
            ClientWork.this.clientShutdown();
        }
    }

    // Ввод имени пользователя (клиента)
    private void inputClientName() {
        System.out.print("Введите свое имя: ");
        try {
            clientName = inputUser.readLine();
            out.write("Начинаем общение, " + clientName + "! Для завершения достаточно ввести \"end\".\n");
            out.flush();
        } catch (IOException ignored) {
        }

    }

    // Корректное завершение подключения
    private void clientShutdown() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {}
    }

    // Получение сообщений от сервера
    private class ReadMsg extends Thread {
        @Override
        public void run() {
            String str;
            try {
                while (true) {
                    str = in.readLine();
                    if (str.equals("end")) {
                        ClientWork.this.clientShutdown();
                        break;
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
                ClientWork.this.clientShutdown();
            }
        }
    }

    // Передача сообщений на сервер
    public class WriteMsg extends Thread {
        @Override
        public void run() {
            while (true) {
                String userMessage;
                try {
                    dateTime = new Date();
                    time = new SimpleDateFormat("HH:mm:ss");
                    stringTime = time.format(dateTime);
                    userMessage = inputUser.readLine();
                    if (userMessage.equals("end")) {
                        out.write("end" + "\n");
                        ClientWork.this.clientShutdown();
                        break;
                    } else {
                        out.write("(" + stringTime + ") " + clientName + ": " + userMessage + "\n");
                    }
                    out.flush();
                } catch (IOException e) {
                    ClientWork.this.clientShutdown();
                }
            }
        }
    }
}