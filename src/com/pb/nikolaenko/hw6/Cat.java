package com.pb.nikolaenko.hw6;

import java.util.Objects;

public class Cat extends Animal{

    private String variable;
    private String name;

    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }

    public String getVariable() {        return variable;    }
    public void setVariable(String variable) {        this.variable = variable;    }



    public Cat(){
        super("Purina", "Гостинная");
    }

    @Override
    public void define(){
        System.out.println();
        System.out.println ( "--- класс Кошка ---");
        System.out.println("Кличка: " + getName() +"; Среда обитания: " + getLocation() + " ; " + "Еда: "+ getFood());
        System.out.println("Окрас кошки:" + variable);
    }

    @Override
    public void makeNoise(){
        System.out.print("Родительский makeNoise для Cat:  " );
        super.makeNoise();
        System.out.print("Переопределенный makeNoise для Cat:  " );
        System.out.println (getPet() + " точит коготки");
    }

    @Override
    public void eat(){
        System.out.print("Родительский eat для Cat:  " );
        super.eat();
        System.out.print("Переопределенный eat для Cat:  " );
        System.out.println (getPet() + " ест сметанку");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(variable, cat.variable) && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variable, name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "variable='" + variable + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}