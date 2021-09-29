/*
 * Arithmetic test
 * A primary school teacher wants a computer program to test the basic arithmetic skills of her students. Generate random questions (2 numbers only) consisting of addition,
 * subtraction, multiplication and division.
 * The system should ask the student’s name and then ask ten questions. The program should feed back if the answers are correct or not, and then generate a final score at
 * the end.

 * Extensions:
 * 1. Extend your program so that it stores the results somewhere. The teacher has three classes, so you need to enable the program to distinguish between them.
 * 2. The teacher wants to be able to log student performance in these tests. The teacher would like the program to store the last three scores for each student and to be
 * able to output the results in alphabetical order with the student’s highest score first out of the three.
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Random;
import java.util.Properties;

public class ArithmeticChallenge {

    private static int number_of_questions = 10;
    //private static int number_of_classes = 3;       // TODO extension 1

    private static final String[] positive_responses = {
            "\uD83C\uDF89 Well done!",
            "\uD83C\uDF89 Smashing work!",
            "\uD83C\uDF89 You're cool!"
    };

    private static final String[] negative_responses = {
            "❌ Better luck next time..",
            "❌ So close..",
            "❌ THINK AGAIN.. (╯°□°)╯︵ ┻━┻ "
    };

    public static void main(String[] args) {
        Random random = new Random();
        int score = 0;

        parse_properties("resources/config.properties");    // Parse props from config.properties

        String name = get_user_info();

        System.out.printf("Hi %s, Let's do some math!\n(%d questions)\n", name, number_of_questions);

        for (int i = 0; i < number_of_questions; i++) {
            String[] question = create_question(random.nextInt(4));  // Get a question with a random operator

            System.out.printf("\n%d) %s = ", i + 1, question[0]);       // Output the question
            float response = get_player_answer();                       // Get player's answer

            // Check whether the player's answer is correct and give them a random positive / negative response
            if (response == Float.parseFloat(question[1])) {
                System.out.println(positive_responses[random.nextInt(positive_responses.length)]);

                // Update the player's score
                score++;
            } else {
                System.out.println(negative_responses[random.nextInt(negative_responses.length)]);
                System.out.printf("..The correct answer was %s.\n", question[1]);
            }
        }

        // Output the player's final score
        System.out.printf("\n❗ You scored %d out of %d! (%d%%)", score, number_of_questions, score/number_of_questions);
    }

    static String[] create_question(int question_type) {
        Random rand = new Random();
        int num1 = rand.nextInt(50);
        int num2 = rand.nextInt(50) + 1; // Prevent divide by zero errors by ensuring the second number is >0.

        return switch (question_type) {  // Generate a question and answer
            // Return String array containing a question and answer
            case 0 -> new String[]{num1 + " + " + num2, String.valueOf(num1 + num2)};
            case 1 -> new String[]{num1 + " - " + num2, String.valueOf(num1 - num2)};
            case 2 -> new String[]{num1 + " x " + num2, String.valueOf(num1 * num2)};
            case 3 -> new String[]{num1 + " / " + num2, String.valueOf(num1 / num2)};
            default -> throw new IllegalArgumentException("Type must be int from 0-3");
        };
    }

    static String get_user_info() {                         // Greet the player
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scan.nextLine();
        return name.substring(0, 1).toUpperCase() + name.substring(1);  // Ensure the first character is capitalized
    }

    static float get_player_answer() {
        Scanner scan = new Scanner(System.in);

        while (true) {  // Loop until a valid input is given
            try {
                return scan.nextFloat();          // Input the player's response
            } catch (Exception e) {
                System.out.print("Invalid input, try again: ");
                scan.next();
            }
        }
    }

    public static void parse_properties(String path) {      // Parse config.properties
        try {
            Properties prop = new Properties();
            InputStream input = new FileInputStream(path);
            prop.load(input);

            number_of_questions = Integer.parseInt(prop.getProperty("number_of_questions"));
            //number_of_classes = Integer.parseInt(prop.getProperty("number_of_classes")); TODO

        } catch (IOException e) {
            System.out.println("⚠ Failed to load \""+ path + "\", continuing with default parameters.");
            //System.out.println(e.getMessage());
        }
    }
}
