package DAO.Implementation;

import DAO.Factory.DAOFactory;
import DAO.Interfaces.EmployeeDAO;
import Data.Managers.SQLManager;
import ObjectModel.Department;
import ObjectModel.Employee;
import ObjectModel.JobTitlesEnum;

import java.util.Collection;

public class Test {
    public static void main(String[] args) {
        Collection<Employee> employees = DAOFactory.getEmployeeDAO().getEmployees();
        System.out.println("fuck o");
    }
}
