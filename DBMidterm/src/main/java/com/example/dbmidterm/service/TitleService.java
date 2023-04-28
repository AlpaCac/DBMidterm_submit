package com.example.dbmidterm.service;

import com.example.dbmidterm.dao.TitleDao;
import com.example.dbmidterm.pojo.Department;
import com.example.dbmidterm.pojo.Title;
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
public class TitleService {
    @Autowired
    private TitleDao titleDao;

    public void add(Title title){
        titleDao.add(title);
    }

    public void update(Title title){
        titleDao.update(title);
    }

    public void remove(Integer empNo, String title, LocalDate fromDate){
        titleDao.remove(empNo, title, fromDate);
    }

    public Title get(Integer empNo, String title, LocalDate fromDate){
        return titleDao.get(empNo, title, fromDate);
    }

    public void importCsvData(String filePath) {
        System.out.println("filePath: ("+filePath+")");
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] headers = reader.readNext(); // 读取CSV文件头
            List<Title> titles = new ArrayList<>();
            String[] line;
            long count = 0;
            while ((line = reader.readNext()) != null) {
                Title title = new Title();
                title.setEmpNo(Integer.parseInt(line[0]));
                title.setTitle(line[1]);
                title.setFromDate(LocalDate.parse(line[2]));
                title.setToDate(LocalDate.parse(line[3]));
                titles.add(title);
                count++;
                if (count % 1000 == 0) {
                    titleDao.addAll(titles); // 每1000条数据入库一次
                    titles.clear();
                }
            }
            if (!titles.isEmpty()) {
                titleDao.addAll(titles); // 处理剩余数据
            }
        } catch (IOException e) {
            throw new RuntimeException("导入CSV数据失败", e);
        }
    }
}
