package com.example.dbmidterm.service;

import com.example.dbmidterm.dao.DeptManagerDao;
import com.example.dbmidterm.pojo.Department;
import com.example.dbmidterm.pojo.DeptManager;
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
public class DeptManagerService {
    @Autowired
    private DeptManagerDao deptManagerDao;

    public void add(DeptManager deptManager){
        deptManagerDao.add(deptManager);
    }

    public void update(DeptManager deptManager){
        deptManagerDao.update(deptManager);
    }

    public void remove(Integer empNo,String deptNo){
        deptManagerDao.remove(empNo, deptNo);
    }

    public DeptManager get(Integer empNo,String deptNo){
        return deptManagerDao.get(empNo, deptNo);
    }

    public void importCsvData(String filePath) {
        System.out.println("filePath: ("+filePath+")");
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] headers = reader.readNext(); // 读取CSV文件头
            List<DeptManager> deptManagers = new ArrayList<>();
            String[] line;
            long count = 0;
            while ((line = reader.readNext()) != null) {
                DeptManager deptManager = new DeptManager();
                deptManager.setEmpNo(Integer.parseInt(line[0]));
                deptManager.setDeptNo(line[1]);
                deptManager.setFromDate(LocalDate.parse(line[2]));
                deptManager.setToDate(LocalDate.parse(line[3]));
                deptManagers.add(deptManager);
                count++;
                if (count % 1000 == 0) {
                    deptManagerDao.addAll(deptManagers); // 每1000条数据入库一次
                    deptManagers.clear();
                }
            }
            if (!deptManagers.isEmpty()) {
                deptManagerDao.addAll(deptManagers); // 处理剩余数据
            }
        } catch (IOException e) {
            throw new RuntimeException("导入CSV数据失败", e);
        }
    }
}
