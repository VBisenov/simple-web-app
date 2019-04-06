package Servlets;

import DAO.Factory.DAOFactory;
import ObjectModel.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "helloWorld", urlPatterns = "/getemployees")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Employee> employees = (ArrayList<Employee>) DAOFactory.getEmployeeDAO().getEmployees();
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>Employees: { </h2> \n");
        for (Employee employee: employees){
            sb.append("<h2> Employee: { </h2>");
            sb.append("<h2> firstName: ").append(employee.getFirstName()).append("</h2>");
            sb.append("<h2> secondName: ").append(employee.getSecondName()).append("</h2>");
            sb.append("<h2> jobTitle: ").append(employee.getJobTitle()).append("</h2>");
            sb.append("<h2> salary: ").append(employee.getSalary()).append("</h2>");
            sb.append("<h2> } </h2>");
        }
        sb.append("\n<h2>}</h2>");
        String result = sb.toString();
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.write("<h1>"+result+"</h1>");
    }
}
