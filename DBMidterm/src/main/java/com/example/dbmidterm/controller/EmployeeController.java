package com.example.dbmidterm.controller;

import com.example.dbmidterm.dao.EmployeeDao;
import com.example.dbmidterm.pojo.DeptManager;
import com.example.dbmidterm.pojo.Employee;
import com.example.dbmidterm.pojo.pojolist.EmployeeList;
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
    public Employee add(@RequestBody EmployeeList employees){
        List<Employee> rows = employees.getRows();
        for(Employee employee : rows) {
            employeeService.add(employee);
        }
        return null;
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee){
        employeeService.update(employee);
        return null;
    }

    @DeleteMapping
    public Employee remove(@RequestParam Integer empNo){
        employeeService.remove(empNo);
        return null;
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
