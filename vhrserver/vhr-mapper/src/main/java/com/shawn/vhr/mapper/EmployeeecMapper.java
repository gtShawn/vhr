package com.shawn.vhr.mapper;

import com.shawn.vhr.model.Employee;
import com.shawn.vhr.model.Employeeec;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeec record);

    int insertSelective(Employeeec record);

    Employeeec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeec record);

    int updateByPrimaryKey(Employeeec record);

}