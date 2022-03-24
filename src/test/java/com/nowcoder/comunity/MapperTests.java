package com.nowcoder.comunity;


import com.nowcoder.comunity.dao.DiscussPostMapper;
import com.nowcoder.comunity.dao.UserMapper;
import com.nowcoder.comunity.entity.DiscussPost;
import com.nowcoder.comunity.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void testSelectUser(){
        User user=userMapper.selectById(101);
        System.out.println(user);

        user=userMapper.selectByName("liubei");
        System.out.println(user);
        user=userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user=new User();
        user.setUsername("test");
        user.setPassword("111");
        user.setSalt("aaa");
        user.setEmail("123@qq.com");
        user.setHeaderUrl("http://www.abc.com");
        user.setCreateTime(new Date());
        int rows=userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdate(){
        int rows=userMapper.updateStatus(150,1);
        System.out.println(rows);
        rows=userMapper.updateHeader(150,"www.baidu.com");
        System.out.println(rows);
        rows=userMapper.updatePassword(150,"123456789");
        System.out.println(rows);
        System.out.println(userMapper.selectById(150));
    }
    @Autowired(required = false)
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectPosts(){

        List<DiscussPost> ls=discussPostMapper.selectDiscussPosts(149,0,10);
        for (DiscussPost dp:ls){
            System.out.println(dp);
        }

        int rows=discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);

    }
}
