package com.employee;

import com.employee.builder.DepartmentBuilder;
import com.employee.builder.EmployeeBuilder;
import com.employee.model.Department;
import com.employee.model.Employee;

/**
 * @author Albert Gomes Cabral
 */
public class Main {

    public static void main(String[] args) {
        for (Department department :
                new DepartmentBuilder().build().getDepartments()) {

            EmployeeBuilder employeeBuilder = new EmployeeBuilder().build();

            for (Employee employee : employeeBuilder.getEmployees()) {
                department.addEmployee(employee);
            }

            System.out.println(department);

        }
    }

}
