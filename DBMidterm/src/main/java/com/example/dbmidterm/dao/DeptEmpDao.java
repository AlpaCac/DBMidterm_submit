package com.example.dbmidterm.dao;

import com.example.dbmidterm.pojo.Department;
import com.example.dbmidterm.pojo.DeptEmp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptEmpDao {
    @Insert("<script>" +
            "INSERT INTO dept_emp" +
            "   (emp_no,dept_no,from_date,to_date)" +
            "   VALUES" +
            "   <foreach collection = 'list' item='deptEmp' separator =','>" +
            "       (#{deptEmp.empNo},#{deptEmp.deptNo},#{deptEmp.fromDate},#{deptEmp.toDate})" +
            "   </foreach>" +
            "</script>")
    public void addAll(@Param("list") List<DeptEmp> deptEmps);
    @Insert("INSERT INTO dept_emp (emp_no,dept_no,from_date,to_date) VALUES (#{empNo},#{deptNo},#{fromDate},#{toDate})")
    public void add(DeptEmp deptEmp);

    @Update("UPDATE dept_emp SET from_date=#{fromDate},to_date=#{toDate} WHERE emp_no=#{empNo} AND dept_no=#{deptNo}")
    public void update(DeptEmp deptEmp);

    @Delete("DELETE FROM dept_emp WHERE emp_no=#{empNo} AND dept_no=#{deptNo}")
    public void remove(Integer empNo,String deptNo);

    @Select("SELECT * FROM dept_emp WHERE emp_no=#{empNo} AND dept_no=#{deptNo}")
    public DeptEmp get(Integer empNo,String deptNo);
}
