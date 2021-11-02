package com.pb.nikolaenko.hw5;

import java.util.Date;

public class Book {
    private String name;
    private String author;
    private String publishingDate;

    public  Book(String name, String author, String publishingDate){ //create constructor
        this.name = name;
        this.author = author;
        this.publishingDate = publishingDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }

    String getInfo(){
        return "[Название книги: "+ name + ", Автор книги: " + author + ", Дата издательства: " + publishingDate +"]";
    };

    public void takeBook(String names, String authors, String dates){
        System.out.println("5." + name+" (" + author +", " + publishingDate+" )");
        }

    public void returnBook(String names, String authors, String dates){
        System.out.println("9." + name+" (" + author +", " + publishingDate+" )");
    }
}
