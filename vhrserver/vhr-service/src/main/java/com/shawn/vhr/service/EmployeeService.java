package com.shawn.vhr.service;

import com.shawn.vhr.mapper.EmployeeMapper;
import com.shawn.vhr.mapper.EmployeeecMapper;
import com.shawn.vhr.model.Employee;
import com.shawn.vhr.model.RespPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitRetryTemplateCustomizer;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author :shawn
 * @create :2020-07-16 08:34:00
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");
    
    public RespPageBean getEmpBasicByPage(Integer page, Integer size,Employee employee,Date[] beginDataScope) {
        if (page!=null&size!=null){
            page=(page-1)*size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page,size,employee,beginDataScope);
        Long total = employeeMapper.getTotal(employee,beginDataScope);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(data);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    public Integer addEmpBasic(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        String formatEnd = yearFormat.format(endContract);
        String formatBegin = yearFormat.format(beginContract);
        double year = (Double.parseDouble(formatEnd) - Double.parseDouble(formatBegin)) * 12;
        double month = Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format((year+month)/12)));
        int result = employeeMapper.insertSelective(employee);
        if (result==1){
            Employee emp = employeeMapper.getEmployeeById(employee.getId());
            logger.info(emp.toString());
            rabbitTemplate.convertAndSend("shawn.mail.welcome",emp);
        }
        return result;
    }

    public Integer maxWorkID() {
        return employeeMapper.maxWorkID();
    }

    public Integer deleteEmpByEid(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer addEmps(List<Employee> list) {
        return employeeMapper.addEmps(list);
    }

    public RespPageBean getAllSobConfigByPage(Integer page, Integer size) {
        if (page!=null&&size!=null){
            page=(page-1)*size;
        }
        List<Employee> list = employeeMapper.getAllSobConfigByPage(page,size);
        Long total = employeeMapper.getTotal(null, null);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(list);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    public Integer updateEmployeeSalaryById(Integer eid, Integer sid) {
        return employeeMapper.updateEmployeeSalaryById(eid,sid);
    }
}
