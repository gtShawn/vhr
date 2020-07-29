package com.shawn.vhr.service;

import com.shawn.vhr.mapper.RoleMapper;
import com.shawn.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :shawn
 * @create :2020-07-13 22:06:00
 */
@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }


    public Integer addRole(Role role) {
        if (role.getName().startsWith("ROLE_"))
        {
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.insertSelective(role);
    }

    public Integer deleteRoleByRid(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }
}
