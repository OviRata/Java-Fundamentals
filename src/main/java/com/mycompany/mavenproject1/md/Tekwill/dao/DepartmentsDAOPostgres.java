/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.md.Tekwill.dao;

/**
 *
 * @author super
 */

import java.sql.*;
import com.mycompany.mavenproject1.md.Tekwill.domain.Department;
import java.util.ArrayList;
import java.util.List;


public class DepartmentsDAOPostgres {
    private final Connection connection = JDBCconnection.createConnection();
    
    private final String SQL_GET_ALL_DEPARTMENTS = "SELECT * FROM departmenttable";
    private final String SQL_CREATE_DEPARTMENT = 
            "INSERT INTO departmenttable " +
            "(id, name) "+
            "VALUES (?, ?)";
    private final String SQL_UPDATE_DEPARTMENT = 
            "UPDATE departmenttable "+
            "SET name=? "+
            "WHERE id=?";
    private final String SQL_DELETE_DEPARTMENT = 
            "DELETE FROM departmenttable WHERE id=?";
    private final String SQL_GET_DEPARTMENT_BY_ID = 
            "SELECT * FROM departmenttable "+
            "WHERE id=?";
    private final String SQL_GET_DEPARTMENT_BY_NAME = 
            "SELECT * FROM departmenttable "+
            "WHERE name=?";
            
                                                
    
    public Department[] getAll(){
        
        PreparedStatement pstmt = null;
        List<Department> departmentList = new ArrayList<Department>();
        
        try{
            pstmt = connection.prepareStatement(SQL_GET_ALL_DEPARTMENTS);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Department department = new Department();
                department.setId( rs.getInt(1)  );
                department.setName( rs.getString(2) );
                departmentList.add(department);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        
        Department[] departmentsArr = new Department[departmentList.size()];
        
        departmentsArr = departmentList.toArray(departmentsArr);
        return departmentsArr;
    }
    
    
    public void create(Department department){
        PreparedStatement pstmt = null;
        try{
            pstmt = connection.prepareStatement(SQL_CREATE_DEPARTMENT);
            
            pstmt.setInt(1, department.getId());
            pstmt.setString(2, department.getName());
            
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
    
    
    public Department getDepartmentById(int id){
        Department department = new Department();
        PreparedStatement pstmt=null;
        try{
            pstmt = connection.prepareStatement(SQL_GET_DEPARTMENT_BY_ID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                department.setId( rs.getInt(1) );
                department.setName( rs.getString(2) );
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return department;
    }
    
    public Department getDepartmentByName(String name){
        Department department = new Department();
        PreparedStatement pstmt=null;
        try{
            pstmt = connection.prepareStatement(SQL_GET_DEPARTMENT_BY_ID);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                department.setId( rs.getInt(1) );
                department.setName( rs.getString(2) );
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return department;   
    }
    
    
    public void delete(int id){
        PreparedStatement pstmt = null;
        try{
             pstmt = connection.prepareStatement(
                    SQL_DELETE_DEPARTMENT
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
}
