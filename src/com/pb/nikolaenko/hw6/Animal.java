package com.pb.nikolaenko.hw6;

 public class Animal {
    private String food;
    private String location;
    private String pet; // - только для обьявления класса

     public Animal(String food, String location){     // конструктор с параметрами
         this.food = food;
         this.location = location;
              }


    public String getPet() {        return pet;    }
    public void setPet(String pet) {        this.pet = pet;    }

    public String getFood() {      return food;    }
    public void setFood(String food) {        this.food = food;    }

    public String getLocation() {        return location;    }
    public void setLocation(String location) {        this.location = location;    }


    public void makeNoise(){
        System.out.println(pet + " шумит");
    }

    public  void eat(){
        System.out.println("Животное кушает " + food);
    }
    public void sleep(){
        System.out.println("Родительский sleep: " + pet +" спит");
    }
     public void define(){
         System.out.println(" ");

     }




}
