package com.jdai.shangyitong.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * 自动填充
 * 1. 表有字段
 * 2. entity class add @TableField(fill = FieldFill.INSERT) or @TableField(fill = FieldFill.INSERT_UPDATE)
 * 3. add interface implements MetaObjectHandler, implement insertFill, updateFill method
*/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("version", 1, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
