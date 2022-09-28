import java.lang.Class;
import java.sql.*;

public class Test {
    static public void main(String[] args){
        try{
            Class.forName(

                    "org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EmployeeDataBase", "postgres", "9991a");

        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }

}
