package com.mycompany.mavenproject1.md.Tekwill.dao;

import java.sql.*;
import com.mycompany.mavenproject1.md.Tekwill.domain.Employee;
import com.mycompany.mavenproject1.md.Tekwill.domain.Department;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoImpl {
    private final Connection connection = JDBCconnection.createConnection();
    private static DepartmentsDAOPostgres departmentDao = new DepartmentsDAOPostgres();
        private static Department[] departmentsArr = departmentDao.getAll();
        
    private static void setDepartmentsArr(){
        departmentsArr = departmentDao.getAll();
        int newGenerator=0;
        for(int i=0; i<departmentsArr.length; i++){
            newGenerator=java.lang.Math.max(newGenerator, departmentsArr[i].getId());
        }
        Department.setIdGenerator(newGenerator+1);
    }
        
    private final String SQL_CREATE_EMPLOYEE =
            "INSERT INTO EmployeeTable " +
                    "(id, name, lastname, departmentid, creationlocaldatetime, updatedlocaldatetime)"+
                    " VALUES (?, ?, ?, ?, ?, ?)";
    private final String SQL_GET_EMPLOYEE_BY_ID =
            "SELECT * FROM employeetable WHERE id=?";
    private final String SQL_GET_ALL_EMPLOYEES =
            "SELECT * FROM employeetable";
    private final String SQL_DELETE_EMPLOYEE =
            "DELETE FROM employeetable WHERE id=?";
    private final String SQL_UPDATE_EMPLOYEE =
            "UPDATE employeetable " +
                    "SET name=?, lastname=?, departmentid=?, updatedlocaldatetime=?" +
            " WHERE id=?";

    
    public Employee getEmployeeById(int id){
        return getEmployeeWithStatement(id);
    }
    
    
    public void create(Employee employee){
        PreparedStatement pstmt = null;
        try{
            pstmt = connection.prepareStatement(SQL_CREATE_EMPLOYEE);
            
            pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getName() );
            pstmt.setString(3, employee.getLastName());
            pstmt.setInt(4, employee.getDepartment().getId());
            pstmt.setTimestamp(5, Timestamp.valueOf(employee.getCreatedLocalDateTime())  );
            if( employee.getUpdatedLocalDateTime().isEmpty() ){
                pstmt.setNull(6, java.sql.Types.TIMESTAMP );
            }
            else{
                pstmt.setTimestamp(6, Timestamp.valueOf(employee.getUpdatedLocalDateTime().get()) );
            }
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            
            try{
                pstmt.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            } 
        }
    }
    
    public Department getDepartmentById(int departmentId){
        setDepartmentsArr();
        for(int i=0; i<departmentsArr.length; i++){
            //System.out.println(departmentsArr[i].getName());
            if(departmentsArr[i].getId()==departmentId){
                return departmentsArr[i];
            }
        }
        return null ;
    }
    
    public Department getDepartmentByName(String departmentName){
        setDepartmentsArr();
        for(int i=0; i<departmentsArr.length; i++){
            if(departmentsArr[i].getName().equals(departmentName)){
                return departmentsArr[i];
            }
        }
        return null;
    }
    
    public Employee getEmployeeWithStatement(int id){
        Employee employee = new Employee();
        PreparedStatement pstmt=null;
        try{
            pstmt = connection.prepareStatement(SQL_GET_EMPLOYEE_BY_ID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                employee.setId( rs.getInt(1) );
                employee.setName( rs.getString(2) );
                employee.setLastName( rs.getString(3) );
                employee.setDepartment(  getDepartmentById( rs.getInt(4) )  );
                employee.setCreatedLocalDateTime( rs.getTimestamp(5).toLocalDateTime() );
                Timestamp ts = rs.getTimestamp(6);
                employee.setUpdatedLocalDateTime( (ts==null)?( null ):(ts.toLocalDateTime()) );
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return employee;
    }
    
    public void update(int id, String name, String lastName, String dep){
        //String updatedLocalDateTimeString = LocalDateTime.now().toString();
        //String departmentIdString =Integer.toString( getDepartmentByName(dep).getId() );
        
        PreparedStatement pstmt = null;
        try{
           pstmt = connection.prepareStatement(SQL_UPDATE_EMPLOYEE );
           pstmt.setString(1, name);
           pstmt.setString(2, lastName);
           pstmt.setInt( 3, getDepartmentByName(dep).getId() );
           pstmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()) );
           pstmt.setInt(5, id);
           pstmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                pstmt.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public void delete(int id){
        PreparedStatement pstmt = null;
        try{
             pstmt = connection.prepareStatement(
                    SQL_DELETE_EMPLOYEE
            );
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        catch( SQLException e ){
            e.printStackTrace();
        }
        finally{
            try{
                pstmt.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public List<Employee> getAll(){
        List<Employee> allEmployees = new ArrayList<>();
        try( PreparedStatement pstmt = connection.prepareStatement(SQL_GET_ALL_EMPLOYEES) ){
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Employee employee = new Employee();
                employee.setId( rs.getInt(1) );
                employee.setName( rs.getString(2) );
                employee.setLastName( rs.getString(3) );
                employee.setDepartment( getDepartmentById( rs.getInt(4) ) );
                employee.setCreatedLocalDateTime( rs.getTimestamp(5).toLocalDateTime() );
                
                Timestamp ts = rs.getTimestamp(6);
                LocalDateTime updatedLocalDateTime = (ts==null)?(null):(ts.toLocalDateTime());
                employee.setUpdatedLocalDateTime( updatedLocalDateTime );
                allEmployees.add(employee);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return allEmployees;
    }
    
    
    public Department[] getDepartments(){
        return departmentsArr;
    }
    
}
