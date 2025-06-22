package com.employee.builder;

import com.employee.builder.util.ContentUtil;
import com.employee.model.Department;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class DepartmentBuilder {

    public DepartmentBuilder build() {
        JSONArray jsonArray = new JSONArray(
            ContentUtil.readContent("department-meta-data.json"));

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObj = jsonArray.getJSONObject(i);

            Department department = new Department(
                jsonObj.getString("name"), jsonObj.getInt("pay-day"));

            JSONObject jsonObjAddress = jsonObj.getJSONObject("address");

            department.setAddress(
                jsonObjAddress.getString("email"),
                jsonObjAddress.getString("phone"));

            departments.add(department);
        }

        return this;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    private final List<Department> departments = new ArrayList<>();

}
