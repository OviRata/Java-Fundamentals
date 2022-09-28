package com.mycompany.mavenproject1.md.Tekwill.service;

import com.mycompany.mavenproject1.md.Tekwill.domain.Employee;
import com.mycompany.mavenproject1.md.Tekwill.dao.EmployeeDaoHashMap;
import com.mycompany.mavenproject1.md.Tekwill.dao.EmployeeDaoImpl;
import com.mycompany.mavenproject1.md.Tekwill.domain.Department;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class EmployeeService {
    private EmployeeDaoImpl employeeDao= new EmployeeDaoImpl();

    public boolean create(Employee employee){
        if(employee.getName().length()>0
        && employee.getLastName().length()>0){
            employeeDao.create(employee);
            return true;
        }
        System.out.println("System validation failed!");
        return false;
    }

    public Employee read(int employeeId){
        Optional<Employee> optionalEmployee= Optional.ofNullable(employeeDao.getEmployeeById(employeeId));
        return optionalEmployee.orElse(null);
    }

    public boolean update(int id, String name, String lastName, String dep){
        if( (name.length()>0)
        && lastName.length()>0 ){
            employeeDao.update(id, name, lastName, dep);
            return true;
        }
        else{
            System.out.println("The data of the updated employee is inconsistent.");
            return false;
        }
    }

    public void delete(int id){
        employeeDao.delete(id);
    }

    /*
    public void listEmployees(){
        Employee [] employeeList=employeeDao.getAll();
        for(Employee employee: employeeList){
            if(employee != null){
                    System.out.println("ID: "+employee.getId());
                    System.out.println("Name: "+employee.getName());
                    System.out.println("Last Name: "+employee.getLastName());
               }
            }
        System.out.println();
    }
    */
    
    public Employee[] getArr(){
        List<Employee> employeeList = getList();
        Employee[] employeesArray = new Employee[ employeeList.size() ];
        employeesArray = employeeList.toArray( employeesArray );
        return employeesArray;
    }
    
    public List<Employee> getList(){
        return employeeDao.getAll();
    }
    
    public Department[] getDepartments(){
        return employeeDao.getDepartments();
    }

}
