package com.employee.builder;

import com.employee.builder.util.ContentUtil;
import com.employee.model.Employee;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class EmployeeBuilder {

    public EmployeeBuilder build() {
        JSONArray jsonArray = new JSONArray
            (ContentUtil.readContent("employee-meta-data.json"));

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String name = jsonObject.getString("name");
            double salary = jsonObject.getDouble("salary");

            employees.add(new Employee(name, salary));
        }

        return this;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    private final List<Employee> employees =
        new ArrayList<>();

}
