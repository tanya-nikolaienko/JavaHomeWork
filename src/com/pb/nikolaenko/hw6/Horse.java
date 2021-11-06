package com.pb.nikolaenko.hw6;


import java.util.Objects;

public class Horse extends Animal{

    private String variable;
    private String name;

    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }

    public String getVariable() {        return variable;    }
    public void setVariable(String variable) {        this.variable = variable;    }



    public Horse(){
        super("Сено", "Конно-спортивная база");
    }

    @Override
    public void define(){
        System.out.println();
        System.out.println ( "--- класс Лошадь ---");
        System.out.println("Кличка: " + getName() +"; Среда обитания: " + getLocation() + " ; " + "Еда: "+ getFood());
        System.out.println("Награды:" + variable);
    }

    @Override
    public void makeNoise(){
        System.out.print("Родительский makeNoise для Horse:  " );
        super.makeNoise();
        System.out.print("Переопределенный makeNoise для Horse:  " );
        System.out.println (getPet() + " пытается сбросить всадника");
    }

    @Override
    public void eat(){
        System.out.print("Родительский eat для Horse:  " );
        super.eat();
        System.out.print("Переопределенный eat для Horse:  " );
        System.out.println (getPet() + " ест морковку");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse  = (Horse) o;
        return Objects.equals(variable, horse.variable) && Objects.equals(name, horse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variable, name);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "Награды='" + variable + '\'' +
                ", Имя='" + name + '\'' +
                '}';
    }
}
