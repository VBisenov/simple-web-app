package DAO.Implementation;

import Data.Managers.SQLManager;
import DAO.Interfaces.EmployeeDAO;
import ObjectModel.Department;
import ObjectModel.Employee;
import ObjectModel.JobTitlesEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    public EmployeeDAOImpl(){
        SQLManager.getInstance();
    }

    public void insert(Employee employee) {
        String query = "INSERT INTO employees(id, first_name, second_name, birth_date, hire_date, salary, jobtitles_id, departments_id)" +
                "VALUES ("+incrementID()+", '"+employee.getFirstName()+"', '"+employee.getSecondName()+"' , '"+employee.getBirthDate()+"'" +
                ", '"+employee.getHireDate()+"', "+employee.getSalary()+", '"+getJobTitlesID(employee.getJobTitle())+"', '"+ getDepartmentsID(employee.getDepartment())+"')";
        SQLManager.executeUpdate(query); //shell for statement.executeUpdate()
    }

    public void delete(Employee employee) {
        String query = "DELETE FROM employees WHERE first_name = '"+employee.getFirstName()+"'" +
                "AND second_name = '"+employee.getSecondName()+"' AND birth_date = '"+employee.getBirthDate()+"'";
        SQLManager.executeUpdate(query); //shell for statement.executeUpdate()
    }

    public Collection<Employee> getEmployees(){
        String query = "SELECT * FROM employees";
        ResultSet rs = SQLManager.executeQuery(query);
        return getCollection(rs); //return ArrayList<Employee> from resultSet;
    }


    private Collection<Employee> getCollection(ResultSet rs){
        Collection<Employee> employees = new ArrayList<>();
        try {
            while (rs.next()){
                String firstName = rs.getString(2);
                String secondName = rs.getString(3);
                LocalDate birthDate = rs.getDate(4).toLocalDate();
                LocalDate hireDate = rs.getDate(5).toLocalDate();
                int salary = rs.getInt(6);
                int jobTitleID = rs.getInt(7);
                int departmentID = rs.getInt(8);
                employees.add(new Employee(firstName, secondName, birthDate, hireDate, salary, getJobTitle(jobTitleID),
                        getDepartment(departmentID)));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return employees;
    }

    private Department getDepartment(int id){
        Department result = null;
        String query = "SELECT * FROM departments where id = '"+id+"'";
        ResultSet rs = SQLManager.executeQuery(query);
        return getDepartment(rs);
    }

    private JobTitlesEnum getJobTitle(int id){
        JobTitlesEnum result = null;
        String query = "SELECT * FROM jobtitles WHERE id = '"+id+"'";
        ResultSet rs = SQLManager.executeQuery(query);
        try {
            while (rs.next()) {
                result = JobTitlesEnum.valueOf(rs.getString(2));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }

    private Department getDepartment(ResultSet rs){
        Department department = null;
        try {
            while (rs.next()) {
                String name = rs.getString(2);
                String description = rs.getString(3);
                department = new Department(name, description);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return department;
    }

    private int getJobTitlesID(JobTitlesEnum jobTitle){
        String query = "SELECT id FROM jobtitles WHERE name = '"+jobTitle.name()+"'";
        ResultSet rs = SQLManager.executeQuery(query); //shell for statement.executeQuery()
        return getId(rs); //method return only ID value from result set
    }

    private int getDepartmentsID(Department department){
        String query = "SELECT id FROM departments WHERE name = '"+department.getName()+"'";
        ResultSet rs = SQLManager.executeQuery(query); //shell for statement.executeQuery()
        return getId(rs); //method return only ID value from result set
    }

    private int incrementID() {
        String query = "SELECT MAX(id) FROM employees";
        ResultSet rs = SQLManager.executeQuery(query); //shell for statement.executeQuery()
        return getId(rs) + 1; //return maxId+1;
    }

    private int getId(ResultSet resultSet){
        int result = 0;
        try {
            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }

}
