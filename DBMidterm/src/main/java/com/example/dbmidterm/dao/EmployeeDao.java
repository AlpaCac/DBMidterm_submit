package com.example.dbmidterm.dao;

import com.example.dbmidterm.pojo.Department;
import com.example.dbmidterm.pojo.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeDao {
    @Insert("<script>" +
            "INSERT INTO employees" +
            "   (emp_no, birth_date, first_name, last_name, gender, hire_date)" +
            "   VALUES" +
            "   <foreach collection = 'list' item='employee' separator =','>" +
            "       (#{employee.empNo},#{employee.birthDate},#{employee.firstName},#{employee.lastName},#{employee.gender},#{employee.hireDate})" +
            "   </foreach>" +
            "</script>")
    public void addAll(@Param("list") List<Employee> employees);

    @Insert("INSERT INTO employees (emp_no, birth_date, first_name, last_name, gender, hire_date) " +
            "VALUES (#{empNo},#{birthDate},#{firstName},#{lastName},#{gender},#{hireDate})")
    public void add(Employee employee);

    @Update("UPDATE employees SET birth_date=#{birthDate},first_name=#{firstName}," +
            "last_name=#{lastName},gender=#{gender},hire_date=#{hireDate} WHERE emp_no=#{empNo}")
    public void update(Employee employee);

    @Delete("DELETE FROM employees WHERE emp_no=#{empNo}")
    public void remove(Integer empNo);

    @Select("SELECT * FROM employees WHERE emp_no=#{empNo}")
    public Employee getByEmpNo(Integer empNo);

    @Select("SELECT * FROM employees WHERE first_name=#{firstName}")
    public Employee getByFirstName(String firstName);
}
