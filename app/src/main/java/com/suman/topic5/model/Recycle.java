package com.suman.topic5.model;

public class Recycle {

    private int image;
    private  String name;
    private String age;
    private String gender;

    public Recycle(int image, String name, String age, String gender) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
