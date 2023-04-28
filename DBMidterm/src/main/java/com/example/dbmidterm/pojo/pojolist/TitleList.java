package com.example.dbmidterm.pojo.pojolist;

import com.example.dbmidterm.pojo.DeptManager;
import com.example.dbmidterm.pojo.Employee;
import com.example.dbmidterm.pojo.Title;

import java.util.List;

public class TitleList {
    public List<Title> rows;

    public TitleList() {
    }

    public TitleList(List<Title> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "TitleList{" +
                "rows=" + rows +
                '}';
    }

    public List<Title> getRows() {
        return rows;
    }

    public void setRows(List<Title> rows) {
        this.rows = rows;
    }
}
