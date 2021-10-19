package Techniques;

public class Iteration {
    public static void main(String[] args) {
        String[] items = {"Apple", "Bacon", "Bread", "Potatoes"};

        for (int i=0; i < 5; i++) {
            System.out.printf("Test (%s)\n", i);
        }

        for (String i : items) {
            System.out.println(i);
        }

        int iter = 0;
        while (iter < 5) {
            System.out.printf("While loop (%d)\n", iter);
            iter++;
        }

        int count = 10;
        do {
            System.out.printf("Weird while loop (%d)\n", count);
            count--;
        } while (count > 0);
    }
}
