package com.pb.nikolaenko.hw7;

public enum Sizes {
    XXS("XXS Детский размер, ","евро размер  32"),
    XS("XS Очень маленький размер, "," евро размер 34"),
    S("S Mаленький размер ","евро 36"),
    М("М Mедиум размер, ", "евро 38"),
    L("L Большой размер, ", " евро 40");

    public String getDescription() {
        return description;
    }

    private String description;

    public String getEurosize() {
        return eurosize;
    }

    private String eurosize;

    Sizes(String description, String eurosize) {
        this.description = description;
        this.eurosize = eurosize;
    }
/*
    public interface ManClothes  {
        public void dressMan ();
    }
*/
    /*
    public interface WomenClothes   {
        public void dressWomen  ();
    }
*/
/*
    @Override
    public String toString() {
        return "Размеры{" +
                "Описание:'" + description + '\'' +
                ", Евроразмер='" + eurosize + '\'' +
                '}';
    }
*/
}
