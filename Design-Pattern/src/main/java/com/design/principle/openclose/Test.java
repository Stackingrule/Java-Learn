package com.design.principle.openclose;

public class Test {

    public static void main(String[] args) {

        ICourse iCourse = new JavaDiscountCourse(96, "Java电商", 348d);
        JavaDiscountCourse javaCourse = (JavaDiscountCourse) iCourse;
        System.out.println("Id: " + javaCourse.getId() + " 课程名称：" + javaCourse.getName() + " 课程原件:" + javaCourse.getOriginPrice());
    }
}
