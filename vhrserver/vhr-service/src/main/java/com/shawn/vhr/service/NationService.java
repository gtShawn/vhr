package com.shawn.vhr.service;

import com.shawn.vhr.mapper.NationMapper;
import com.shawn.vhr.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :shawn
 * @create :2020-07-16 15:55:00
 */
@Service
public class NationService {
    @Autowired
    NationMapper nationMapper;
    public List<Nation> getAllNations() {

        return  nationMapper.getAllNations();
    }
}
