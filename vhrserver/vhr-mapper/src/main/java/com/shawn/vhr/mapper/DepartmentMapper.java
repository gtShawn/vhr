package com.shawn.vhr.mapper;

import com.shawn.vhr.model.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(int pid);

    void addDep(Department department);


    void deleteDepById(Department department);

    List<Department> getAllDepartmentsWithOutChildren();
}