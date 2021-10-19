package Techniques;

public class SubPrograms {
    public static void main(String[] args) {
        greeting("Jamie");
        greeting();
        System.out.println("1 + 2 = " + addition(1, 2));
    }

    // Procedure - doesn't return anything
    // Void means no return
    public static void greeting(String name) {
        System.out.println("Welcome " + name);
    }

    // OVERLOAD
    public static void greeting() {
        System.out.println("Welcome, you have no name but are probably Jamie.");
    }

    // Function - doesn't not return something
    public static int addition(int num1, int num2) {
        return num1 + num2;
    }
}
