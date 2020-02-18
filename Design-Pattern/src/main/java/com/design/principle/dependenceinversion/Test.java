package com.design.principle.dependenceinversion;

public class Test {

    public static void main(String[] args) {

        // v2
//        Geeli geeli = new Geeli();
//        geeli.studyCourse(new JavaCourse());
//        geeli.studyCourse(new FECourse());


// v3
//        Geeli geeli = new Geeli(new JavaCourse());
//        geeli.studyCourse();

        Geeli geeli = new Geeli();
        geeli.setiCourse(new JavaCourse());
        geeli.studyCourse();

        geeli.setiCourse(new FECourse());
        geeli.studyCourse();

    }
}
