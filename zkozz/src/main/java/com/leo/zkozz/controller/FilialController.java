package com.leo.zkozz.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/filial"})
public class FilialController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilialController.class);

    public FilialController() {
    }

    @GetMapping("/list")
    @ApiOperation("list")
    public String list(Model model) {

        return "/filial/list";
    }


}
