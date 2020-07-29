package com.shawn.vhr.controller.system;

import com.shawn.vhr.model.Hr;
import com.shawn.vhr.model.RespBean;
import com.shawn.vhr.model.Role;
import com.shawn.vhr.service.HrService;
import com.shawn.vhr.service.RoleService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :shawn
 * @create :2020-07-15 10:51:00
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords)
    {
        return hrService.getAllHrs(keywords);
    }

    @DeleteMapping("/{id}")
    public RespBean delHr(@PathVariable Integer id){
        if (hrService.delHr(id)==1){
            return RespBean.ok("删除成功");
        }
            return RespBean.error("删除失败");
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr)
    {
        if (hrService.updateHr(hr)==1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles()
    {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
