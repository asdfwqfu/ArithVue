package edu.hnu.csappdemo.controller;

import edu.hnu.csappdemo.entity.Userdemo;
import edu.hnu.csappdemo.service.UserdemoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONObject;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Random;



@RestController
@RequestMapping("/")

public class CsappController {
    @Resource
    private UserdemoService userdemoService;
    @CrossOrigin
    @RequestMapping("start")
    public JSONObject Csapp(String qid)
    {
        Random r=new Random();
        int i1=r.nextInt(10);
        int i2=r.nextInt(10);
        String str="";
        if(0==qid.compareToIgnoreCase("1"))
            str = i1 + "+" + i2 + "=__";
        else if(0==qid.compareToIgnoreCase("2"))
            str = i1 + "*" + i2 + "=__";
        JSONObject jsonOBJ=new JSONObject();
        jsonOBJ.put("op1",i1);
        jsonOBJ.put("op2",i2);
        //jsonOBJ.put("result",i1+i2);
        jsonOBJ.put("str",str);
        return jsonOBJ;
    }

    @CrossOrigin
    @RequestMapping("check")
    public JSONObject CsappCheck(@RequestBody JSONObject sendBody) {
        String op1Str = sendBody.get("op1").toString();
        String op2Str = sendBody.get("op2").toString();
        String resultStr = sendBody.get("result").toString();
        String qid = sendBody.get("qid").toString();
        int op1 = Integer.parseInt(op1Str);
        int op2 = Integer.parseInt(op2Str);
        int result = Integer.parseInt(resultStr);
        int code = -1;
        String returnStr = "错误";
        JSONObject jsonOBJ = new JSONObject();
            if (result == op1 + op2) {
                code = 1;
                returnStr = "正确";
            }
            else if (result == op1 * op2) {
                code = 1;
                returnStr = "正确";
            }
        jsonOBJ.put("code", code);
        jsonOBJ.put("str", returnStr);
        return jsonOBJ;
    }
    @CrossOrigin
    @RequestMapping("getUser")
    public JSONObject getUser()
    {
        Userdemo userdemo=userdemoService.queryById(1);
        JSONObject jsonOBJ=new JSONObject();
        jsonOBJ.put("name",userdemo.getName());
        jsonOBJ.put("pwd",userdemo.getPwd());
        jsonOBJ.put("num",userdemo.getNum());
        jsonOBJ.put("uid",userdemo.getUid());
        return jsonOBJ;
    }
    @CrossOrigin
    @RequestMapping("login")
    public JSONObject login(@RequestBody JSONObject sendBody)

    {
        String username=sendBody.get("username").toString();
        String PWD=sendBody.get("PWD").toString();
        Userdemo userdemo=userdemoService.queryByNameAndPWD(username,PWD);
        JSONObject jsonOBJ=new JSONObject();
        if(null==userdemo)
        {
            jsonOBJ.put("code",-1);
            jsonOBJ.put("info","用户名密码不匹配");
        }
        else
        {
            jsonOBJ.put("code",1);
            jsonOBJ.put("info","登录成功");
        }
        return jsonOBJ;
    }
    @CrossOrigin
    @RequestMapping("register")
    public JSONObject register(@RequestBody JSONObject sendBody)
    {
        String username=sendBody.get("username").toString();
        String PWD=sendBody.get("PWD").toString();
        Userdemo userdemo=userdemoService.queryByName(username);
        JSONObject jsonOBJ=new JSONObject();
        if(null!=userdemo)
        {
            jsonOBJ.put("code",-1);
            jsonOBJ.put("info","用户名已经存在");
            return  jsonOBJ;
        }
        try {
            userdemo=new Userdemo();
            userdemo.setName(username);
            userdemo.setPwd(PWD);
            userdemoService.insert(userdemo);
        }
        catch (Exception e)
        {
            jsonOBJ.put("code",-2);
            jsonOBJ.put("info","数据插入时发生错误--\n"+e.toString());
            return  jsonOBJ;
        }
        jsonOBJ.put("code",1);
        jsonOBJ.put("info","注册成功!");
        return jsonOBJ;
    }
}