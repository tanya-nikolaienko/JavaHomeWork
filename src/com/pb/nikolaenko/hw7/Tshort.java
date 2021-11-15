package com.pb.nikolaenko.hw7;

public class Tshort extends Clothes implements ManClothes,WomenClothes {

     public Tshort(int price,String color,Sizes sz)     {
         super(price,color,sz);

  }

    @Override
    public void dressWomen() {
        System.out.println("Футболка женская "+":" +"цвет "+getColor()+" цена: "+getPrice() + " размер "+getSz());
    }

    @Override
    public void dressMan() {
        System.out.println("Футболка мужская " +":" +"цвет "+getColor()+" цена: "+getPrice() + " размер "+getSz());
    }
}
