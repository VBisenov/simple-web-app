package Data.Managers;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class SQLManager {
    private static Connection connection;
    private static SQLManager instance;

    private SQLManager(){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/organization", "root", "qwerty");
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public static SQLManager getInstance(){
        if (instance == null){
            return new SQLManager();
        } else return instance;
    }

    public static Statement createStatement(){
        Statement result = null;
        try {
            result = connection.createStatement();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static void executeUpdate(String query){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query){
        ResultSet result = null;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }
}
