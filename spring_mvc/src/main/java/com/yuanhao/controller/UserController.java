package com.yuanhao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuanhao.domain.User;
import com.yuanhao.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Yuanhao
 */
@Controller
@RequestMapping("/test")
public class UserController {
    @RequestMapping("/quick")
    public String save() {
        System.out.println("Controller...");
        return "success";
    }

    @RequestMapping("/slow1")
    public ModelAndView test1() {
        System.out.println("Test...");
        // model 模型 封装数据    view 视图 展示数据
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "yuanhao");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/slow2")
    public String test2(HttpServletRequest request) {
        request.setAttribute("username", "YuanHao");
        return "success";
    }

    @RequestMapping("/slow3")
    public void test3(HttpServletResponse response) throws Exception {
        response.getWriter().println("Testing response");
    }

    @RequestMapping("/slow4")
    @ResponseBody
    public String test4() {
        // 告知SpringMVC框架 不进行视图跳转 直接进行数据相应
        return "Testing response";
    }

    @RequestMapping("/slow5")
    @ResponseBody
    public String test5() throws Exception {
        User user = new User();
        user.setUsername("YuanHao");
        user.setAge(20);
        // 使用json转换工具将对象转换成json格式字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/slow6")
    @ResponseBody
    public User test6() throws Exception {
        User user = new User();
        user.setUsername("YuanHao");
        user.setAge(20);
        // SpringMVC自动将User转换成JSON格式的字符串
        return user;
    }

    @RequestMapping("/slow7")
    @ResponseBody
    public void test7(String username, int age) throws Exception {
        System.out.println(username + " " + age);
    }

    @RequestMapping("/slow8")
    @ResponseBody
    public void test8(User user) throws Exception {
        System.out.println(user.toString());
    }

    @RequestMapping("/slow9")
    @ResponseBody
    public void test9(String[] strs) throws Exception {
        System.out.println(Arrays.asList(strs).toString());
    }

    @RequestMapping("/slow10")
    @ResponseBody
    public void test10(VO vo) throws Exception {
        System.out.println(vo.toString());
    }

    @RequestMapping("/slow11")
    @ResponseBody
    public void test11(@RequestParam(value = "name", required = false, defaultValue = "YuanHao") String username) throws Exception {
        System.out.println(username);
    }

    @RequestMapping("/slow12/{name}")
    @ResponseBody
    public void test12(@PathVariable(value = "name") String username) throws Exception {
        System.out.println(username);
    }

    @RequestMapping("/slow13")
    @ResponseBody
    public void test13(Date date) throws Exception {
        System.out.println(date);
    }

    @RequestMapping("/slow14")
    @ResponseBody
    public void test14(@RequestHeader(value = "User-Agent", required = false) String userAgent) throws Exception {
        System.out.println(userAgent);
    }

    @RequestMapping("/slow15")
    @ResponseBody
    public void test15(@CookieValue(value = "JSESSIONID") String jSessionId) throws Exception {
        System.out.println(jSessionId);
    }

    @RequestMapping("/slow16")
    @ResponseBody
    public void test16() throws Exception {
        System.out.println();
    }

    @RequestMapping("/slow17")
    @ResponseBody
    public void test17(String username, MultipartFile uploadFile1, MultipartFile uploadFile2) throws Exception {
        System.out.println(username);
        System.out.println(uploadFile1);

        String originalFilename1 = uploadFile1.getOriginalFilename();
        uploadFile1.transferTo(new File("C:\\Users\\DELL\\Desktop\\新建文件夹\\" + originalFilename1));
        String originalFilename2 = uploadFile2.getOriginalFilename();
        uploadFile2.transferTo(new File("C:\\Users\\DELL\\Desktop\\新建文件夹\\" + originalFilename2));
    }
}
