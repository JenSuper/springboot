package com.rd.springboot;

import com.rd.entity.User;
import com.rd.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class findOneTest {

    @Autowired
    private UserService userService;

    @Test
    public void findOneTest(){
        User one = userService.findOne(8);
        Assert.assertEquals("1234",one.getPassword());
    }
}
