package com.pb.nikolaenko.hw11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;


public class PhoneBook {
    List<Subscriber> subscribers = new ArrayList<>( );
    LocalDateTime localDateTime = LocalDateTime.now ( );
    Scanner scanner = new Scanner (System.in);

    public void add() {
        System.out.println("Введите данные контакта");
        System.out.print("ФИО (через пробел):");
        String name = scanner.next()+scanner.nextLine();;
        System.out.print("Дата рождения:");
        String birthdate = scanner.next()+scanner.nextLine();
        System.out.print("Tелефон (если несколько, то ввод через пробел):");
        String phone = scanner.next();
        System.out.print("Адрес:");
        String address = scanner.next();
        subscribers.add (new Subscriber (name, birthdate, phone, address, localDateTime));
        subscribers.add (new Subscriber ("Денис", "01.06.1978", "0567894512", "Днепр", localDateTime));
        subscribers.add(new Subscriber("Таня","02.02.1986","0739876532", "Москва", localDateTime));
        System.out.println("Контакт успешно добавлен");
    }

    public void remove() {
        if (!subscribers.isEmpty ( )) {
            System.out.println ("Введите номер контакта для удаления: ");
            String number = scanner.next ( );
            boolean flag = subscribers.removeIf (subscriber -> Objects.equals (subscriber.getPhone ( ), number));

            if (flag) {
                System.out.println ("Контакт удален");
            } else System.out.println ("Номер контакта некорректен,повторите попытку");
        } else System.out.println ("Контакт не найден, проверьте правильность введенного номера");
    }


    public void search() {
        if (!subscribers.isEmpty ( )) {
            System.out.println ("Введите данные контакта для поиска (ФИО или номер телефона):");
            String line = scanner.next()+scanner.nextLine();
            for (Subscriber subscriber : subscribers) {
                if (subscriber.getPhone().equals(line) || subscriber.getName().equals(line)) {
                    System.out.println (subscriber + "\n");
                    break;
                } else {
                    System.out.println ("Данные введены некорректно либо контакта не существует,повторите попытку");
                    break;
                }
            }
        } else System.out.println ("Контакты не найдены");

    }


    public void show() {
        if (!subscribers.isEmpty ( )) {
            System.out.println ("Выберите признак сортировки (1 - по адресу; 2 - по номеру телефона;):");
            int choice = scanner.nextInt ( );
            if (choice == 1) {
                Comparator<Subscriber> comparator = Comparator.comparing (Subscriber::getAddress);
                subscribers.sort (comparator);
                for (Subscriber subscriber : subscribers) {
                    System.out.println (subscriber);
                }
                System.out.println ( );

            }
            if (choice == 2) {
                Comparator <Subscriber> comparator = Comparator.comparing (Subscriber::getPhone);
                subscribers.sort (comparator);
                for (Subscriber subscriber : subscribers) {
                    System.out.println (subscriber);
                }
                System.out.println ( );
            }
        } else System.out.println ("Контакты не найдены,добавьте новый контакт и повторите операцию");
    }


    public void edit() {
        if (!subscribers.isEmpty ( )) {
            System.out.println ("Введите ФИО контакта для редактирования:");
            String name = scanner.next ( );
            for (Subscriber subscriber : subscribers) {
                if (subscriber == null) {
                    System.out.println ("Контакт не существует,повторите попытку!");
                    break;
                }
                if (subscriber.getName ( ).equals (name)) {
                    System.out.println ("Выберите атрибут,который хотите изменить:\n 1 - ФИО;" + "\n 2 - Дата рождения;" + "\n 3 - Телефон;" + "\n 4 - Адрес;");
                    int choice = scanner.nextInt ( );
                    switch (choice) {
                        case 1:
                            System.out.println ("Введите новое ФИО: ");
                            String newName = scanner.next ( );
                            subscriber.setName (newName);
                            subscriber.setDatetime (localDateTime);
                            System.out.println ("ФИО изменено. Новое ФИО: " + subscriber.getName ( ));
                            break;
                        case 2:
                            System.out.println ("Введите новую дату рождения: ");
                            String newBirthdate = scanner.next ( );
                            subscriber.setBirthdate (newBirthdate);
                            subscriber.setDatetime (localDateTime);
                            System.out.println ("Дата рождения  изменена");
                            break;
                        case 3:
                            System.out.println ("Введите новый номер телефона(если нужно добавить несколько номеров,ввод через пробел):");
                            String newPhone = scanner.next ( );
                            subscriber.setPhone (newPhone);
                            subscriber.setDatetime (localDateTime);
                            System.out.println ("Номер телефона изменен");
                            break;
                        case 4:
                            System.out.println ("Введите новый адрес: ");
                            String newAddress = scanner.next ( );
                            subscriber.setAddress (newAddress);
                            subscriber.setDatetime (localDateTime);
                            System.out.println ("Адрес изменен");

                    }
                } else System.out.println ("Данные введены некорректно,повторите попытку!");
                break;
            }
        } else System.out.println ("Контакт не найден,добавьте новый контакт и повторите операцию");
    }

    public void createFile() throws JsonProcessingException {
        if (!subscribers.isEmpty ( )) {
            final String filePath = "C:\\Users\\User\\Desktop\\PhoneBook.json";
            ObjectMapper objectMapper = new ObjectMapper ( );
            objectMapper.enable (SerializationFeature.INDENT_OUTPUT);
            SimpleModule module = new SimpleModule ( );
            module.addSerializer (LocalDateTime.class, new LocalDateTimeSerializer ( ));
            module.addDeserializer (LocalDateTime.class, new LocalDateTimeDeserializer ( ));
            objectMapper.registerModule (module);
            String json = objectMapper.writeValueAsString (subscribers);
            try (BufferedWriter writer = Files.newBufferedWriter (Paths.get (filePath))) {
                writer.write (json);
                System.out.println ("Данные записаны в файл");
            } catch (IOException e) {
                e.printStackTrace ( );
            }
        } else System.out.println ("Контакт не найден,добавьте новый контакт и повторите операцию");
    }

    public void donwloadFile() {
        if (!subscribers.isEmpty ( )) {
            System.out.println ("\n <<<<< ЧТЕНИЕ ФАЙЛА......>>>>>");
            final String filePath = "C:\\Users\\User\\Desktop\\PhoneBook.json";
            String lines;
            try (BufferedReader reader = Files.newBufferedReader (Paths.get (filePath))) {
                while ((lines = reader.readLine ( )) != null) {
                    System.out.println (lines);
                }
                System.out.println ("Операция выполнена - данные загружены из файла" );
            } catch (IOException e) {
                e.printStackTrace ( );
            }


        } else System.out.println ("Контакт не найден,добавьте новый контакт и повторите операцию");
    }
}
