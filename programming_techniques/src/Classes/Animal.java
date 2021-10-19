package Classes;

// Private identifiers used for Encapsulation
public class Animal {
    private String name;
    private int number_of_legs;
    private String sound;
    private boolean has_tail;
    private String type_of_animal;

    // Constructor
    public Animal(String name, int number_of_legs, String sound, boolean has_tail, String type_of_animal) {
        this.name = name;
        this.number_of_legs = number_of_legs;
        this.sound = sound;
        this.has_tail = has_tail;
        this.type_of_animal = type_of_animal;
    }

    // Behaviours
    public void speak() {
        System.out.println(name + " says: " + sound);
    }

    public void move() {
        System.out.println(name + " moves one space");
    }
}
