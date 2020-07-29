package com.shawn.vhr.service;

import com.shawn.vhr.mapper.HrMapper;
import com.shawn.vhr.mapper.HrRoleMapper;
import com.shawn.vhr.model.Hr;
import com.shawn.vhr.model.RespPageBean;
import utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static utils.HrUtils.getCurrentHr;

/**
 * @author :shawn
 * @create :2020-07-01 10:06:00
 */
@Service
public class HrService implements UserDetailsService{

    @Autowired
    HrMapper hrMapper;

    @Autowired
    HrRoleMapper hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr =  hrMapper.loadUserByUsername(username);
        if (hr==null)
        {
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(String keywords) {
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRole(hrid, rids) == rids.length;
    }

    public Integer delHr(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

}
