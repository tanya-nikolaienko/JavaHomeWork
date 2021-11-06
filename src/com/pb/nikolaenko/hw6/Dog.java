package com.pb.nikolaenko.hw6;

import java.util.Objects;

public class Dog extends Animal{
    private String variable;
    private String name;

    public String getVariable() { return variable;    }

    public void setVariable(String variable) { this.variable = variable; }



    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }


    public Dog(){
        super("MeraDog", "Вольер");
    }

@Override
    public void define(){
    System.out.println();
        System.out.println ( "--- класс Собака ---");
        System.out.println("Кличка: " + getName() +"; Среда обитания: " + getLocation() + " ; " + "Еда: "+ getFood());
        System.out.println("Порода собаки:" + variable);
    }

    @Override
    public void makeNoise(){
        System.out.print("Родительский makeNoise для Dog:  " );
        super.makeNoise();
        System.out.print("Переопределенный makeNoise для Dog:  " );
        System.out.println (getPet() + " лает на кошку Дашку");
    }

    @Override
    public void eat(){
        System.out.print("Родительский eat для Dog:  " );
        super.eat();
        System.out.print("Переопределенный eat для Dog:  " );
        System.out.println (getPet() + " грызет косточку");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(variable, dog.variable) && Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variable, name);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "variable='" + variable + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
