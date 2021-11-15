package com.pb.nikolaenko.hw7;

public class Tie extends Clothes implements ManClothes{
    public Tie(int price,String color,Sizes sz)     {
        super(price,color,sz);
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук " +":" +"цвет "+getColor()+", цена: "+getPrice() + ", размер "+getSz());
    }
}
