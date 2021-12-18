package com.pb.nikolaenko.hw11;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Scanner;

public class View {
    public static void main(String[] args) throws JsonProcessingException {
    PhoneBook phoneBook = new PhoneBook ( );
    Scanner choice = new Scanner (System.in);
    int input;
    int count = 0;

    while (count == 0) {
        System.out.println ("\n------МЕНЮ УПРАВЛЕНИЯ------ \n 1 - добавить контакт;" +
                "\n 2 - удалить контакт ;\n 3 - поиск контакта; " + "\n 4 - вывести на экран все контакты;"
                + "\n 5 - редактировать контакт;" + "\n 6 - запись в файл всех данных;"
                + "\n 7 - загрузка из файла всех данных;" + "\n 8 - выход");
        System.out.println ("~~~~~" + " Выберите действие (введите цифру)" + "~~~~");
        input = choice.nextInt ( );

        switch (input) {
            case 1:
                phoneBook.add();
                break;
            case 2:
                phoneBook.remove();
                break;
            case 3:
                phoneBook.search();
                break;
            case 4:
                phoneBook.show();
                break;
            case 5:
                phoneBook.edit();
                break;
            case 6:
                phoneBook.createFile();
                break;
            case 7:
                phoneBook.donwloadFile();
                break;
            case 8:
                System.out.println ("Выход!");
                count++;
                break;

        }

    }
}
}
