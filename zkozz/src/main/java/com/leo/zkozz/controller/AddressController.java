package com.leo.zkozz.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/address"})
public class AddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

    public AddressController() {
    }

    @GetMapping("/list")
    @ApiOperation("list")
    public String list(Model model) {

        return "/address/list";
    }


}
