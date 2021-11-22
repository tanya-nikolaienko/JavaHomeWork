package com.pb.nikolaenko.hw9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class FileNumbers {

    static void createNumbersFile() throws IOException {

        int[][] a = new int[10][10];
          Random rnd = new Random();

        Path path = Paths.get("E:\\numbers.txt");
        System.out.println("1.1 Создание массива, демонстрация содержимого первого файла:");
        System.out.println();
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = rnd.nextInt(99) + 1;
            }
        }

        for (int i=0;i < a.length;i++,System.out.println()) {
            for (int j=0;j < a[i].length;j++) {
                System.out.print(a[i][j]+" ");
                writer.write(String.valueOf(a[i][j] +" "));
            }
                writer.newLine();

        }

      } catch (Exception ex){
     System.out.println("Error with file write: " + ex);
 }
    }



    static void createOddNumbersFile(){
        System.out.println();
        System.out.println("2.1. Результат чтения  первого файла:");
        Path path = Paths.get("E:\\numbers.txt");
        Path path1 = Paths.get("E:\\odd-numbers.txt");


        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(path)));
             BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(path1)))) {

            String s;

            while ((s = br.readLine()) != null) {
                bw.write(s);
                bw.newLine();

                String[] numbersString = s.split(" ");
                int[] numbers = new int[99];
                int counter = 0;  // счетчик индекса ячейки
                for(String number: numbersString){   //циклом переводим стринг в инт
                    numbers[counter++] = Integer.parseInt(number); // получаем из строки int

                    if (numbers[counter] %2 !=1){
                        numbers[counter] = 0;
}
                }

                System.out.println("second massive"+Arrays.toString(numbers));

        }




        }
         catch (NoSuchElementException | IOException ex) {
            System.out.println("Файл прочитан.");
        } //catch (IOException ex) {
            //ex.printStackTrace();
        }






    public static void main (String[] args) throws IOException {
        createNumbersFile();
        createOddNumbersFile();



    }


}
