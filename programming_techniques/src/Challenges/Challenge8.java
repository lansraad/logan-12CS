/*
    Arithmetic test
    A primary school teacher wants a computer program to test the basic arithmetic skills of her students. Generate random questions (2 numbers only) consisting of addition,
    subtraction, multiplication and division.
    The system should ask the student’s name and then ask ten questions. The program should feed back if the answers are correct or not, and then generate a final score at
    the end.

    Extensions:
    1. Extend your program so that it stores the results somewhere. The teacher has three classes, so you need to enable the program to distinguish between them.
    2. The teacher wants to be able to log student performance in these tests. The teacher would like the program to store the last three scores for each student and to be
    able to output the results in alphabetical order with the student’s highest score first out of the three.
*/

package Challenges;

import java.util.Scanner;
import java.util.Random;

public class Challenge8 {
    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            Random type = new Random();
            String question = get_question(type.nextInt(3));

            System.out.printf("%d) %s = ", i+1, question);
            Scanner scan = new Scanner(System.in);
            float user_answer = scan.nextFloat();

        }
    }
    static String get_question(int type) {
        int num1 = get_num();
        int num2 = get_num();

        switch (type) {
            case 0: return num1 + " + " + num2;
            case 1: return num1 + " - " + num2;
            case 2: return num1 + " x " + num2;
            case 3: return num1 + " / " + num2;
            default: return "Error";
        }
    }

    static int get_num() {
        Random rand = new Random();
        return rand.nextInt(99);
    }
}


