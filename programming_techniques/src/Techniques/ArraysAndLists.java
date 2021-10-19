package Techniques;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysAndLists {
    public static void main(String[] args) {
        // Array
        String[] shopping_list = {"Fruit", "Veg", "Frozen Food", "Drinks", "Juice", "Bread"};
        System.out.println(Arrays.toString(shopping_list));
        shopping_list[5] = "Jamie";
        System.out.println(Arrays.toString(shopping_list));

        int[] numbers = new int[10];
        for (int i=0; i<=9; i++) {
            numbers[i] = i + 1;
        }

        System.out.println(Arrays.toString(numbers));

        // List
        ArrayList<String> names = new ArrayList<>();
        names.add("Jamie");
        names.add("Precious");
        names.add("Mr. Lund");

        System.out.println(names.get(0));
        names.remove(1);

        System.out.println(Arrays.toString(names.toArray()));

    }
}
