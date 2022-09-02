
package dataapp;
import java.sql.*;

public class DB {
    
    String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String user = "root";
    String password = "Panavision85!";
    
    public DB(String dbURL, String user, String password)throws SQLException, ClassNotFoundException
    {
        Connection connection = DriverManager.getConnection(dbURL, user, password);
        System.out.println("DataBase Connected");
    }
    
    public void insert(Employee emp) throws SQLException, ClassNotFoundException
    {
        Connection connection = DriverManager.getConnection(url, user, password);
        String insert = 
        "insert into staff (id, lastname, firstname, mi, address, city, state, telephone, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
        
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setInt(1, emp.getId());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getFirstName());
            preparedStatement.setString(4, emp.getMi());
            preparedStatement.setString(5, emp.getAddress());
            preparedStatement.setString(6, emp.getCity());
            preparedStatement.setString(7, emp.getState());
            preparedStatement.setString(8, emp.getPhone());
            preparedStatement.setString(9, emp.getEmail());
            
            preparedStatement.executeUpdate();
            
            System.out.println("Inserted");
        }catch(Exception exc)
        {
            System.out.println("Insert Failed");
        }
        
    }
    
    public void update(Employee emp) throws SQLException, ClassNotFoundException
    {
        Connection connection = DriverManager.getConnection(url, user, password);
        
        String update = 
       "update staff set lastname = ?, firstname = ?, mi = ?, address = ?, city = ?, state = ?, telephone = ?, email = ? where id = ?"; 
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            
            preparedStatement.setString(1, emp.getLastName());
            preparedStatement.setString(2, emp.getFirstName());
            preparedStatement.setString(3, emp.getMi());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setString(5, emp.getCity());
            preparedStatement.setString(6, emp.getState());
            preparedStatement.setString(7, emp.getPhone());
            preparedStatement.setString(8, emp.getEmail());
            preparedStatement.setInt(9, emp.getId());
            
            preparedStatement.executeUpdate();
            
            System.out.println("Updated");
        }catch(Exception exc)
        {
            System.out.println("Update Failed");
        }
        
        
    }
    
    public void clear(Employee emp)throws SQLException, ClassNotFoundException
    {
        Connection connection = DriverManager.getConnection(url, user, password);
        
        String update = 
       "delete from staff where id = ?"; 
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            
            preparedStatement.setInt(1, emp.getId());
            
            preparedStatement.executeUpdate();
            
            System.out.println("Cleared");
        }catch(Exception exc)
        {
            System.out.println("Clear Failed");
        }
    }
    
    
    
}
