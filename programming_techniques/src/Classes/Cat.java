package Classes;

public class Cat extends Animal {
    private String name;

    public Cat(String name) {
        super(name, 4, "Meow", true, "Cat");
        this.name = name;
    }
    
    public void move() {
        System.out.println(name + " moves 2 spaces");
    }
}
