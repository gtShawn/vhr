package com.shawn.vhr.controller.salary;

import com.shawn.vhr.model.RespBean;
import com.shawn.vhr.model.RespPageBean;
import com.shawn.vhr.model.Salary;
import com.shawn.vhr.service.SalaryService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author :shawn
 * @create :2020-07-21 17:29:00
 */
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getAllSalaryByPage(@RequestParam(defaultValue = "1") Integer page,
                                           @RequestParam(defaultValue = "10") Integer size){
        return salaryService.getAllSalaryByPage(page,size);
    }

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary){
        if (salaryService.addSalary(salary)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean delSalary(@PathVariable Integer id){
        if (salaryService.delSalary(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @PutMapping("/")
    public RespBean updateSalary(@RequestBody Salary salary){
        if (salaryService.updateSalary(salary)==1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
}
