package com.example.dbmidterm.service;

import com.example.dbmidterm.dao.DepartmentDao;
import com.example.dbmidterm.pojo.Department;
import com.opencsv.CSVReader;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department){
        departmentDao.add(department);
    }

    public void update(Department department){
        departmentDao.update(department);
    }

    public void remove(String deptNo){
        departmentDao.remove(deptNo);
    }

    public Department get(String deptNo){
        return departmentDao.get(deptNo);
    }

    public void importCsvData(String filePath) {
        System.out.println("filePath: ("+filePath+")");
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] headers = reader.readNext(); // 读取CSV文件头
            List<Department> departments = new ArrayList<>();
            String[] line;
            long count = 0;
            while ((line = reader.readNext()) != null) {
                Department department = new Department();
                department.setDeptNo(line[0]);
                department.setDeptName(line[1]);
                departments.add(department);
                count++;
                if (count % 1000 == 0) {
                    departmentDao.addAll(departments); // 每1000条数据入库一次
                    departments.clear();
                }
            }
            if (!departments.isEmpty()) {
                departmentDao.addAll(departments); // 处理剩余数据
            }
        } catch (IOException e) {
            throw new RuntimeException("导入CSV数据失败", e);
        }
    }
}
