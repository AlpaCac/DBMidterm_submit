package com.example.dbmidterm.dao;

import com.example.dbmidterm.pojo.Department;
import com.example.dbmidterm.pojo.DeptEmp;
import com.example.dbmidterm.pojo.DeptManager;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptManagerDao {
    @Insert("<script>" +
            "INSERT INTO dept_manager" +
            "   (emp_no,dept_no,from_date,to_date) " +
            "   VALUES" +
            "   <foreach collection = 'list' item='deptManager' separator =','>" +
            "       (#{deptManager.empNo},#{deptManager.deptNo},#{deptManager.fromDate},#{deptManager.toDate})" +
            "   </foreach>" +
            "</script>")
    public void addAll(@Param("list") List<DeptManager> deptManagers);
    @Insert("INSERT INTO dept_manager (emp_no,dept_no,from_date,to_date) VALUES (#{empNo},#{deptNo},#{fromDate},#{toDate})")
    public void add(DeptManager deptManager);

    @Update("UPDATE dept_manager SET from_date=#{fromDate},to_date=#{toDate} WHERE emp_no=#{empNo} AND dept_no=#{deptNo}")
    public void update(DeptManager deptManager);

    @Delete("DELETE FROM dept_manager WHERE emp_no=#{empNo} AND dept_no=#{deptNo}")
    public void remove(Integer empNo,String deptNo);

    @Select("SELECT * FROM dept_manager WHERE emp_no=#{empNo} AND dept_no=#{deptNo}")
    public DeptManager get(Integer empNo,String deptNo);
}
