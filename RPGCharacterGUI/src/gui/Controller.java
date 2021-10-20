package gui;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import gui.Characters.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import gui.Characters.Character;

import java.util.Random;

public class Controller {
    public Character[] characters = new Character[10];
    public Character currentCharacter;
    public int currentSlot;
    
    // Main controls

    // Character grid
    @FXML
    private GridPane slot_table;
    public ImageView i1, i2, i3, i4, i5, i6, i7, i8, i9, i10;

    // Character control
    @FXML
    private Label nameText;
    @FXML
    private Slider healthSlider;
    @FXML
    private TextField healthInput;
    @FXML
    private Slider powerSlider;
    @FXML
    private TextField powerInput;
    @FXML
    private Slider specialPowerSlider;
    @FXML
    private TextField specialPowerInput;
    @FXML
    private Slider speedSlider;
    @FXML
    private TextField speedInput;
    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private void initialize() {
        typeComboBox.setItems(FXCollections.observableArrayList("Barbarian", "Elf", "Knight", "Dragon", "Wizard"));

        for (int i=0; i<10; i++) {
            characters[i] = randomCharacter();
        }
    }

    public void displaySlot(int slot, Character character) {
        Label name = (Label) slot_table.lookup("#n"+slot);
        Label type = (Label) slot_table.lookup("#c"+slot);
        Label health = (Label) slot_table.lookup("#h"+slot);
        Label power = (Label) slot_table.lookup("#a"+slot);
        Label specialPower = (Label) slot_table.lookup("#sa"+slot);
        Label speed = (Label) slot_table.lookup("#s"+slot);

        name.setText(character.getName());
        type.setText(character.getType());
        health.setText(String.valueOf(character.getHealth()));
        power.setText(String.valueOf(character.getPower()));
        specialPower.setText(String.valueOf(character.getSpecialPower()));
        speed.setText(String.valueOf(character.getSpeed()));

        ImageView image;
        switch (slot) {
            case 1 -> image = i1;
            case 2 -> image = i2;
            case 3 -> image = i3;
            case 4 -> image = i4;
            case 5 -> image = i5;
            case 6 -> image = i6;
            case 7 -> image = i7;
            case 8 -> image = i8;
            case 9 -> image = i9;
            case 10 -> image = i10;
            default -> throw new IllegalStateException("Unexpected value: " + slot);
        }
        image.setImage(new Image("file:src/gui/img/"+ character.getType().toLowerCase() +".png"));
    }

    public void displayCharacterEditor(int slot) {
        currentCharacter = characters[slot-1];
        currentSlot = slot;
        String name = characters[slot-1].getName();
        String type = characters[slot-1].getType();
        int power = characters[slot-1].getPower();
        int health = characters[slot-1].getHealth();
        int specialPower = characters[slot-1].getSpecialPower();
        int speed = characters[slot-1].getSpeed();

        nameText.setText(name);
        typeComboBox.setValue(type);

        healthSlider.setValue(health);
        healthInput.setText(String.valueOf(health));

        powerSlider.setValue(power);
        powerInput.setText(String.valueOf(power));

        specialPowerSlider.setValue(specialPower);
        specialPowerInput.setText(String.valueOf(specialPower));

        speedSlider.setValue(speed);
        speedInput.setText(String.valueOf(speed));
    }

    public static Character randomCharacter() {
        Random rand = new Random();
        String[] classes = {"Barbarian", "Elf", "Wizard", "Dragon", "Knight"};

        return create_character(classes[rand.nextInt(classes.length)], create_name(3)); // length = number of syllables
    }

    public static Character create_character(String type, String name) {
        // Create a new class corresponding to the type of the character.
        return switch (type) {
            case "Barbarian" -> new Barbarian(name);
            case "Elf" -> new Elf(name);
            case "Wizard" -> new Wizard(name);
            case "Dragon" -> new Dragon(name);
            case "Knight" -> new Knight(name);
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
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

    public void setHealth(int health) {
        currentCharacter.setHealth(health);
        displaySlot(currentSlot, currentCharacter);
    }

    public void setType(String type) {
        currentCharacter.setType(type);
        displaySlot(currentSlot, currentCharacter);
    }

    public void setPower(int power) {
        currentCharacter.setPower(power);
        displaySlot(currentSlot, currentCharacter);
    }

    public void setSpecialPower(int specialPower) {
        currentCharacter.setSpecialPower(specialPower);
        displaySlot(currentSlot, currentCharacter);
    }

    public void setSpeed(int speed) {
        currentCharacter.setSpeed(speed);
        displaySlot(currentSlot, currentCharacter);
    }

    public void setName(String name) {
        displaySlot(currentSlot, currentCharacter);
    }

    public void on_slot_1_selected(ActionEvent actionEvent) {
        displayCharacterEditor(1);
    }

    public void on_slot_2_selected(ActionEvent actionEvent) {
        displayCharacterEditor(2);
    }

    public void on_slot_3_selected(ActionEvent actionEvent) {
        displayCharacterEditor(3);
    }

    public void on_slot_4_selected(ActionEvent actionEvent) {
        displayCharacterEditor(4);
    }

    public void on_slot_5_selected(ActionEvent actionEvent) {
        displayCharacterEditor(5);
    }

    public void on_slot_6_selected(ActionEvent actionEvent) {
        displayCharacterEditor(6);
    }

    public void on_slot_7_selected(ActionEvent actionEvent) {
        displayCharacterEditor(7);
    }

    public void on_slot_8_selected(ActionEvent actionEvent) {
        displayCharacterEditor(8);
    }

    public void on_slot_9_selected(ActionEvent actionEvent) {
        displayCharacterEditor(9);
    }

    public void on_slot_10_selected() {
        displayCharacterEditor(10);
    }

    public void onHealthChange() {
        int health = (int) healthSlider.getValue();
        healthInput.setText(String.valueOf(health));
        setHealth(health);
    }

    public void onHealthEntered() {
        int health = Integer.parseInt(healthInput.getText());
        healthSlider.setValue(health);
        setHealth(health);
    }

    public void onPowerChanged() {
        int power = (int) powerSlider.getValue();
        powerInput.setText(String.valueOf(power));
        setPower(power);
    }

    public void onPowerEntered() {
        int power = Integer.parseInt(powerInput.getText());
        powerSlider.setValue(power);
        setPower(power);
    }

    public void onSpecialPowerChanged() {
        int specialPower = (int) specialPowerSlider.getValue();
        specialPowerInput.setText(String.valueOf(specialPower));
        setSpecialPower(specialPower);
    }

    public void onSpecialPowerEntered() {
        int specialPower = Integer.parseInt(specialPowerInput.getText());
        specialPowerSlider.setValue(specialPower);
        setSpecialPower(specialPower);
    }

    public void onSpeedChanged() {
        int speed = (int) speedSlider.getValue();
        speedInput.setText(String.valueOf(speed));
        setSpeed(speed);
    }

    public void onSpeedEntered() {
        int speed = Integer.parseInt(speedInput.getText());
        speedSlider.setValue(speed);
        setSpeed(speed);
    }

    public void resetCharacter() {
        Character character = create_character(currentCharacter.getType(), currentCharacter.getName());
        characters[currentSlot-1] = character;
        displaySlot(currentSlot, character);
        displayCharacterEditor(currentSlot);
    }

    public void randomizeCharacter() {
        Random rand = new Random();
        currentCharacter.setSpeed(rand.nextInt(100));
        currentCharacter.setPower(rand.nextInt(100));
        currentCharacter.setSpecialPower(rand.nextInt(100));
        currentCharacter.setHealth(rand.nextInt(100));
        displaySlot(currentSlot, currentCharacter);
        displayCharacterEditor(currentSlot);
    }

    public void onTypeChange() {
        setType(typeComboBox.getValue());
    }

    public void onRandomizeTeam(MouseEvent mouseEvent) {
        for (int i=0; i<10; i++) {
            characters[i] = randomCharacter();
            displaySlot(i+1, characters[i]);
        }
    }
}
