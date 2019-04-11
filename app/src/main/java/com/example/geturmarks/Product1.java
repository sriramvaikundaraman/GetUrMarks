package com.example.geturmarks;

public class Product1 {
    String rollno,subject;

    public Product1(String rollno, String subject) {
        this.rollno = rollno;
        this.subject = subject;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
