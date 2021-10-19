package Techniques;

import java.util.Scanner;

public class Casting {
    public static void main(String[] args) {

        // Allows the application to look at things.
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");

        // Scan the next line
        String input = scan.nextLine();

        try {
            int number = Integer.parseInt(input);
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number! - " + input);
        }
    }
}
