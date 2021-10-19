package gui.Characters;

public class Character {
    private String name;
    private String type;
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

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    public int getHealth() {
        return health;
    }
    public int getPower() {
        return power;
    }
    public int getSpecialPower() {
        return special_attack_power;
    }
    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setSpecialPower(int special_attack_power) {
        this.special_attack_power = special_attack_power;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
