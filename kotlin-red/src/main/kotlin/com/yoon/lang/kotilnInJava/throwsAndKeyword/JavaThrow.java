package com.yoon.lang.kotilnInJava.throwsAndKeyword;

import java.io.IOException;

public class JavaThrow {

    public void getIOException() throws IOException {
        throw new IOException("체크드 예외 발생");
    }


    public static void main(String[] args) {
        JavaThrow javaThrow = new JavaThrow();

        /** java 는 체크드 예외 같은 경우, throws or try/catch 해주어야한다. */
        try {
            javaThrow.getIOException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        KotlinThrow kotlinThrow = new KotlinThrow();

        /** 여기를 try.catch 로 묶으면 컴파일 에러
         * why? kotlinThrow 에서 throws 해주고 있지 않기 때문에.
         * 자바와 코틀린 간의 예외 상호처리를 해주고 싶다면?
         * @Throws(IOException::class) 를 해당 메소드 위에 명시해주면된다. */
        kotlinThrow.getIOException();
    }
}
