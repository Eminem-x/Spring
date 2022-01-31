package com.yuanhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yuanahao
 */
@Controller
public class TargetController {
    @RequestMapping("/target")
    public ModelAndView show() {
        System.out.println("Running...");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","YuanHao");
        modelAndView.setViewName("/index");
        return modelAndView;
    }
}
