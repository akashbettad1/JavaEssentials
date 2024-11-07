package com.java.examples.java8features;


import java.math.BigDecimal;
import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Staff {
    private String name;
    private Integer id;
    private BigDecimal salary;

    public Staff(String name, Integer id, BigDecimal salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}

public class OptionalTest {

    public static void main(String[] args) {
        List<Staff> staffList = new ArrayList<>();

        staffList.add(new Staff("abc", 1, new BigDecimal(12000)));
        staffList.add( new Staff("def", 2, new BigDecimal(12000)));
        staffList.add( new Staff("ghi", 3, new BigDecimal(12000)));
        staffList.add( new Staff("xyz", 4, new BigDecimal(12000)));

        Optional<Staff> staff = Optional.ofNullable(staffList.get(0));

        if (staff.isPresent()) {
            String name = staff.get().getName();
            System.out.println("1st Staff name is: " +name);
        }

        Optional<Integer> op = Optional.of(9455);

        System.out.println("Optional: "
                + op);

        // orElseThrow supplier
        System.out.println(
                "Value by orElseThrow("
                        + "ArithmeticException::new) method: "
                        + op.orElseThrow(
                        ArithmeticException::new));
    }

}
