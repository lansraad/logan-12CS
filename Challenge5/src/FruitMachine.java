import java.util.*;

public class FruitMachine {
    public static void main(String[] args) {
        float balance = 1;
        Scanner scan = new Scanner(System.in);

        while (balance >= 0.20f) {
            System.out.printf("\n[£%.2f] Would you like to spin? (Y/n) ", balance);
            if (scan.nextLine().toUpperCase().equals("Y")) {
                balance = spin(balance);
            } else {
                System.out.println("Change your mind :)");
            }
        }
        System.out.println("Yikes, you're out of cash!");
    }

    public static float spin(float balance) {
        float delta = -0.20f;
        Random random = new Random();
        String[] symbols = {"🍒 Cherry", "🔔 Bell", "🍋 Lemon", "🍊 Orange", "⭐ Star", "💀 Skull"};

        ArrayList<String> spin = new ArrayList<>();
        for (int i=0; i<3; i++) {
            spin.add(symbols[random.nextInt(symbols.length)]);
        }

        System.out.println("-£0.20\n");
        System.out.println(Arrays.toString(spin.toArray()));
        System.out.println();

        for (String symbol : symbols) {
            if (Collections.frequency(spin, symbol) == 2) {
                if (symbol.equals("💀 Skull")) {
                    System.out.println("You got two skulls! (-£1.00)");
                    delta -= 1;
                } else {
                    System.out.println("You got two duplicates! (+£0.50)");
                    delta += 0.50f;
                }
            } else if (Collections.frequency(spin, symbol) == 3) {
                if (symbol.equals("💀 Skull")) {
                    System.out.println("You got three skulls! 💀\nRIP");
                    delta = 0;
                } else if (symbol.equals("🔔 Bell")) {
                    System.out.println("You got three Bells! (+£5.00)");
                    delta += 5;
                } else {
                    System.out.println("You got three duplicates! (+£1.00)");
                    delta += 1;
                }
            }
        }
        if (delta == -0.20f) System.out.println("Better luck next time!");
        return balance += delta;
    }
}
