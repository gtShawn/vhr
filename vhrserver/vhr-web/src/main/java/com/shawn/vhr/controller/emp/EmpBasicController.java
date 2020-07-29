package com.shawn.vhr.controller.emp;

import com.shawn.vhr.model.*;
import com.shawn.vhr.service.*;
import utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author :shawn
 * @create :2020-07-15 23:09:00
 */
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    NationService nationService;

    @Autowired
    JobLevelService jobLevelService;

    @Autowired
    PoliticsstatusService politicsstatusService;

    @Autowired
    PositionService positionService;

    @Autowired
    DepartMentService departMentService;

    @GetMapping("/")
    public RespPageBean getEmpBasicByPage(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer size,Employee employee,
                                          Date[] beginDateScope){
        return employeeService.getEmpBasicByPage(page,size,employee,beginDateScope);
    }

    @PostMapping("/")
    public RespBean addEmpBasic(@RequestBody Employee employee){
        if (employeeService.addEmpBasic(employee)==1){
            return RespBean.ok("添加成功");
        }
            return RespBean.error("添加失败");
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations(){
        return nationService.getAllNations();
    }

    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus()
    {
        return politicsstatusService.getAllPoliticsstatus();
    }

    @GetMapping("/joblevel")
    public  List<JobLevel> getAllJobLevel(){
        return jobLevelService.getAllJobLevel();
    }

    @GetMapping("/position")
    public List<Position> getAllPosition(){
        return positionService.getAllPosition();
    }

    @GetMapping("/maxWorkID")
    public RespBean maxWorkID(){
        RespBean respBean = RespBean.build().setStatus(200).setObj(String.format("%08d",employeeService.maxWorkID()+1));
        return respBean;
    }

    @GetMapping("/department")
    public List<Department> getAllDepartments(){
        return departMentService.getAllDepartmentsByParentId(-1);
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpByEid(@PathVariable Integer id){
        if (employeeService.deleteEmpByEid(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee employee){
        if (employeeService.updateEmp(employee)==1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData(){
        List<Employee> list = (List<Employee>) employeeService.getEmpBasicByPage(null, null, null,null).getData();
        return POIUtils.employee2Excel(list);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.excel2Employee(file,nationService.getAllNations(),politicsstatusService.getAllPoliticsstatus(),
                departMentService.getAllDepartmentsWithOutChildren(),positionService.getAllPosition(),jobLevelService.getAllJobLevel());
        if (employeeService.addEmps(list)==list.size()){
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }
}
