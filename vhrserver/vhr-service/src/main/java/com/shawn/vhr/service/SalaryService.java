package com.shawn.vhr.service;

import com.shawn.vhr.mapper.SalaryMapper;
import com.shawn.vhr.model.RespPageBean;
import com.shawn.vhr.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author :shawn
 * @create :2020-07-21 17:31:00
 */
@Service
public class SalaryService {

    @Autowired
    SalaryMapper salaryMapper;

    public RespPageBean getAllSalaryByPage(Integer page, Integer size) {
        if (page!=null&&size!=null){
            page=(page-1)*size;
        }
        List<Salary> salaryList= salaryMapper.getAllSalaryByPage(page,size);
        Integer count = salaryMapper.getAllSalaryCount();
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(salaryList);
        respPageBean.setTotal(count);
        return respPageBean;
    }

    public Integer addSalary(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryMapper.insertSelective(salary);
    }

    public Integer delSalary(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSalary(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }

    public List<Salary> getAllSalary() {
        return salaryMapper.getAllSalary();
    }

}
