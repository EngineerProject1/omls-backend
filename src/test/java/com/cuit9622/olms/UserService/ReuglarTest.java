package com.cuit9622.olms.UserService;

import org.junit.jupiter.api.Test;

public class ReuglarTest {
    @Test
    public void test1() {
        long id = 5;
        System.out.println(String.valueOf(id).matches("\\d{1}"));
    }
    @Test
    public void test2() {
        String name = "jacktom";
        System.out.println(name.matches("^([\\u4e00-\\u9fa5]{2,4}|[a-zA-Z]{2,16})$"));
    }
}
