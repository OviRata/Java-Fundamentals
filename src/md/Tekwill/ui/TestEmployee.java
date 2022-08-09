package md.Tekwill.ui;

import md.Tekwill.domain.Employee;
import md.Tekwill.service.EmployeeService;

public class TestEmployee {
    public static void main(String[] args){
        EmployeeService employeeService=new EmployeeService();

        Employee employee= new Employee("Ion", "Bostan");
        boolean isEmployeeSaved=employeeService.create(employee);
        //employeeService.listEmployees();

        employee = new Employee("Vasile", "Botnaru");
        isEmployeeSaved=employeeService.create(employee);
        employeeService.listEmployees();

        employeeService.read(2);

        Employee updatedEmployee= new Employee("Eugen", "Radu");
        employeeService.update(1, updatedEmployee);

        employeeService.listEmployees();

        employeeService.delete(2);

        employeeService.listEmployees();
    }
}
