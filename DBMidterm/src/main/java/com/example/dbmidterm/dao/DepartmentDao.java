package com.example.dbmidterm.dao;

import com.example.dbmidterm.pojo.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentDao {
    @Insert("<script>" +
            "INSERT INTO departments" +
            "   (dept_no,dept_name)" +
            "   VALUES" +
            "   <foreach collection = 'list' item='department' separator =','>" +
            "       (#{department.deptNo},#{department.deptName})" +
            "   </foreach>" +
            "</script>")
    public void addAll(@Param("list") List<Department> departments);

    @Insert("INSERT INTO departments (dept_no,dept_name) VALUES (#{deptNo},#{deptName})")
    public void add(Department department);

    @Update("UPDATE departments SET dept_name=#{deptName} WHERE dept_no=#{deptNo}")
    public void update(Department department);

    @Delete("DELETE FROM departments WHERE dept_no=#{deptNo}")
    public void remove(String deptNo);

    @Select("SELECT * FROM departments WHERE dept_no=#{deptNo}")
    public Department get(String deptNo);
}
