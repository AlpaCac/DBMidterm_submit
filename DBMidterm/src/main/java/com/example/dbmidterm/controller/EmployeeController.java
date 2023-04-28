package com.example.dbmidterm.controller;

import com.example.dbmidterm.dao.EmployeeDao;
import com.example.dbmidterm.pojo.Employee;
import com.example.dbmidterm.service.EmployeeService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void add(@RequestBody List<Employee> employees){
        for(Employee employee : employees) {
            employeeService.add(employee);
        }
    }

    @PutMapping
    public void update(@RequestBody Employee employee){
        employeeService.update(employee);
    }

    @DeleteMapping
    public void remove(@RequestParam Integer empNo){
        employeeService.remove(empNo);
    }

    @GetMapping(params = "empNo")
    public Employee getByEmpNo(@RequestParam Integer empNo){
        return employeeService.getByEmpNo(empNo);
    }

    @GetMapping(params = "firstName")
    public Employee getByFirstName(@RequestParam String firstName){
        return employeeService.getByFirstName(firstName);
    }

    @PostMapping("/insertCsv")
    public void insertCsv(@RequestParam String filePath) {
        employeeService.importCsvData(filePath);
    }
}
