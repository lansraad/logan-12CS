package Challenges.RPG;

public class Character {
    private String name;
    private final String type;
    private int health = 100;
    private int power;
    private int special_attack_power;
    private int speed;

    public Character(String name, String type, int power, int special_attack_power, int speed) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.special_attack_power = special_attack_power;
        this.speed = speed;
    }

    public void display_stats() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Health: " + health);
        System.out.println("Power: " + power);
        System.out.println("Special Attack Power: " + special_attack_power);

    }

}
