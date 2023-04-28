package com.example.dbmidterm.controller;

import com.example.dbmidterm.dao.DeptManagerDao;
import com.example.dbmidterm.pojo.DeptManager;
import com.example.dbmidterm.service.DeptManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dept_manager")
public class DeptManagerController {
    @Autowired
    private DeptManagerService deptManagerService;

    @PostMapping
    public void add(@RequestBody List<DeptManager> deptManagers)
    {
        for(DeptManager deptManager : deptManagers) {
            deptManagerService.add(deptManager);
        }
    }

    @PutMapping
    public void update(@RequestBody DeptManager deptManager){
        deptManagerService.update(deptManager);
    }

    @DeleteMapping
    public void remove(@RequestParam Integer empNo,@RequestParam String deptNo){
        deptManagerService.remove(empNo, deptNo);
    }

    @GetMapping
    public DeptManager get(@RequestParam Integer empNo,@RequestParam String deptNo){
        return deptManagerService.get(empNo, deptNo);
    }

    @PostMapping("/insertCsv")
    public void insertCsv(@RequestParam String filePath) {
        deptManagerService.importCsvData(filePath);
    }
}
