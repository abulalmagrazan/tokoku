package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        String password = new Random().ints(10, 122, 123).collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

//        String password=genratePassword.generatePassword(10);
        System.out.println(password);

        int[] angka =new Random().ints(5,-22,4).toArray();
        for (int data:angka) {
        System.out.println(data );
        }
    }
}
