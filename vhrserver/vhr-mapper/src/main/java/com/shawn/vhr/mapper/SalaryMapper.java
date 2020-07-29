package com.shawn.vhr.mapper;

import com.shawn.vhr.model.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    List<Salary> getAllSalaryByPage(@Param("page") Integer page, @Param("size") Integer size);

    Integer getAllSalaryCount();

    List<Salary> getAllSalary();

}