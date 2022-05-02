package com.example.carpoolbuddy;

import java.util.ArrayList;

public class Parent extends User
{
    private ArrayList<String> childrensUID;

    public Parent(ArrayList<String> childrensUID) {
        this.childrensUID = childrensUID;
    }

    public Parent(String uid, String name, String email, String userType, double priceMultiplier, ArrayList<String> childrensUID) {
        super(uid, name, email, userType, priceMultiplier);
        this.childrensUID = childrensUID;
    }

    public Parent()
    {
        this.childrensUID = new ArrayList<>();
    }

    public ArrayList<String> getChildrensUID() {
        return childrensUID;
    }

    public void setChildrensUID(ArrayList<String> childrensUID) {
        this.childrensUID = childrensUID;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "childrensUID=" + childrensUID +
                '}';
    }
}
