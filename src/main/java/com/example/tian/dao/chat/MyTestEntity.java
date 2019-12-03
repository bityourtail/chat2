package com.example.tian.dao.chat;

public class MyTestEntity {
    private Integer id;

    private String name;

    public MyTestEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public MyTestEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}