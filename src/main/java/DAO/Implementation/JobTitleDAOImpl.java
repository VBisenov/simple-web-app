package DAO.Implementation;

import DAO.Interfaces.JobTitleDAO;
import Data.Managers.SQLManager;
import ObjectModel.JobTitlesEnum;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobTitleDAOImpl implements JobTitleDAO {
    public JobTitleDAOImpl(){
        SQLManager.getInstance();
    }

    public void insert(JobTitlesEnum jobTitle) {
        String query = "INSERT INTO jobtitles (id, name)" +
                "VALUES ("+incrementId()+", '"+jobTitle.name()+"')";
        SQLManager.executeUpdate(query);
    }

    public void delete(JobTitlesEnum jobTitle) {
        String query = "DELETE FROM jobtitles WHERE name = '"+jobTitle.name()+"'";
        SQLManager.executeUpdate(query);
    }

    private int incrementId(){
        int result = 0;
        String query = "SELECT MAX(id) FROM jobtitles";
        ResultSet rs = SQLManager.executeQuery(query);
        try {
            while (rs.next()){
                result = rs.getInt(1)+1;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }
}
