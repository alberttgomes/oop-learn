package com.model;

import com.model.enums.WorkerLevels;

import java.util.*;

public class Worker {

    public Worker(
        Department department, WorkerLevels workerLevel, String name, Double baseSalary) {

        this.department = department;
        this.workerLevel = workerLevel;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public String getName() {
        return name;
    }

    public Object getWorkerLevel() {
        return workerLevel;
    }

    public String getDepartmentName() {
        return department.name();
    }

    public List<HourContract> getHourContracts() {
        return hourContracts;
    }

    public void addContract(HourContract hourContract) {
        if (Objects.nonNull(hourContract)) {
            hourContracts.add(hourContract);
        }
    }

    public double income(int month, int year) {
        double sum = baseSalary;

        Calendar calendar = Calendar.getInstance();

        for (HourContract hourContract : hourContracts) {
            calendar.setTime(hourContract.getDate());

            if (year == calendar.get(Calendar.YEAR) && month == 1 + calendar.get(Calendar.MONTH)) {
                sum += hourContract.totalValue();
            }
        }

        return sum;
    }

    public void removeContract(HourContract hourContract) {
        if (Objects.nonNull(hourContract)) {
            hourContracts.remove(hourContract);
        }
    }

    private final Double baseSalary;
    private final Department department;
    private final List<HourContract> hourContracts = new ArrayList<>();
    private final String name;
    private final WorkerLevels workerLevel;

}
