package com.pb.nikolaenko.hw7;

public class Skirt extends Clothes implements  WomenClothes{
    public Skirt(int price,String color,Sizes sz)     {
        super(price,color,sz);
    }
    @Override
    public void dressWomen() {
        System.out.println("Юбка "+":" +"цвет "+getColor()+", цена: "+getPrice() + ", размер "+getSz());
    }
}
