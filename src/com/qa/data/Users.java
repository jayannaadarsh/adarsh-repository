package com.qa.data;

//POJO class
public class Users {

    String name;
    String job;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    String id;
    String createdAt;

    public Users(){

    }

    public Users(String name, String job){
        this.name=name;
        this.job=job;
    }

    //getters ans setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
