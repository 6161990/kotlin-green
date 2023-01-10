package com.yoon.lang.kotilnInJava.use.jvmStack;

public class JvmStaticExample {

    public static void main(String[] args) {
        String hello = HelloClass.Companion.hello(); // Companion 키워드 뺄 수 없음
        String hi = HiObject.INSTANCE.hi(); // INSTANCE 키워드 뺄 수 없음

        System.out.println(hello);
        System.out.println(hi);


        /** @JvmStatic 키워드를 이용하여 바로 접근할 수 있음 */
        String hello2 = HelloClass.hello();
        String hi2 = HiObject.hi();

        System.out.println(hello2);
        System.out.println(hi2);


        /** @JvmField 키워드를 이용하여 정적 필드 호출하기 */
    }
}
