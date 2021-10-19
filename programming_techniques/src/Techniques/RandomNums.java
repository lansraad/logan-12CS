package Techniques;

import java.util.Random;

public class RandomNums {
    public static void main(String[] args) {
        Random die = new Random();

        for (int i=0; i<10; i++) {
            System.out.println(die.nextInt(6)+1);
        }
    }
}
