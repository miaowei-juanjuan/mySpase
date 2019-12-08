package com.example.workspace.controller;



import com.alibaba.fastjson.JSONObject;
import com.example.workspace.pojo.Stu;
import com.example.workspace.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("")
public class StuController {
    @Autowired
    private StuService ss;


    /**
     * 登录页面
     */
    @RequestMapping("/")
    public String Index(){
        System.out.println("aaa");
        return "Login";
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    public String Login(String stuName,String password) {
        boolean flag = ss.login(stuName, password);
        if (flag==true){
            return "main";
        }else{
            return "error";
        }
    }

    /**
     * 注册跳转
     */

    @RequestMapping("/goRegister")
    public String GoRegister() {
            return "Register";
    }

    /**
     *  注册用户
     */
    @ResponseBody
    @RequestMapping("/register")
    public String Register(String user,String pwd) {
        boolean flag=ss.register(user,pwd);
        String json=JSONObject.toJSONString(flag);
        return json;
    }

    /**
    *  查询所有用户信息
    */
    @ResponseBody
    @RequestMapping("/selectAll")
    public String selectAll() {
        List<Stu> stuList=ss.selectAll();
        String json=JSONObject.toJSONString(stuList);
        return json;
    }
    /**
    *  删除用户
    */
    @ResponseBody
    @RequestMapping("/delUser")
    public String delUser(Integer id) {
        boolean flag=ss.delUser(id);
        String json=JSONObject.toJSONString(flag);
        return json;
    }

    /**
    *  编辑用户
    */
    @ResponseBody
    @RequestMapping("/editUser")
    public String editUser(Stu stu) {
        boolean flag=ss.editUser(stu);
        String json=JSONObject.toJSONString(flag);
        return json;
    }

    /**
    *  模糊查询（用户）
    */
    @ResponseBody
    @RequestMapping("/searchForm")
    public String searchForm(String stuName) {
        List<Stu> stuList=ss.searchForm(stuName);
        String json=JSONObject.toJSONString(stuList);
        return json;
    }


}
