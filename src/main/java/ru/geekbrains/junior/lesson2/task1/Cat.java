package ru.geekbrains.junior.lesson2.task1;

public class Cat extends Animal {
    private boolean likeToSleep;
    private void jump() {
        System.out.println("Прыг!");
    }

    public Cat(String name, int age, boolean likeToSleep){
        super(name, age);
        this.likeToSleep = likeToSleep;
    }
}

