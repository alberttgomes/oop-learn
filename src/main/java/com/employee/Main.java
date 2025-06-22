package com.employee;

import com.employee.client.EmployeeBuilder;
import com.employee.model.Department;
import com.employee.model.Employee;

/**
 * @author Albert Gomes Cabral
 */
public class Main {

    public static void main(String[] args) {
        Department department = new Department("sales");

        department.setAddress(
            "sales@topstore.com", "+5581985563743");
        department.setPayDay(10);

        EmployeeBuilder employeeBuilder = new EmployeeBuilder().build();

        for (Employee employee : employeeBuilder.getEmployees()) {
            department.addEmployee(employee);
        }

        System.out.println(department);
    }

}
