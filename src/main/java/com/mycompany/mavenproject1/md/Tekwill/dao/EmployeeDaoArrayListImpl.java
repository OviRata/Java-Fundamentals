/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.md.Tekwill.dao;

import com.mycompany.mavenproject1.md.Tekwill.domain.Employee;
import com.mycompany.mavenproject1.md.Tekwill.domain.Department;
import java.util.ArrayList;

/**
 *
 * @author super
 */
public class EmployeeDaoArrayListImpl implements EmployeeDao {
     private static ArrayList<Employee> employeesArr=new ArrayList<Employee>();
    private static Department[] departmentsArr ={ 
        new Department("Finance"),
        new Department("IT"), 
        new Department("Production"),
        new Department("Marketing"), 
        new Department("Research and Development"),
        new Department("Human Resources") } ;
    
    
    public void create(Employee employee){
        employeesArr.add(employee);
    }


    //Extend the use of these functions to EmployeeService.java, just like read()

    int getEmployeeById(int id){
        for(int i=0; i<employeesArr.size(); i++){
            Employee currentEmployee = employeesArr.get(i);

            if(currentEmployee != null
            && currentEmployee.getId()==id){
                return i;
            }
        }
        return -1;
    }


    public Employee read(int employeeId){
        int i=getEmployeeById(employeeId);
        if(i>=0){
            return employeesArr.get(i);
        }

        return null;
    }

    public void update(int employeeId, String name, String lastName, String dep){
        //search employee by id
        // update data of the found employee
        
        
        int i=getEmployeeById(employeeId);
        if(i>=0){
            Employee employee=employeesArr.get(i);
            employee.setName(name );
            employee.setLastName(lastName );
            
        for(int j=0; j<departmentsArr.length; j++){
            if(departmentsArr[j].getName()==dep){
                employee.setDepartment(departmentsArr[j]);
                break;
            }
        }
        employeesArr.set(i, employee);
        }

    }

    public void delete(int id){
        //search employee by id
        //set the value to null
        int i=getEmployeeById(id);
        if(i>=0){
            employeesArr.remove(i);
        }
    }


    public Employee[] getAll(){
        Employee[] arr = new Employee[employeesArr.size()];
        arr=employeesArr.toArray(arr);
        return arr;
    }
    
    public Department[] getDepartments(){
        return departmentsArr;
    }
}
