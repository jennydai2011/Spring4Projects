package com.jdai.shangyitong;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jdai.shangyitong.entity.User;
import com.jdai.shangyitong.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ShangyitongApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelect(){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        //queryWrapper.ge("age", 21);
        //queryWrapper.eq("name", "Tom");
        //queryWrapper.between("age", 21, 25);
        queryWrapper.like("name", "l");
        List list = userMapper.selectList(queryWrapper);
        System.out.println(list);

    }
    @Test
    public void testeDeleteById(){
        int rows = userMapper.deleteById(1472400236415430657L);
        //also support deleteBatchIds, deleteByMap
        System.out.println(rows);

    }
    @Test
    public void testSelectPage(){
        Page<User> page = new Page<User>(1, 3);
        Page<User> userPage = userMapper.selectPage(page, null);
        long pages = userPage.getPages();
        long current = userPage.getCurrent();
        long total = userPage.getTotal();
        boolean hasNext = userPage.hasNext();
        boolean hasPrevious = userPage.hasPrevious();

        System.out.println(pages);
        System.out.println(current);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);


    }
    @Test
    public void testSelect2(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", "20");
        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);
    }
    @Test
    public void testSelect1(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }
    //测试乐观锁
    @Test
    public void testOptimisticLocker(){
        //1.根据id 做查询
        User user = userMapper.selectById(1472616929964449794L);
        //2.修改
        user.setName("lisi2");
        //不需要手动修改version, myBatisPlus 的OptimisticLockerInterceptor自动处理
        userMapper.updateById(user);
    }

    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testAdd() {
        User user = new User();
        user.setName("lisi");
        user.setAge(20);
        user.setEmail("lisi@baomidou.com");

        int insert= userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1472400236415430657L);
        user.setName("lucy32");

        int count= userMapper.updateById(user);
        System.out.println(count);
    }
//    @Test
//    void contextLoads() {
//    }

}
