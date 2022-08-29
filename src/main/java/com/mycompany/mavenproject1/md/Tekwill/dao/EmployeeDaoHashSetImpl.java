/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.md.Tekwill.dao;

import com.mycompany.mavenproject1.md.Tekwill.domain.Department;
import com.mycompany.mavenproject1.md.Tekwill.domain.Employee;

import java.util.HashSet;

/**
 *
 * @author super
 */
public class EmployeeDaoHashSetImpl implements EmployeeDao {
    
     private static HashSet<Employee> employeesSet=new HashSet<Employee>();
    private static Department[] departmentsArr ={ 
        new Department("Finance"),
        new Department("IT"), 
        new Department("Production"),
        new Department("Marketing"), 
        new Department("Research and Development"),
        new Department("Human Resources") } ;
    
    
    public void create(Employee employee){
        employeesSet.add(employee);
    }


    //Extend the use of these functions to EmployeeService.java, just like read()

    Employee getEmployeeById(int id){
        for(Employee employee:employeesSet){
            if(employee.getId()==id){
                return employee;
            }
        }
        return null;
    }


    public Employee read(int employeeId){
        return getEmployeeById(employeeId);
    }

    public void update(int employeeId, String name, String lastName, String dep){
        //search employee by id
        // update data of the found employee
        
        
        Employee employee = getEmployeeById(employeeId);
        
        if(employee != null){
            employeesSet.remove(employee);
            employee.setName(name);
            employee.setLastName(lastName);
        for(int j=0; j<departmentsArr.length; j++){
            if(departmentsArr[j].getName()==dep){
                employee.setDepartment(departmentsArr[j]);
                break;
            }
        }
        employeesSet.add(employee);
        }

    }

    public void delete(int id){
        //search employee by id
        //set the value to null
        Employee employee=getEmployeeById(id);
        if(employee != null){
            employeesSet.remove(employee);
        }
    }


    public Employee[] getAll(){
        int n = employeesSet.size();
        Employee[] arr = new Employee[n];
        int i=0;
        for(Employee employee:employeesSet){
            arr[i] = employee;
            i++;
        }
        return arr;
    }
    
    public Department[] getDepartments(){
        return departmentsArr;
    }
    
    
}
