package com.shawn.vhr.service;

import com.shawn.vhr.mapper.DepartmentMapper;
import com.shawn.vhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :shawn
 * @create :2020-07-14 20:11:00
 */
@Service
public class DepartMentService {

    @Autowired
    DepartmentMapper departmentMapper;


    public List<Department> getAllDepartmentsByParentId(int i) {
        return departmentMapper.getAllDepartmentsByParentId(i);
    }


    public void addDep(Department department) {
        department.setEnabled(true);
        departmentMapper.addDep(department);
    }


    public void deleteDepById(Department department) {
        departmentMapper.deleteDepById(department);
    }

    public List<Department> getAllDepartmentsWithOutChildren() {
        return departmentMapper.getAllDepartmentsWithOutChildren();

    }
}
