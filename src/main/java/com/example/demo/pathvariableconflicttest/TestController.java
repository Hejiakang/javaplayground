package com.example.demo.pathvariableconflicttest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 本类中两个路径不会冲突，说明路径spring mvc的路径参数中不能带有"/"
 * /beacon/1 走test1
 * /beacon/1/deployment 走test2
 * /beacon/1/2/deployment 404
 * 推测spring内部是通过"/"分割查找路径参数的
 * @author HaoKangKang healthhealthgood@gmail.com 2020-09-08 10:51
 **/
@RestController
public class TestController {
    @GetMapping("/beacon/{id}")
    public String test1(@PathVariable String id){
        return "short " + id;
    }

    @GetMapping("/beacon/{id}/deployment")
    public String test2(@PathVariable String id){
        return "long " + id;
    }
}
