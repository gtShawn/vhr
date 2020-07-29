package com.shawn.vhr.exception;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.shawn.vhr.model.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author :shawn
 * @create :2020-07-07 10:11:00
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
    public RespBean mySQLIntegrityConstraintViolationException()
    {
        return RespBean.error("该数据有关联数据，操作失败");
    }
}
