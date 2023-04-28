package com.example.dbmidterm.pojo;

import java.time.LocalDate;

public class DeptManagerTitle {
    private Integer empNo;
    private LocalDate fromDate;
    private LocalDate toDate;

    public DeptManagerTitle() {
    }

    public DeptManagerTitle(Integer empNo, LocalDate fromDate, LocalDate toDate) {
        this.empNo = empNo;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "DeptManagerTitle{" +
                "empNo=" + empNo +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
