package com.example.dbmidterm.controller;

import com.example.dbmidterm.pojo.Department;
import com.example.dbmidterm.pojo.pojolist.DepartmentList;
import com.example.dbmidterm.pojo.pojolist.DeptManagerList;
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
    public Department add(@RequestBody DepartmentList departments){
        List<Department> rows = departments.getRows();
        for(Department department : rows){
            departmentService.add(department);
        }
        return null;
    }

    @PutMapping
    public Department update(@RequestBody Department department){
        departmentService.update(department);
        return null;
    }

    @DeleteMapping
    public Department remove(@RequestParam String deptNo){
        departmentService.remove(deptNo);
        return null;
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
