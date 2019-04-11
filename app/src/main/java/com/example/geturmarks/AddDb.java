package com.example.geturmarks;

public class AddDb {
    String exam,sub,roll,mark;

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public AddDb(String exam, String sub, String roll, String mark) {
        this.exam = exam;
        this.sub = sub;
        this.roll = roll;
        this.mark = mark;
    }
}
