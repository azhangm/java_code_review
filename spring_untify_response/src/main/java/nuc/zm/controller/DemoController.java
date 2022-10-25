package nuc.zm.controller;

import nuc.zm.exception.DemoException;
import nuc.zm.pojo.Demo;
import nuc.zm.pojo.ExceptionEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示controlle
 * 演示控制器
 *
 * @author zm
 * @date 2022/10/24
 */

@RestController
public class DemoController {

    @PostMapping("/demo")
    public Demo demo(@RequestBody Demo demo) {
//        runtime exception --> test
//        int i = 1 / 0;

//        demo exception ---> test
    throw new DemoException(1,"测试异常");


    }
}
