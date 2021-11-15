package com.pb.nikolaenko.hw7;

public   class Pants extends Clothes implements ManClothes,WomenClothes{

    public Pants (int price,String color,Sizes sz)     {
        super(price,color,sz);
    }
    @Override
    public void dressWomen() {
        System.out.println("Штаны женские "+":" +"цвет "+getColor()+", цена: "+getPrice() + ", размер "+getSz());
    }

    @Override
    public void dressMan() {
        System.out.println("Штаны мужские " +":" +"цвет "+getColor()+", цена: "+getPrice() + ", размер "+getSz());
    }
}
