package com.shawn.vhr.controller.salary;

import com.shawn.vhr.model.RespBean;
import com.shawn.vhr.model.RespPageBean;
import com.shawn.vhr.model.Salary;
import com.shawn.vhr.service.EmployeeService;
import com.shawn.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :shawn
 * @create :2020-07-22 09:40:00
 */
@RestController
@RequestMapping("/sal/sobcfg")
public class SobConfigController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getAllSobConfigByPage(@RequestParam(defaultValue = "1")Integer page,
                                              @RequestParam(defaultValue = "10")Integer size){
        return employeeService.getAllSobConfigByPage(page,size);
    }

    @GetMapping("/salary")
    public List<Salary> getAllSalary(){
        return salaryService.getAllSalary();
    }

    @PutMapping("/")
    public RespBean updateEmployeeSalaryById(Integer eid,Integer sid){
        Integer result = employeeService.updateEmployeeSalaryById(eid, sid);
        if (result ==1||result==2){
            return RespBean.ok("修改成功");
        }
            return RespBean.error("修改失败");
    }
}
