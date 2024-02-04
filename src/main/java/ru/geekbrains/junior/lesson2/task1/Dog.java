package ru.geekbrains.junior.lesson2.task1;


public class Dog extends Animal {
    private String breed;
    private void makeSound() {
        System.out.print("Гав-гав-гав!");
    }
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

}
