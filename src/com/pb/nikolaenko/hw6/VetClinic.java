package com.pb.nikolaenko.hw6;

import java.lang.reflect.Constructor;

public class VetClinic {
    public static void main(String[] args) throws Exception {

        Dog dog = new Dog();
        Cat cat = new Cat();
        Horse horse = new Horse();


        dog.setVariable("Ризеншнауцер");
        dog.setPet("Собака");
        dog.setName("Аврора");

        cat.setVariable("Абиссинский золотой");
        cat.setPet("Кошка");
        cat.setName("Гваделупе");

        horse.setVariable("Cartier Racing Award");
        horse.setPet("Лошадь");
        horse.setName("Эль Корозон");


        Animal[] animals = new Animal[]{dog, cat, horse};
        for (Animal c : animals) {

            c.define();
            c.makeNoise();
            c.eat();
            c.sleep();
        }
        System.out.println();
        System.out.println("dog equals cat: " + dog.equals(cat));
        System.out.println();
        System.out.println("Нashcode dog: " + dog.hashCode());
        System.out.println("Нashcode cat: " + cat.hashCode());
        System.out.println("Нashcode horse: " + horse.hashCode());
        System.out.println();
        System.out.println(dog.toString());
        System.out.println(cat.toString());
        System.out.println(horse.toString());
        System.out.println();
        //refleksia
        Class vetClazz = Class.forName("com.pb.nikolaenko.hw6.Veterinarian");
        Constructor constr = vetClazz.getConstructor(new Class[]{});
        Object obj = constr.newInstance();
        if (obj instanceof Veterinarian) {
            for (Animal animal : animals) {
                ((Veterinarian) obj).treatAnimal(animal);
            }
        }
    }
}