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
    public Employee read(int employeeId){
        //search employee by Id

        for(int i=0; i<employeesArr.length; i++){
            Employee currentEmployee=employeesArr[i];

            if( (currentEmployee != null)
                    && currentEmployee.getId()==employeeId  ){
                    return currentEmployee;
            }
        }


        return null;
    }

    public void update(int employeeId, Employee updatedEmployee){
        //search employee by id
        // update data of the found employee

        for(int i=0; i<employeesArr.length; i++){
            Employee employee = employeesArr[i];

            if( (employee != null)
            && employee.getId()==employeeId){
                employeesArr[i]=updatedEmployee;
                return;
            }
        }

    }

    public void delete(int id){
        //search employee by id
        //set the value to null

        for(int i=0; i<employeesArr.length; i++){
            Employee employee = employeesArr[i];

            if( (employee != null)
            && employee.getId()==id){
                employeesArr[i]=null;
                return;
            }
        }


    }


    public Employee[] getAll(){
        return employeesArr;
    }


}
