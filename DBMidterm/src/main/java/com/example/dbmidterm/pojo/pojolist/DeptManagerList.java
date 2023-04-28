package com.example.dbmidterm.pojo.pojolist;

import com.example.dbmidterm.pojo.DeptManager;

import java.util.List;

public class DeptManagerList {
    public List<DeptManager> rows;

    public DeptManagerList() {
    }

    public DeptManagerList(List<DeptManager> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DeptManagerList{" +
                "rows=" + rows +
                '}';
    }

    public List<DeptManager> getRows() {
        return rows;
    }

    public void setRows(List<DeptManager> rows) {
        this.rows = rows;
    }
}
