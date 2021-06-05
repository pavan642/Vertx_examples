package com.vertx.examples.pojo;


public class StudentPoJo {

    private String name;
    private Integer id;
    private String gender;


    public StudentPoJo(String name, Integer id, String gender) {
        this.name = name;
        this.id = id;
        this.gender = gender;
    }

    public StudentPoJo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
