package com.shawn.vhr.controller;

import com.shawn.vhr.model.Department;
import com.shawn.vhr.model.Menu;
import com.shawn.vhr.model.RespBean;
import com.shawn.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :shawn
 * @create :2020-07-03 15:44:00
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public List<Menu> getMenusByHrId()
    {
        return menuService.getMenusByHrId();
    }

}
