package com.example.dbmidterm.service;

import com.example.dbmidterm.dao.EmployeeDao;
import com.example.dbmidterm.pojo.Department;
import com.example.dbmidterm.pojo.Employee;
import com.opencsv.CSVReader;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void add(Employee employee){
        employeeDao.add(employee);
    }

    public void update(Employee employee){
        employeeDao.update(employee);
    }

    public void remove(Integer empNo){
        employeeDao.remove(empNo);
    }

    public Employee getByEmpNo(Integer empNo){
        return employeeDao.getByEmpNo(empNo);
    }

    public Employee getByFirstName(String firstName){
        return employeeDao.getByFirstName(firstName);
    }

    public void importCsvData(String filePath) {
        System.out.println("filePath: ("+filePath+")");
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] headers = reader.readNext(); // 读取CSV文件头
            List<Employee> employees = new ArrayList<>();
            String[] line;
            long count = 0;
            while ((line = reader.readNext()) != null) {
                Employee employee = new Employee();
                employee.setEmpNo(Integer.parseInt(line[0]));
                employee.setBirthDate(LocalDate.parse(line[1]));
                employee.setFirstName(line[2]);
                employee.setLastName(line[3]);
                employee.setGender(line[4]);
                employee.setHireDate(LocalDate.parse(line[5]));
                employees.add(employee);
                count++;
                if (count % 1000 == 0) {
                    employeeDao.addAll(employees); // 每1000条数据入库一次
                    employees.clear();
                }
            }
            if (!employees.isEmpty()) {
                employeeDao.addAll(employees); // 处理剩余数据
            }
        } catch (IOException e) {
            throw new RuntimeException("导入CSV数据失败", e);
        }
    }
}
