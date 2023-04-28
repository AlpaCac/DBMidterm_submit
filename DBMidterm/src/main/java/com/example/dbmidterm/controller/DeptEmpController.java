package com.example.dbmidterm.controller;

import com.example.dbmidterm.pojo.Department;
import com.example.dbmidterm.pojo.DeptEmp;
import com.example.dbmidterm.service.DeptEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dept_emp")
public class DeptEmpController {
    @Autowired
    private DeptEmpService deptEmpService;

    @PostMapping
    public void add(@RequestBody List<DeptEmp> deptEmps){
        for(DeptEmp deptEmp : deptEmps){
            deptEmpService.add(deptEmp);
        }
    }

    @PutMapping
    public void update(@RequestBody DeptEmp deptEmp){
        deptEmpService.update(deptEmp);
    }

    @DeleteMapping
    public void remove(@RequestParam Integer empNo,@RequestParam String deptNo){
        deptEmpService.remove(empNo, deptNo);
    }

    @GetMapping
    public DeptEmp get(@RequestParam Integer empNo,@RequestParam String deptNo){
        return deptEmpService.get(empNo, deptNo);
    }

    @PostMapping("/insertCsv")
    public void insertCsv(@RequestParam String filePath) {
        deptEmpService.importCsvData(filePath);
    }
}
