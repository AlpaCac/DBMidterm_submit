package com.example.dbmidterm.controller;

import com.example.dbmidterm.dao.TitleDao;
import com.example.dbmidterm.pojo.Employee;
import com.example.dbmidterm.pojo.Title;
import com.example.dbmidterm.pojo.pojolist.TitleList;
import com.example.dbmidterm.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/titles")
public class TitleController {
    @Autowired
    private TitleService titleService;

    @PostMapping
    public Title add(@RequestBody TitleList titles){
        List<Title> rows = titles.getRows();
        for(Title title : rows) {
            titleService.add(title);
        }
        return null;
    }

    @PutMapping
    public Title update(@RequestBody Title title){
        titleService.update(title);
        return null;
    }

    @DeleteMapping
    public Title remove(@RequestParam Integer empNo,@RequestParam  String title, @RequestParam LocalDate fromDate){
        titleService.remove(empNo, title, fromDate);
        return null;
    }

    @GetMapping
    public Title get(@RequestParam Integer empNo, @RequestParam String title, @RequestParam LocalDate fromDate){
        return titleService.get(empNo, title, fromDate);
    }

    @PostMapping("/insertCsv")
    public void insertCsv(@RequestParam String filePath) {
        titleService.importCsvData(filePath);
    }
}
