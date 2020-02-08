package com.online.edu.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.eduservice.entity.EduTeacher;
import com.online.edu.eduservice.entity.TeaQuery;
import com.online.edu.eduservice.mapper.EduTeacherMapper;
import com.online.edu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-01-08
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
    @Autowired
    private EduTeacherMapper eduTeacherMapper;
    public List<EduTeacher> getAllTea(){
        List<EduTeacher> eduTeachers = eduTeacherMapper.selectList(null);
        return  eduTeachers;

    }

    @Override
    public void getTeaPage(Page<EduTeacher> pages) {
        eduTeacherMapper.selectPage(pages,null);
    }

    @Override
    public void getByLi(Page<EduTeacher> pages, TeaQuery teaQuery) {
        String name = teaQuery.getName();
        String time = teaQuery.getGmtCreate();
        if(StringUtils.isEmpty(name)){
            eduTeacherMapper.selectPage(pages,null);
        }
        //判断条件值是否有，如果有拼接条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.like("name",name);
       if(!StringUtils.isEmpty(time)){
           wrapper.gt("gmt_create",time);
       }

        eduTeacherMapper.selectPage(pages,wrapper);
    }

    @Override
    public EduTeacher getTeaById(String id) {
        return eduTeacherMapper.selectById(id);
    }

    @Override
    public int insertTea(EduTeacher eduTeacher) {
        return eduTeacherMapper.insert(eduTeacher);
    }

}
