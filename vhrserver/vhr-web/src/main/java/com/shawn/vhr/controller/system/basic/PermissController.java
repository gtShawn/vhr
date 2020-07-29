package com.shawn.vhr.controller.system.basic;

import com.shawn.vhr.model.Menu;
import com.shawn.vhr.model.RespBean;
import com.shawn.vhr.model.Role;
import com.shawn.vhr.service.MenuService;
import com.shawn.vhr.service.RoleService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :shawn
 * @create :2020-07-13 22:02:00
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles()
    {
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus()
    {
        return menuService.getAllMenus();
    }

    @GetMapping("/mid/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid)
    {
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer [] mids)
    {
        if (menuService.updateMenuRole(rid,mids)){
            return RespBean.ok("更新成功");
        }else {
            return RespBean.error("更新失败");
        }
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if (roleService.addRole(role)==1){
            return  RespBean.ok("添加成功");
        }
            return  RespBean.error("添加失败");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid) {
        if (roleService.deleteRoleByRid(rid)==1){
            return RespBean.ok("删除成功");
        }
            return RespBean.error("删除失败");
    }
}
