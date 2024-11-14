package com.java.examples.fileio;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    // Don't serialize/deserialize this field.
    private transient String password;
    private String department;

    public Employee(String name, int age, String password, String department) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
