package com.yoon.lang.kotilnInJava.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class HelloLombokTest {
    @Getter
    @Setter
    private String name;

    private String address;

    @Getter
    @Setter
    private int age;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        HelloLombokTest hello = new HelloLombokTest();
        hello.setAddress("동작구");
        hello.setName("나나");
        hello.setAge(22);
    }
}
