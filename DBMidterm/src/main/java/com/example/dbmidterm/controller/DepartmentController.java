package com.example.dbmidterm.controller;

import com.example.dbmidterm.pojo.Department;
import com.example.dbmidterm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public void add(@RequestBody List<Department> departments){
        for(Department department : departments){
            departmentService.add(department);
        }
    }

    @PutMapping
    public void update(@RequestBody Department department){
        departmentService.update(department);
    }

    @DeleteMapping
    public void remove(@RequestParam String deptNo){
        departmentService.remove(deptNo);
    }

    @GetMapping
    public Department get(@RequestParam String deptNo){
        return departmentService.get(deptNo);
    }

    @PostMapping("/insertCsv")
    public void insertCsv(@RequestParam String filePath) {
        departmentService.importCsvData(filePath);
    }
}
