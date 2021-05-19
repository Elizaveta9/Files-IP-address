package com.company;

import java.io.*;
import java.util.Scanner;

public class regex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String accepted = "Адресс принят.";
        String decline = "Адресс введён некорректно. Повторите попытку.";
        boolean isCorrect = false;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C://Users//User//IdeaProjects//Study//hist.txt"));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bwLog = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader brFile = new BufferedReader(new FileReader("C://Users//User//IdeaProjects//Study//hist.txt"))) {
            while (!isCorrect) {
                System.out.print("Введите ip-адресс (getLog для получение истории)>> ");
                String address = scan.nextLine();
                if (address.equals("getLog")) {
                    bw.flush();
                    File log = new File("C://Users//User//IdeaProjects//Study//hist.txt");
                    System.out.println("Ваша история ввода: ");
                    String s = brFile.readLine();
                    while (s != null) {
                        System.out.println(s);
                        s = brFile.readLine();
                    }
                    break;
                }
                bw.write(address + "\n");
                isCorrect = address.matches("(([01]?(\\d){1,2})|(2[0-4]\\d)|(25[0-5]))(\\.(([01]?(\\d){1,2})|(2[0-4]\\d)|(25[0-5]))){3}");
                bw.write(isCorrect ? accepted + "\n" : decline + "\n");
                System.out.println(isCorrect ? accepted : decline);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
