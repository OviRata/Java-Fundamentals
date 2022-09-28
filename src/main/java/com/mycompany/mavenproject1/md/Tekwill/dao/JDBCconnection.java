package com.mycompany.mavenproject1.md.Tekwill.dao;

import java.sql.*;

public class JDBCconnection {
    public static Connection createConnection(){
        Connection connection = null;
        try
        {
            Class.forName("org.postgresql.Driver" );
            connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/EmployeeDataBase", "postgres", "9991a");
        }
        catch(SQLException | ClassNotFoundException e ){
            e.printStackTrace();
        }
        return connection;
    }

}
