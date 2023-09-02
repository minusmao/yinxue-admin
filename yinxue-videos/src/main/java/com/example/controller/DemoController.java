package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试示例
 * @author minus
 * @since 2023-09-02 18:17
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @GetMapping
    public String demo() {
        log.info("videos demo");
        return "videos demo";
    }

}
