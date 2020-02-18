package com.design.principle.dependenceinversion;

public class Geeli {

    private ICourse iCourse;

    public Geeli(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public Geeli() {

    }
    public void studyCourse() {
        iCourse.studyCourse();
    }

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }
}
