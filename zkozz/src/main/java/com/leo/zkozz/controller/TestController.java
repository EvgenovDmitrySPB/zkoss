package com.leo.zkozz.controller;

import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping(value = {"/"})
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Value("${zkozz.app-name}")
    private String name;

    @Value("${zkozz.version}")
    private String version;


    public TestController(Environment env) {
        this.env = env;
    }

    private final Environment env;

    @GetMapping("/index")
    @ApiOperation("index")
    public String index() {
        return "index";
    }

    @GetMapping("/check")
    @ApiOperation("Check service")
    public @ResponseBody String check() {

        return "Service is working! " + DateTime.now();
    }

    @GetMapping("/prop")
    @ApiOperation("Check properties")
    public @ResponseBody  String getProperties() {

        return name;
    }

    @GetMapping("/version")
    @ApiOperation("Check properties")
    public @ResponseBody  String getVersion() {

        return version;
    }

    @GetMapping("/mvvm")
    @ApiOperation("mvvm")
    public String mvvm() {
        return "mvvm";
    }

}
