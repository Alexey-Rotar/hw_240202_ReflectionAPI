package ru.geekbrains.junior.lesson2.task1;

public class Cat extends Animal {
    private boolean canSwim;
    private void jump() {
        System.out.println("Прыг!");
    }

    public Cat(String name, int age, boolean canSwim){
        super(name, age);
        this.canSwim = canSwim;
    }
}
