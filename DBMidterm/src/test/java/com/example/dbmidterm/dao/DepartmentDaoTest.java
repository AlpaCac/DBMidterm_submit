package com.example.dbmidterm.dao;

import com.example.dbmidterm.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DepartmentDaoTest {
    @Autowired
    private DepartmentDao departmentDao;
    @Test
    public void addAllTest(){
        List<Department> departmentList = new ArrayList<>();
        Department department1 = new Department("0001","0001");
        Department department2 = new Department("0002","0002");
        departmentList.add(department1);
        departmentList.add(department2);
        departmentDao.addAll(departmentList);
    }
}
