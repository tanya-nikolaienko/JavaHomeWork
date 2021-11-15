package com.pb.nikolaenko.hw7;

public abstract class Clothes {

    private int price;
    private String color;
    private Sizes sz;

    public Clothes(int price, String color, Sizes sz) {
        this.price = price;
        this.color = color;
        this.sz = sz;

    }


    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public Sizes getSz() {
        return sz;
    }




    }

