package com.example.dbmidterm.dao;

import com.example.dbmidterm.pojo.Department;
import com.example.dbmidterm.pojo.Title;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface TitleDao {
    @Insert("<script>" +
            "INSERT INTO titles" +
            "   (emp_no,title,from_date,to_date)" +
            "   VALUES" +
            "   <foreach collection = 'list' item='title' separator =','>" +
            "       (#{title.empNo},#{title.title},#{title.fromDate},#{title.toDate})" +
            "   </foreach>" +
            "</script>")
    public void addAll(@Param("list") List<Title> titles);
    @Insert("INSERT INTO titles (emp_no,title,from_date,to_date) VALUES (#{empNo},#{title},#{fromDate},#{toDate})")
    public void add(Title title);

    @Update("UPDATE titles SET to_date=#{toDate} WHERE emp_no=#{empNo} AND title=#{title} AND from_date=#{fromDate}")
    public void update(Title title);

    @Delete("DELETE FROM titles WHERE emp_no=#{empNo} AND title=#{title} AND from_date=#{fromDate}")
    public void remove(Integer empNo, String title, LocalDate fromDate);

    @Select("SELECT * FROM titles WHERE emp_no=#{empNo} AND title=#{title} AND from_date=#{fromDate}")
    public Title get(Integer empNo, String title, LocalDate fromDate);
}
