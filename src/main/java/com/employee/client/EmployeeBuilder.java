package com.employee.client;

import com.employee.model.Employee;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

public class EmployeeBuilder {

    public EmployeeBuilder build() {
        JSONArray jsonArray = new JSONArray(_readContent());

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

    private String _readContent() throws RuntimeException {
        ClassLoader classLoader = getClass().getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(
                "employee-meta-data.json")) {
            return new String(
                Objects.requireNonNull(inputStream).readAllBytes());
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private final List<Employee> employees =
        new ArrayList<>();

}
