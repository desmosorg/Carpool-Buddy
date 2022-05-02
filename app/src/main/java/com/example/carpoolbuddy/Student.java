package com.example.carpoolbuddy;

import java.util.ArrayList;

public class Student extends User
{
    private String graduatingYear;
    private ArrayList<String> parentsUIDs;

    public Student(String graduatingYear, ArrayList<String> parentsUIDs) {
        this.graduatingYear = graduatingYear;
        this.parentsUIDs = parentsUIDs;
    }

    public Student(String uid, String name, String email, String userType, double priceMultiplier, String graduatingYear, ArrayList<String> parentsUIDs) {
        super(uid, name, email, userType, priceMultiplier);
        this.graduatingYear = graduatingYear;
        this.parentsUIDs = parentsUIDs;
    }

    public Student()
    {
        this.graduatingYear = "";
        this.parentsUIDs = new ArrayList<>();
    }

    public String getGraduatingYear() {
        return graduatingYear;
    }

    public void setGraduatingYear(String graduatingYear) {
        this.graduatingYear = graduatingYear;
    }

    public ArrayList<String> getParentsUIDs() {
        return parentsUIDs;
    }

    public void setParentsUIDs(ArrayList<String> parentsUIDs) {
        this.parentsUIDs = parentsUIDs;
    }

    @Override
    public String toString() {
        return "Student{" +
                "graduatingYear='" + graduatingYear + '\'' +
                ", parentsUIDs=" + parentsUIDs +
                '}';
    }
}
