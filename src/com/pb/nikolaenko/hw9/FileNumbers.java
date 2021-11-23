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
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = rnd.nextInt(99) + 1;
            }
        }

        for (int i=0;i < a.length;i++,System.out.println()) {
            for (int j=0;j < a[i].length;j++) {
                //System.out.print(a[i][j]+" ");
                writer.write(String.valueOf(a[i][j] +" "));
            }
                writer.newLine();

        }
            System.out.println("1. Файл numbers успешно создан и записан.");
      } catch (Exception ex){
     System.out.println("Error with file write: " + ex);
 }
    }


    static void createOddNumbersFile(){
        Path path = Paths.get("E:\\numbers.txt");
        Path path1 = Paths.get("E:\\odd-numbers.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(path)));
             BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(path1)))) {

            String s;

            while ((s = br.readLine()) != null) {

                String[] numbersString = s.split(" ");
                for (String numStr : numbersString) {
                    int number = Integer.parseInt(numStr);
                    if (number % 2 == 0) {
                        bw.write("0 ");
                    } else {
                        bw.write(numStr + " ");
                    }
                }
                bw.newLine();
            }
            System.out.println("2. Файл numbers успешно считан. Файл odd-numbers записан успешно ");
        }
         catch (NoSuchElementException | IOException ex)
                {
            System.out.println("Error");
        }
     }

    public static void main (String[] args) throws IOException {
        createNumbersFile();
        createOddNumbersFile();
    }
}
