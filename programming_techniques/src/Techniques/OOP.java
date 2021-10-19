package Techniques;

import Classes.*;

public class OOP {
    public static void main(String[] args) {
        Animal garfield = new Animal(
                "garfield",
                4,
                "I love Lasagna",
                true,
                "Cat"
        );
        garfield.speak();

        Animal micky = new Animal(
                "Micky Mouse",
                2,
                "hahahahaha",
                true,
                "Mouse"
        );
        micky.speak();

        Cat whiskpers = new Cat("Whiskers");
        whiskpers.speak();
        garfield.move();
        micky.move();
        whiskpers.move();
    }
}
