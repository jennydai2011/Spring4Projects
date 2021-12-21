package com.jdai.shangyitong.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @TableId(type = IdType.ASSIGN_ID) //19位整数
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT) //自动填充
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) //自动填充
    private Date updateTime;

    @Version //乐观锁
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic
    private Integer deleted;
}
