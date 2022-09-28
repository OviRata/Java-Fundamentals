package com.mycompany.mavenproject1.md.Tekwill.domain;

public class Department {
    private int id;
    private String name;
    private static int idGenerator;

    public Department(){
        generateId();
    }

    public Department(String name){
        this();
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void generateId(){
        idGenerator++;
        id = idGenerator;
    }
    
    public int getId(){
        return id;
    }
    
}
