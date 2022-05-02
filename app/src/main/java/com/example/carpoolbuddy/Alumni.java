package com.example.carpoolbuddy;

public class Alumni extends User
{
    private int graduateYear;

    public Alumni(int graduateYear) {
        this.graduateYear = graduateYear;
    }

    public Alumni(String uid, String name, String email, String userType, double priceMultiplier, int graduateYear) {
        super(uid, name, email, userType, priceMultiplier);
        this.graduateYear = graduateYear;
    }

    public Alumni()
    {
        this.graduateYear = 0;
    }

    public int getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(int graduateYear) {
        this.graduateYear = graduateYear;
    }

    @Override
    public String toString() {
        return "Alumni{" +
                "graduateYear=" + graduateYear +
                '}';
    }
}
