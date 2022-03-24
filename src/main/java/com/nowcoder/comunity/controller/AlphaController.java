package com.nowcoder.comunity.controller;

import com.nowcoder.comunity.service.AlphaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot.I'm yzh!";
    }
    @RequestMapping("/data")
    @ResponseBody
    public  String getData(){
        return alphaService.find();
    }
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration=request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name=enumeration.nextElement();
            String value=request.getHeader(name);
            System.out.println(name+":"+value);
        }
        System.out.println(request.getParameter("code"));
        //返回响应
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer=response.getWriter();
            writer.write("<h1>牛客网</h>");

        }catch (IOException e) {
            e.printStackTrace();
        }

    }


    //GET请求
    // /students?current=1&limit=20
    @RequestMapping(path="/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current",required = false,defaultValue = "1") int current,
            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }
    // /student/123
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    //POST请求
    @RequestMapping(path="/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //响应HTML数据
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("name","hhh");
        mav.addObject("age",11);
        mav.setViewName("/demo/view");//这个view不是静态的，是thymleaf模板
        //mav.setViewName("/html/student");//Cannot resolve MVC View '/html/student',所以这里set的默认路径就是动态的templates
        return mav;
    }
    @RequestMapping(path = "school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","yeah");
        model.addAttribute("age",22);
        return "/demo/view";
    }

    //响应json数据（异步请求）
    //java对象 -> json字符串 -> js对象
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String ,Object> getEmp(){
        Map<String ,Object> emp=new HashMap<>();
        emp.put("name","zs");
        emp.put("age",22);
        emp.put("salary",80000.0);
        return emp;
    }

    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String ,Object> > getEmps(){
        List<Map<String ,Object> >emps=new ArrayList();

        Map<String ,Object> emp=new HashMap<>();
        emp.put("name","zs");
        emp.put("age",22);
        emp.put("salary",80000.0);
        emps.add(emp);

        emp=new HashMap<>();
        emp.put("name","ls");
        emp.put("age",23);
        emp.put("salary",90000.0);
        emps.add(emp);

        emp=new HashMap<>();
        emp.put("name","ww");
        emp.put("age",24);
        emp.put("salary",100000.0);
        emps.add(emp);

        return emps;
    }

}
