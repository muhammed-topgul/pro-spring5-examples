package com.muhammedtopgul.ch04.beanCreation.usingBean;

/*
 * created by Muhammed Topgul
 * on 27/07/2021
 * at 11:40
 */

public class Singer {

    private static final String DEFAULT_NAME = "Eric Clapton";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        System.out.println("Initializing bean");
        if (name == null) {
            System.out.println(":::Using default name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type " + Singer.class);
        }
    }

    public String toString() {
        return "\tName: " + name + "\n\tAge: " + age;
    }
}
