package Challenges.RPG;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        String[] classes = {"Barbarian", "Elf", "Wizard", "Dragon", "Knight"};

        for (int i = 0; i < 10; i++) {
            Character character = create_character(classes[rand.nextInt(classes.length)], create_name(3)); // length = number of syllables
            character.display_stats();
        }
    }

    public static Character create_character(String class_name, String name) {
        Character character;
        switch (class_name) { // Create a new class corresponding to the "class" of the character.
            case "Barbarian": character = new Barbarian(name); break;
            case "Elf": character = new Elf(name); break;
            case "Wizard": character = new Wizard(name); break;
            case "Dragon": character = new Dragon(name); break;
            case "Knight": character = new Knight(name); break;
            default: throw new IllegalArgumentException("Unknown class name: " + class_name);
        }
        return character;
    }

    public static String create_name(int length) {
        Random rand = new Random();
        String[] syllables = {"en", "da", "kar", "tuk", "el", "de", "fu", "ti", "et"};
        StringBuilder name = new StringBuilder();

        for (int i = 0; i < length; i++) {
            name.append(syllables[rand.nextInt(syllables.length)]);
            if (i < length - 1) name.append("-");
        }
        return name.toString();
    }
}
