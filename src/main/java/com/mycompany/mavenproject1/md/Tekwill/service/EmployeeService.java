package md.Tekwill.service;

import md.Tekwill.domain.Employee;
import md.Tekwill.dao.EmployeeDao;

public class EmployeeService {
    private EmployeeDao employeeDao= new EmployeeDao();

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
        Employee employee= employeeDao.read(employeeId);
        if(employee==null){
            System.out.println("There is no employee with specified Id");
            return null;
        }

        System.out.println("ID: "+employee.getId());
        System.out.println("Name: "+employee.getName());
        System.out.println("Last Name: "+employee.getLastName()+"\n");

        return employee;
    }

    public void update(int id, String name, String lastName){
        if( (name.length()>0)
        && lastName.length()>0 ){
            employeeDao.update(id, name, lastName);
        }
        else{
            System.out.println("The data of the updated employee is inconsistent.");
        }
    }

    public void delete(int id){
        employeeDao.delete(id);
    }

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

}
