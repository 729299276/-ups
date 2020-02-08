package com.online.edu.eduservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiModel(value="条件对象", description="讲师条件")
public class TeaQuery {
    private String name;
    private String gmtCreate;
}
