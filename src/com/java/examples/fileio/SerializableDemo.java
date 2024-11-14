package com.java.examples.fileio;

import java.io.*;

public class SerializableDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Employee employee = new Employee("Peter", 30, "peter1990", "Development");

        // Serialize the employee object.
        FileOutputStream fout = new FileOutputStream("employee.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);

        out.writeObject(employee);

        System.out.println("Object has been serialized.");

        // Deserialize the employee object.

        Employee deserializedEmployee;
        FileInputStream fin = new FileInputStream("employee.txt");
        ObjectInputStream oin = new ObjectInputStream(fin);

        deserializedEmployee = (Employee) oin.readObject();

        System.out.println("Object has been serialized." + deserializedEmployee.toString());
    }
}
