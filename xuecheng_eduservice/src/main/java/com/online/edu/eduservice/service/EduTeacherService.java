package com.online.edu.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.online.edu.eduservice.entity.TeaQuery;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-01-08
 */
public interface EduTeacherService extends IService<EduTeacher> {
    //获取所有讲师
    List<EduTeacher> getAllTea();
    //分页查询
    void getTeaPage(Page<EduTeacher> pages);
    //分页条件查询
    void getByLi(Page<EduTeacher> pages, TeaQuery teaQuery);

    //根据id获取讲师
    EduTeacher getTeaById(String id);
    //插入讲师
    int insertTea(EduTeacher eduTeacher);
}
