package Techniques;

import java.io.*;
import java.util.Scanner;

public class Reading {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("resources/data.txt");
            BufferedReader buff = new BufferedReader(file);
            Scanner scan = new Scanner(buff);
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
