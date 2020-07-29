package com.shawn.vhr.service;

import com.shawn.vhr.mapper.PositionMapper;
import com.shawn.vhr.model.Position;
import com.shawn.vhr.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author :shawn
 * @create :2020-07-06 23:20:00
 */
@Service
public class PositionService {

    @Autowired
    PositionMapper positionMapper;

    public List<Position> getAllPosition() {
        return positionMapper.getAllPosition();
    }


    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer delPositionById(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer delPositionByIds(Integer[] ids) {
        return positionMapper.deletePositionByIds(ids);
    }
}
