package com.example.dbmidterm.pojo.pojolist;

import com.example.dbmidterm.pojo.Department;
import com.example.dbmidterm.pojo.DeptEmp;

import java.util.List;

public class DeptEmpList {
    public List<DeptEmp> rows;

    public DeptEmpList() {
    }

    public DeptEmpList(List<DeptEmp> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DeptEmpList{" +
                "rows=" + rows +
                '}';
    }

    public List<DeptEmp> getRows() {
        return rows;
    }

    public void setRows(List<DeptEmp> rows) {
        this.rows = rows;
    }
}
