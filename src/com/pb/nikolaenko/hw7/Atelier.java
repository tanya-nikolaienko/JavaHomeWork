package com.pb.nikolaenko.hw7;



public class Atelier {
    private static Tshort tshort1 = new Tshort(7, "Red", Sizes.XS);
    private static Tshort tshort2 = new Tshort(3, "Cherry",Sizes.S);
    private static Pants pants = new Pants(21, "darkblue",Sizes.L);
    private static Skirt skirt = new Skirt(17,"Brown",Sizes.L);
    private static Tie tie = new Tie(10,"Green",Sizes.XXS);

    private static Clothes[] clothes = new Clothes[]{tshort1, tshort2,pants,skirt,tie};


    public static void main(String[] args) {

        dressMan(clothes);
        dressWoman(clothes);

    }
    public static void dressMan(Clothes[] clothes) {
        for (Clothes clothe: clothes) {
            if (clothe instanceof ManClothes) {
                System.out.print("Men: ");
                ((ManClothes) clothe).dressMan();
            }
        }
    }

    public static void dressWoman(Clothes[] clothes) {
        for (Clothes clothe: clothes) {
            if (clothe instanceof WomenClothes) {
                System.out.print("Women: ");
                ((WomenClothes) clothe).dressWomen();
            }
        }
    }
}
