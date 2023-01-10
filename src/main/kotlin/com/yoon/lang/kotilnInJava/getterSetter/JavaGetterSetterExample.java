package com.yoon.lang.kotilnInJava.getterSetter;

import java.time.LocalDate;

public class JavaGetterSetterExample {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("학생");
        student.setBirthday(LocalDate.of(2020, 10,23));

        System.out.println(student.getName());
        System.out.println(student.getBirthday());

        student.changeAddress("동작구");
        System.out.println(student.getAddress());

        /** @JvmField */
        // 코틀린 field를 자바로 변환할 때는 이와같이 getter, setter 를 통해서만 가능하다.
        // 하나의 방법이 더 있긴한데, @JvmField = 프로퍼티 직접 접근만 가능해짐(getter, setter 불가능)
        student.grade = 3;
        System.out.println(student.grade);
    }
}
