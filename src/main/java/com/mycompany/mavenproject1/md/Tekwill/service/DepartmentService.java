/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.md.Tekwill.service;

/**
 *
 * @author super
 */

import com.mycompany.mavenproject1.md.Tekwill.domain.Department;
import com.mycompany.mavenproject1.md.Tekwill.dao.DepartmentsDAOPostgres;

public class DepartmentService {
    private DepartmentsDAOPostgres departmentDao= new DepartmentsDAOPostgres();
    
    public boolean create(Department department){
        if(department.getName().length()>0 ){
            departmentDao.create(department);
            return true;
        }
        System.out.println("Department could not be created.");
        return false;
    }
    
    public Department getDepartmentById(int id){
        Department department = departmentDao.getDepartmentById(id);
        if( (department.getName()==null) || (department.getName().equals("")) ){
            return null;
        }
        return department;
    }
    
    public Department getDepartmentByName(String name){
        Department department = departmentDao.getDepartmentByName(name);
        if( (department.getName()==null) || (department.getName().equals("")) ){
            return null;
        }
        return department;
    }
    
    public void delete(int id){
        departmentDao.delete(id);
    }
    
    
    public Department[] getArr(){
        return departmentDao.getAll();
    }
    
    
}
