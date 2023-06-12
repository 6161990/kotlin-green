package com.yoon.lang.kotilnInJava.extendsMethod;

public class JavaExtension {

    public static void main(String[] args) {
        // 코틀린에서 접근하는 것처럼 사용하면 컴파일 에러가 난다.
        // "AAAA".first();
        // "BBB".addFirst('B');


        /** 코틀린에서의 확장함수는 자바로 변환시 static 메소드로 변환되고,  첫번째인자가 확장 대상인 수신자객체가된다.*/
        char firstChar = KotlinExtensionMethodKt.first("AAA");
        String addFirst = KotlinExtensionMethodKt.addFirst("AAA", 'B');

        System.out.println(firstChar);
        System.out.println(addFirst);
    }

}
