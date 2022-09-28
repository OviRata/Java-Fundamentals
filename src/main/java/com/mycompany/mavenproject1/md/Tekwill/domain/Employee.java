package com.mycompany.mavenproject1.md.Tekwill.domain;

import java.time.LocalDateTime;
import java.util.Optional;

public class Employee {
    private int id;
    private String name;
    private String lastName;
    private Department department;
    private static int idGenerator;
    private LocalDateTime createdLocalDateTime;
    private Optional<LocalDateTime> updatedLocalDateTime; 
    

    public Employee(){
       this.generateId();
       this.createdLocalDateTime = LocalDateTime.now();
       this.updatedLocalDateTime = Optional.ofNullable(null);
    }

    public Employee(String name, String lastName){
        this();
        this.name=name;
        this.lastName=lastName;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    private void generateId(){
        idGenerator++;
        id=idGenerator;
    }

    public void setDepartment(Department dep){
        this.department=dep;
    }
    
    public Department getDepartment(){
        return department;
    }
    
    public LocalDateTime getCreatedLocalDateTime(){
        return createdLocalDateTime;
    }
    
    public Optional<LocalDateTime> getUpdatedLocalDateTime(){
        return updatedLocalDateTime;
    }
    public void setUpdatedLocalDateTime( LocalDateTime time ){
        this.updatedLocalDateTime = Optional.ofNullable( time );
    }
    
    public void setCreatedLocalDateTime( LocalDateTime time ){
        this.createdLocalDateTime = time;
    }
    
    
    public static void setIdGenerator(int x){
        idGenerator=x;
    }
    
}
