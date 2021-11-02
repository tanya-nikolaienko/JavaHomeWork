package com.pb.nikolaenko.hw5;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Бродячий замок", "Д.Джонс", "1986");
        Book book2 = new Book("Так говорил Заратустра", "Ф.Ницше", "1883");
        Book book3 = new Book("Короткие ответы на большие вопросы", "С.Хоккинг", "2019");

        System.out.println("1.Книги:");
        System.out.println(book1.getInfo());
        System.out.println(book2.getInfo());
        System.out.println(book3.getInfo());

//конструктор
        Reader reader1 = new Reader("Попов О.И.", "123456", "Прикладная математика", "01.01.1980", "0501234567");
        Reader reader2 = new Reader("Бирюк Р.Д.", "789101", "Исторический", "01.01.1990","0671234567");
        Reader reader3 = new Reader("Соболев Г.Г.", "121314","Физико-технический", "01.01.2000","0731234567");

        System.out.println("2.Читатели:");
        System.out.println(reader1.getInfo());
        System.out.println(reader2.getInfo());
        System.out.println(reader3.getInfo());


       reader1.takeBook("три");
       reader2.takeBook("Бродячий замок", "Так говорил Заратустра", "Короткие ответы на большие вопросы");
       book3.takeBook("Короткие ответы на большие вопросы ", "(С.Хоккинг, ", "2019)");

       System.out.println("6."+ reader1.getFullName()+" взял книги: "
               +book1.getName() + " ("+ book1.getAuthor() + ", " + book1.getPublishingDate()+"),"
               +book2.getName() + " ("+ book2.getAuthor() + ", " + book2.getPublishingDate()+"),"
               +book3.getName() + " ("+ book3.getAuthor() + ", " + book3.getPublishingDate()+")," );


       reader1.returnBook("две");
       reader2.returnBook("Бродячий замок", "Так говорил Заратустра", "Короткие ответы на большие вопросы");
       book3.returnBook("Так говорил Заратустра ", "Ф.Ницше, ", "1883");

        System.out.println("10."+ reader3.getFullName()+" вернул книги: "
                +book1.getName() + " ("+ book1.getAuthor() + ", " + book1.getPublishingDate()+"),"
                +book2.getName() + " ("+ book2.getAuthor() + ", " + book2.getPublishingDate()+"),"
                +book3.getName() + " ("+ book3.getAuthor() + ", " + book3.getPublishingDate()+")," );

    }

}
