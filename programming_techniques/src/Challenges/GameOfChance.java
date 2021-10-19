package Challenges;

/* Task

A user can bet on any number from 0 to 30. If it’s an even number they 2x their money back. If it’s a multiple of 10 they get 3x their money back. If it’s a prime number they get 5x their money back. If the number is below 5 they get a 2x bonus.
Create a program that allows the user to guess a number. A random number is generated. If the guess == the random number then the user wins and gets a pay-out. Combinations of the win scenarios should be catered for. e.g. 20 wins 2 x 3 bonus = 6x their money.
For the base task the result can be calculated as above and just show the multiple bonus that they have won
Extension
1. Develop your program to allow a user to enter the amount they want to place for that bet, and work out the resulting pay-out
2. Develop your program to store the user’s current balance and stop them from betting if they have no money left
3. Develop your program to finally incorporate validation so that they cannot enter into a negative about of cash ever, and that a bet should be between 1 and 10 units of currency
4. Develop your program to allow multiple bets on different number
 */

import java.util.Scanner;

public class GameOfChance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (1>0) {
            System.out.print("Enter your bet: ");
            int bet = scan.nextInt();
        }
    }
}
