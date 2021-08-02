package com.example.myfirstapp;

import java.io.Serializable;

public class Student implements Serializable {
    int id;
    String name;

    public Student(){

    }

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }


}
