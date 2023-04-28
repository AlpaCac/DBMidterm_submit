package com.example.dbmidterm.pojo.pojolist;

import com.example.dbmidterm.pojo.Department;

import java.util.List;

public class DepartmentList {
    public List<Department> rows;

    public DepartmentList() {
    }

    public DepartmentList(List<Department> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DepartmentList{" +
                "rows=" + rows +
                '}';
    }

    public List<Department> getRows() {
        return rows;
    }

    public void setRows(List<Department> rows) {
        this.rows = rows;
    }
}
