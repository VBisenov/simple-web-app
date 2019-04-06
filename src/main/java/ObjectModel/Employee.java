package ObjectModel;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String firstName;
    private String secondName;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private int salary;
    private JobTitlesEnum jobTitle;
    private Department department;

    public Employee(String firstName, String secondName, LocalDate birthDate,
                    LocalDate hireDate, int salary, JobTitlesEnum jobTitle, Department department) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.department = department;
    }

    public Employee(String firstName, String secondName, LocalDate birthDate, int salary, JobTitlesEnum jobTitle, Department department) {
        this(firstName, secondName, birthDate, LocalDate.now(), salary, jobTitle, department);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public JobTitlesEnum getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitlesEnum jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", jobTitle=" + jobTitle +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getSalary() == employee.getSalary() &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getSecondName(), employee.getSecondName()) &&
                Objects.equals(getBirthDate(), employee.getBirthDate()) &&
                Objects.equals(getHireDate(), employee.getHireDate()) &&
                getJobTitle() == employee.getJobTitle() &&
                Objects.equals(getDepartment(), employee.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getSecondName(), getBirthDate(), getHireDate(), getSalary(), getJobTitle(), getDepartment());
    }
}