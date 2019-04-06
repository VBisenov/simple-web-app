package DAO.Implementation;

import Data.Managers.SQLManager;
import DAO.Interfaces.DepartmentDAO;
import ObjectModel.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAOImpl implements DepartmentDAO {
    public DepartmentDAOImpl(){
        SQLManager.getInstance();
    }

    public void insert(Department department) {
        String query = "INSERT INTO departments (id, name, description) " +
                "VALUES ("+incrementID()+", '"+department.getName()+"', '"+department.getDescription()+"')";
        SQLManager.executeUpdate(query);
    }

    public void delete(Department department) {
        String query = "DELETE FROM departments WHERE name = '"+department.getName()+"' AND description = '"+department.getDescription()+"'";
        SQLManager.executeUpdate(query);
    }

    private int incrementID(){
        String query = "SELECT MAX(id) FROM departments";
        ResultSet rs = SQLManager.executeQuery(query);
        return getId(rs)+1; //return maxID+1;
    }

    private int getId(ResultSet rs){
        int result = 0;
        try {
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }
}
