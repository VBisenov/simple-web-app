package DAO.Interfaces;

import ObjectModel.Employee;
import ObjectModel.JobTitlesEnum;

import java.util.Collection;

public interface EmployeeDAO {
    public void insert(Employee employee);
    public void delete(Employee employee);
    public Collection<Employee> getEmployees();
}
