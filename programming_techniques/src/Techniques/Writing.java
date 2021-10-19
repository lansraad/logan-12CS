package Techniques;

import java.io.*;

public class Writing {
    public static void main(String[] args) {
        try {
            FileWriter file = new FileWriter("resources/stats.txt");
            BufferedWriter buff = new BufferedWriter(file);
            buff.write("People who understand java: 7\n");
            buff.write("People who kinda get it: 11\n");
            buff.write("People who don't get it at all: 4\n");
            buff.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
