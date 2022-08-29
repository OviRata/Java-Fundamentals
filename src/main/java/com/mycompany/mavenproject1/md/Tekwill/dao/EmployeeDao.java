package com.mycompany.mavenproject1.md.Tekwill.dao;

import com.mycompany.mavenproject1.md.Tekwill.domain.Employee;
import com.mycompany.mavenproject1.md.Tekwill.domain.Department;

public interface EmployeeDao {
       void create(Employee employee);
       Employee read(int employeeId);
       void update(int employeeId, String name, String lastName, String dep);
       void delete(int employeeId);
       Employee[] getAll();
       Department[] getDepartments();
}
