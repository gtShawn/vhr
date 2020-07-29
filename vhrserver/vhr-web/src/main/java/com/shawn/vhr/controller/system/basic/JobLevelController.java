package com.shawn.vhr.controller.system.basic;

import com.shawn.vhr.model.JobLevel;
import com.shawn.vhr.model.RespBean;
import com.shawn.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :shawn
 * @create :2020-07-07 14:30:00
 */
@RestController
@RequestMapping("/system/basic/job")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<JobLevel> getAllJobLevel()
    {
        return jobLevelService.getAllJobLevel();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel)
    {
        if (jobLevelService.addJobLevel(jobLevel)==1)
        {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel)
    {
        if (jobLevelService.updateJobLevel(jobLevel)==1)
        {
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @DeleteMapping("/{id}")
    public RespBean delJobLevel(@PathVariable Integer id)
    {
        if (jobLevelService.delJobLevel(id)==1)
        {
            return RespBean.ok("删除成功");
        }

        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean delJobLevels(Integer[] ids)
    {
        if (jobLevelService.delJobLevels(ids)==ids.length)
        {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
