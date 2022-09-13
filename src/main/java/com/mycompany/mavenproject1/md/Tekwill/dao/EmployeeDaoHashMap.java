/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.md.Tekwill.dao;
import com.mycompany.mavenproject1.md.Tekwill.dao.EmployeeDao;
import com.mycompany.mavenproject1.md.Tekwill.domain.Department;
import com.mycompany.mavenproject1.md.Tekwill.domain.Employee;

import java.util.HashMap;
import java.util.Optional;

/**
 *
 * @author super
 */
public class EmployeeDaoHashMap {
    private static HashMap<Integer, Employee> employeesHashMap=new HashMap<>();
    private static Department[] departmentsArr ={ 
        new Department("Finance"),
        new Department("IT"), 
        new Department("Production"),
        new Department("Marketing"), 
        new Department("Research and Development"),
        new Department("Human Resources") } ;
    
    
    public void create(Employee employee){
        employeesHashMap.put(employee.getId(), employee);
    }


    //Extend the use of these functions to EmployeeService.java, just like read()

    Employee getEmployeeById(int id){
        return employeesHashMap.get(id);
    }
        

    public Optional<Employee> read(int employeeId){
        return Optional.ofNullable(getEmployeeById(employeeId));
    }

    public void update(int employeeId, String name, String lastName, String dep){
        //search employee by id
        // update data of the found employee
        Department department = new Department();
        for(int j=0; j<departmentsArr.length; j++){
            if(departmentsArr[j].getName()==dep){
                department = departmentsArr[j];
            }
        }
        Employee employee = employeesHashMap.get(employeeId);
        if( employee==null ){
            return ;
        }
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setDepartment(department);
        employeesHashMap.remove(employeeId);
        employeesHashMap.put(employeeId, employee);
        
    }

    public void delete(int id){
        //search employee by id
        //set the value to null
        Employee employee=getEmployeeById(id);
        if( employee != null){
            employeesHashMap.remove(id);
        }
    }


    public Employee[] getAll(){
        Employee [] employees = new Employee[ employeesHashMap.size()];
        return employeesHashMap.values().toArray(employees);
    }
    
    public Department[] getDepartments(){
        return departmentsArr;
    }
}
