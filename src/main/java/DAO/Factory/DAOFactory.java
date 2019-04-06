package DAO.Factory;

import DAO.Implementation.DepartmentDAOImpl;
import DAO.Implementation.EmployeeDAOImpl;
import DAO.Implementation.JobTitleDAOImpl;
import DAO.Interfaces.DepartmentDAO;
import DAO.Interfaces.EmployeeDAO;
import DAO.Interfaces.JobTitleDAO;
import ObjectModel.JobTitlesEnum;

public class DAOFactory {

    private DAOFactory(){
    }

    public static DepartmentDAO getDepartmentDAO(){
        return new DepartmentDAOImpl();
    }

    public static EmployeeDAO getEmployeeDAO(){
        return new EmployeeDAOImpl();
    }

    public static JobTitleDAO getJobTitleDAO(){
        return new JobTitleDAOImpl();
    }
}
