package org.example;

public class Studentinfo {
    int id;
    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Studentinfo(int id, int age, String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }
}
