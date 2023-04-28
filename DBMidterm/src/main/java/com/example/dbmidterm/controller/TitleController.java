package com.example.dbmidterm.controller;

import com.example.dbmidterm.dao.TitleDao;
import com.example.dbmidterm.pojo.Title;
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
    public void add(@RequestBody List<Title> titles){
        for(Title title : titles) {
            titleService.add(title);
        }
    }

    @PutMapping
    public void update(@RequestBody Title title){
        titleService.update(title);
    }

    @DeleteMapping
    public void remove(@RequestParam Integer empNo,@RequestParam  String title, @RequestParam LocalDate fromDate){
        titleService.remove(empNo, title, fromDate);
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
