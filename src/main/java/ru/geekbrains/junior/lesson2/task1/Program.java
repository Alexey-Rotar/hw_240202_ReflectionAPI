package ru.geekbrains.junior.lesson2.task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        List<Animal> animalsList = new ArrayList<>();
        animalsList.add(new Cat("Васька", 11, false));
        animalsList.add(new Dog("Тмин", 5, "бульдог"));
        animalsList.add(new Dog("Лада", 7, "беспородный"));
        animalsList.add(new Cat("Люся", 2, true));
        animalsList.add(new Cat("Пушок", 1, false));
        animalsList.add(new Dog("Рой", 4, "овчарка"));

        Field[] fields;
        Method[] methods;

        for (Animal animal: animalsList) {
            fields = animal.getClass().getSuperclass().getDeclaredFields();
            for (Field field: fields) {
                field.setAccessible(true);
                System.out.printf("%s: %s; ", field.getName(), field.get(animal));
            }
            fields = animal.getClass().getDeclaredFields();
            for (Field field: fields) {
                field.setAccessible(true);
                System.out.printf("%s: %s; ", field.getName(), field.get(animal));
            }
            methods = animal.getClass().getDeclaredMethods();
            for (Method method: methods) {
                if (method.getName().equals("makeSound")) {
                    method.setAccessible(true);
                    method.invoke(animal);
                }
            }
            System.out.println();
        }
    }

}
