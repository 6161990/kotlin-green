package com.yoon.lang.kotilnInJava.use.jvmField;

public class JvmFieldExample {

    public static void main(String[] args) {
        int id = JvmFieldClass.Companion.getId();
        String name = JvmFieldObject.INSTANCE.getName();


        /** const(상수) 로 선언하면 바로 접근 가능  */
        int constId = JvmFieldClass.CONST_ID;
        String constName = JvmFieldObject.CONST_NAME;


        /** 상수가 아닌 경우에 static 하게 접근하려면? @JvmField */
        int jvmFieldId = JvmFieldClass.jvmFieldId;
        String jvmFieldName = JvmFieldObject.jvmFieldName;

    }
}
