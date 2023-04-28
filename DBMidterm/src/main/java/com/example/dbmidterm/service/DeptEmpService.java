package com.example.dbmidterm.service;

import com.example.dbmidterm.dao.DeptEmpDao;
import com.example.dbmidterm.pojo.Department;
import com.example.dbmidterm.pojo.DeptEmp;
import com.opencsv.CSVReader;
import org.apache.ibatis.annotations.Delete;
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
public class DeptEmpService {
    @Autowired
    private DeptEmpDao deptEmpDao;

    public void add(DeptEmp deptEmp){
        deptEmpDao.add(deptEmp);
    }

    public void update(DeptEmp deptEmp){
        deptEmpDao.update(deptEmp);
    }

    public void remove(Integer empNo,String deptNo){
        deptEmpDao.remove(empNo,deptNo);
    }

    public DeptEmp get(Integer empNo,String deptNo){
        return deptEmpDao.get(empNo,deptNo);
    }

    public void importCsvData(String filePath) {
        System.out.println("filePath: ("+filePath+")");
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] headers = reader.readNext(); // 读取CSV文件头
            List<DeptEmp> deptEmps = new ArrayList<>();
            String[] line;
            long count = 0;
            while ((line = reader.readNext()) != null) {
                DeptEmp deptEmp = new DeptEmp();
                deptEmp.setEmpNo(Integer.parseInt(line[0]));
                deptEmp.setDeptNo(line[1]);
                deptEmp.setFromDate(LocalDate.parse(line[2]));
                deptEmp.setToDate(LocalDate.parse(line[3]));
                deptEmps.add(deptEmp);
                count++;
                if (count % 1000 == 0) {
                    deptEmpDao.addAll(deptEmps); // 每1000条数据入库一次
                    deptEmps.clear();
                }
            }
            if (!deptEmps.isEmpty()) {
                deptEmpDao.addAll(deptEmps); // 处理剩余数据
            }
        } catch (IOException e) {
            throw new RuntimeException("导入CSV数据失败", e);
        }
    }
}
