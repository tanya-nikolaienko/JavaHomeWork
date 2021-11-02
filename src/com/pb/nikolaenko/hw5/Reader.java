package com.pb.nikolaenko.hw5;

public class Reader {
    private String fullName;
    private String numberOfTicket;
    private String faculty;
    private String dateOfBirth;
    private String numberOfPhone;


    //конструктор
    public Reader(String fullName, String numberOfTicket, String faculty, String dateOfBirth, String numberOfPhone){
        this.fullName=fullName;
        this.numberOfTicket=numberOfTicket;
        this.faculty=faculty;
        this.dateOfBirth=dateOfBirth;
        this.numberOfPhone=numberOfPhone;
    }


    public String getFullName() {   return fullName;    }

    public void setFullName(String fullName) {  this.fullName = fullName;    }

    public String getNumberOfTicket() {        return numberOfTicket;    }

    public void setNumberOfTicket(String numberOfTicket) {        this.numberOfTicket = numberOfTicket;    }

    public String getFaculty() {        return faculty;    }

    public void setFaculty(String faculty) {        this.faculty = faculty;    }

    public String getDateOfBirth() {        return dateOfBirth;    }

    public void setDateOfBirth(String dateOfBirth) {        this.dateOfBirth = dateOfBirth;    }

    public String getNumberOfPhone() {        return numberOfPhone;    }

    public void setNumberOfPhone(String numberOfPhone) {        this.numberOfPhone = numberOfPhone;    }



    String getInfo() {
        return "[ФИО студента: " + fullName + ", №билета: " + numberOfTicket + ", Факультет: " + faculty +
                ", Дата рождения: " + dateOfBirth + ", Номер телефона: " + numberOfPhone + "]";
    }


    public void takeBook(String number) {
        System.out.println("3." + fullName + "взял " + number + " книги ");
    }

    public void takeBook(String... names) {
        System.out.print("4." + fullName + "взял книги:");
        for (String name : names) {
            System.out.println(name);
        }
    }

    public void returnBook(String number) {
        System.out.println("7." + fullName + "вернул " + number + " книги ");
    }

    public void returnBook(String... names) {
        System.out.print("8." + fullName + "вернул книги:");
        for (String name : names) {
            System.out.println(name);
        }
    }


   }
