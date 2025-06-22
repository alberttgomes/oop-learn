package com.employee.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Albert Gomes Cabral
 */
public class Department {

    public Department(String name, int payDay) {
        this.name = name;
        this.payDay = payDay;
    }
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    public void setAddress(String name, String phone) {
        this._address = new Address(name, phone);
    }

    public int getPayDay() {
        return payDay;
    }

    public void setPayDay(int payDay) {
        this.payDay = payDay;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double payroll() {
        double totalPay = 0.0;

        for (Employee employee : employees) {
            totalPay += employee.getSalary();
        }

        return totalPay;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Department Name: ").append(name).append("\n");
        sb.append("Pay Day: ").append(payDay).append("\n");
        sb.append("Email: ").append(_address.email).append("\n");
        sb.append("Phone: ").append(_address.phone).append("\n");
        sb.append("How much employees the department have: ");
        sb.append(employees.size()).append("\n");

        int index = 1;

        for (Employee employee : employees) {
            sb.append("data employee ").append(index).append(":").append("\n\t");
            sb.append(employee).append("\n");
            index++;
        }

        sb.append("Payroll: ").append("\n\t");
        sb.append("department ").append(name).append(" ");
        sb.append("R$ ").append(payroll()).append("\n\t");
        sb.append("payment made every ").append(payDay).append(" day");
        sb.append("\n\t").append("employees:");

        for (Employee employee : employees) {
            sb.append(employee.getName()).append("\n\t");
        }

        sb.append("\n");
        sb.append("please, any doubts contact us: ").append(_address.email);
        sb.append("\n");

        return sb.toString();
    }

    private Address _address;
    private int payDay;
    private String name;

    private final List<Employee> employees = new ArrayList<>();

    private static class Address {

        public Address(String email, String phone) {
            this.email = email;
            this.phone = phone;
        }

        String email;
        String phone;

    }

}
