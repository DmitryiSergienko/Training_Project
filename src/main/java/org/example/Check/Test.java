package org.example.Check;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString

public class Test {
    public int age;
    public String name;

    public Test(){}

    public String toString(){

        return String.valueOf(age);
    }
}