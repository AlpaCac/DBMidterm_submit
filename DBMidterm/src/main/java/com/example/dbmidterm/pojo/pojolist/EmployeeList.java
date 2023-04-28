package com.example.dbmidterm.pojo.pojolist;

import com.example.dbmidterm.pojo.DeptManager;
import com.example.dbmidterm.pojo.Employee;

import java.util.List;

public class EmployeeList {
    public List<Employee> rows;

    public EmployeeList() {
    }

    public EmployeeList(List<Employee> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "EmployeeList{" +
                "rows=" + rows +
                '}';
    }

    public List<Employee> getRows() {
        return rows;
    }

    public void setRows(List<Employee> rows) {
        this.rows = rows;
    }
}
