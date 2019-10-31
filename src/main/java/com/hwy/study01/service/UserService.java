package com.hwy.study01.service;

import com.hwy.study01.aop.LogAnnotation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description server 测试类
 * @Author      yanghanwei
 * @Mail        yanghanwei@geotmt.com
 * @Date        14:53 2019-10-31
 * @Version     v1
 **/
@Component
public class UserService {

    @LogAnnotation("添加")
    public String add() {
        return "add";
    }

    @LogAnnotation("列表")
    public Map<String,String> list() {

        Map<String,String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        return map;
    }

    @LogAnnotation("更新")
    public String update() {
        return "update";
    }
}
