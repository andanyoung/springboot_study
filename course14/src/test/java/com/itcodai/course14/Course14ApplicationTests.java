package com.itcodai.course14;

import com.alibaba.fastjson.JSON;
import com.itcodai.course14.entity.User;
import com.itcodai.course14.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Course14ApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(Course14ApplicationTests.class);

	@Resource
	private RedisService redisService;

	@Test
	public void contextLoads() {
        //测试redis的string类型
        redisService.setString("weichat","程序员私房菜");
        logger.info("我的微信公众号为：{}", redisService.getString("weichat"));

        // 如果是个实体，我们可以使用json工具转成json字符串，
        User user = new User("CSDN", "123456");
        redisService.setString("userInfo", JSON.toJSONString(user));
        logger.info("用户信息：{}", redisService.getString("userInfo"));


        //测试redis的hash类型
        redisService.setHash("user","name", JSON.toJSONString(user));
        logger.info("用户姓名：{}", redisService.getHash("user","name"));

        //测试redis的list类型
        redisService.setList("list", "football");
        redisService.setList("list", "basketball");
        List<String> valList = redisService.getList("list",0,-1);
        for(String value :valList){
            logger.info("list中有：{}", value);
        }
        //测试设置key失效时间
//        redisService.setTimeOut("CSDN", 9);
        //让当前线程休眠10秒
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        logger.info("CSDN：", redisService.getString("CSDN"));
	}

}
