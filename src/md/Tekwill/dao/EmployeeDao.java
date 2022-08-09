package md.Tekwill.dao;

import md.Tekwill.domain.Employee;

public class EmployeeDao {
    private static Employee[] employeesArr=new Employee[10];

    public void create(Employee employee){
        for(int i=0; i < employeesArr.length; i++){
            Employee existingEmployee=employeesArr[i];
            if(existingEmployee==null){
                employeesArr[i]=employee;
                break;
            }
        }
    }


    //Extend the use of these functions to EmployeeService.java, just like read()

    int getEmployeeById(int id){
        for(int i=0; i<employeesArr.length; i++){
            Employee currentEmployee = employeesArr[i];

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
            return employeesArr[i];
        }

        return null;
    }

    public void update(int employeeId, Employee updatedEmployee){
        //search employee by id
        // update data of the found employee

        int i=getEmployeeById(employeeId);
        if(i>=0){
            employeesArr[i] = updatedEmployee;
        }

    }

    public void delete(int id){
        //search employee by id
        //set the value to null
        int i=getEmployeeById(id);
        if(i>=0){
            employeesArr[i]=null;
        }
    }


    public Employee[] getAll(){
        return employeesArr;
    }


}
