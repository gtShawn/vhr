package com.shawn.vhr.controller.system.basic;

import com.shawn.vhr.model.Department;
import com.shawn.vhr.model.RespBean;
import com.shawn.vhr.service.DepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :shawn
 * @create :2020-07-14 20:08:00
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    DepartMentService departMentService;

    @GetMapping("/")
    public List<Department> getAllDepartdent()
    {
        return departMentService.getAllDepartmentsByParentId(-1);
    }

    @PostMapping("/")
    public RespBean addDep(@RequestBody Department department)
    {
        departMentService.addDep(department);
        if (department.getResult()==1){
            return RespBean.ok("添加成功",department);
        }
            return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDeptById(@PathVariable Integer id)
    {
        Department department = new Department();
        department.setId(id);
        departMentService.deleteDepById(department);
        if (department.getResult()==-2){
            return RespBean.error("该部门下有子部门，删除失败");
        }else if(department.getResult()==-1){
            return RespBean.error("该部门下员工，删除失败");
        }else if(department.getResult()==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
