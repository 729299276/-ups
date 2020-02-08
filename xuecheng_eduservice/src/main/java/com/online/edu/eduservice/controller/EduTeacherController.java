package com.online.edu.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.core.R;
import com.online.edu.eduservice.entity.EduTeacher;
import com.online.edu.eduservice.entity.TeaQuery;
import com.online.edu.eduservice.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-01-08
 */
@RestController
@Slf4j
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;
    @ApiOperation(value = "获取所有讲师列表")
    @GetMapping("/all")
    public R getAll(){
        List<EduTeacher> allTea = eduTeacherService.getAllTea();
        log.error("错误");
        int i =1/0;

        return  R.ok().data("items",allTea);
    }
    @ApiOperation(value = "根据id查询讲师")
    @GetMapping("/getById/{id}")
    public R getTeaById(String id){
        EduTeacher teacher = eduTeacherService.getTeaById(id);
        return R.ok().data("data",teacher);
    }
    @ApiOperation(value = "分页查询")
    @GetMapping("/page/{page}/{limit}")
    public R getPageList(@PathVariable Long page,@PathVariable Long limit){
        Page<EduTeacher> pages = new Page<EduTeacher>(page,limit);
        eduTeacherService.getTeaPage(pages);
        List<EduTeacher> records = pages.getRecords();
        long total = pages.getTotal();
        return R.ok().data("total",total).data("items",records);
    }

    @ApiOperation(value = "分页条件查询")
    @PostMapping("/pageli/{page}/{limit}")
    public R getPageByLimit(@PathVariable Long page, @PathVariable Long limit, @RequestBody  TeaQuery teaQuery){
        Page<EduTeacher> pages = new Page<EduTeacher>(page,limit);
        eduTeacherService.getByLi(pages,teaQuery);
        List<EduTeacher> records = pages.getRecords();
        long total = pages.getTotal();
        return R.ok().data("total",total).data("items",records);
    }
    @ApiOperation(value = "添加讲师")
    @PostMapping("/insert")
    public R insertTea(@RequestBody EduTeacher eduTeacher){
        int i = eduTeacherService.insertTea(eduTeacher);
        if(i>0){
            return  R.ok().message("插入成功！");
        }
        return R.error().message("插入失败！");
    }

}

