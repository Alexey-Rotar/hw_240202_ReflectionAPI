package ru.geekbrains.junior.lesson2.task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Program {

    /**
     Создайте абстрактный класс "Animal" с полями "name" и "age".
     Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
     Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
     Выведите на экран информацию о каждом объекте.
     Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
     */
    
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        List<Animal> animalsList = new ArrayList<>();
        animalsList.add(new Cat("Васька", 11, false));
        animalsList.add(new Dog("Тмин", 5, "бульдог"));
        animalsList.add(new Dog("Лада", 7, "беспородный"));
        animalsList.add(new Cat("Люся", 2, true));

        Field[] fields;
        Method method;
        for (Animal animal: animalsList) {
            fields = animal.getClass().getSuperclass().getDeclaredFields();
            for (Field field: fields) {
                field.setAccessible(true);
                System.out.print(field.getName() + ": " + field.get(animal) + "; ");
            }
            fields = animal.getClass().getDeclaredFields();
            for (Field field: fields) {
                field.setAccessible(true);
                System.out.print(field.getName() + ": " + field.get(animal) + "; ");
            }
            try {
                method = animal.getClass().getDeclaredMethod("makeSound");
                method.setAccessible(true);
                method.invoke(animal);
            } catch (NoSuchMethodException ignored) {}
            System.out.println();
        }
    }

}
