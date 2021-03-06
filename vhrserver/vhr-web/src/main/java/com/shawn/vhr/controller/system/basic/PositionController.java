package com.shawn.vhr.controller.system.basic;

/**
 * @author :shawn
 * @create :2020-07-06 23:18:00
 */

import com.shawn.vhr.model.Position;
import com.shawn.vhr.model.RespBean;
import com.shawn.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;
    @GetMapping("/")
    public List<Position> getAllPosition()
    {
        return positionService.getAllPosition();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position)
    {
        if (positionService.addPosition(position)==1)
        {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position)
    {
        if (positionService.updatePosition(position)==1)
        {
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @DeleteMapping("/{id}")
    public RespBean delPositionById(@PathVariable Integer id)
    {
        if (positionService.delPositionById(id)==1)
        {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean delPositionByIds(Integer[] ids)
    {
        if (positionService.delPositionByIds(ids)==ids.length)
        {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
