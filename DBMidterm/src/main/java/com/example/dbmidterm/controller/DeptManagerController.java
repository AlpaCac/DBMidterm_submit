package com.example.dbmidterm.controller;

import com.example.dbmidterm.dao.DeptManagerDao;
import com.example.dbmidterm.pojo.Department;
import com.example.dbmidterm.pojo.DeptManager;
import com.example.dbmidterm.pojo.pojolist.DeptManagerList;
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
    public DeptManager add(@RequestBody DeptManagerList deptManagers){
        List<DeptManager> rows = deptManagers.getRows();
        for(DeptManager deptManager : rows) {
            deptManagerService.add(deptManager);
        }
        return null;
    }

    @PutMapping
    public DeptManager update(@RequestBody DeptManager deptManager){
        deptManagerService.update(deptManager);
        return null;
    }

    @DeleteMapping
    public DeptManager remove(@RequestParam Integer empNo,@RequestParam String deptNo){
        deptManagerService.remove(empNo, deptNo);
        return null;
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
