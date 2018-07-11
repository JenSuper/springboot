package com.rd.controller;

import com.rd.entity.ResultJson;
import com.rd.entity.User;
import com.rd.service.UserService;
import com.rd.utils.CheckForm;
import com.rd.utils.ResultUtil;
import com.rd.utils.TokenProccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 主页面
     * @param request
     * @return
     */
    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        String token = TokenProccessor.getInstance().makeToken();//创建令牌
        System.out.println("在FormServlet中生成的token：" + token);
        request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
        return "/user/hello";
    }


    /**
     * 查询全部
     * @return
     */
    @RequestMapping(value = "/user")
    @ResponseBody
    public List<User> findAll(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userService.finAll();
        System.out.println(users);
        return users;
    }

    /**
     * 根据id查询user
     *
     * @param id
     */
    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable("id") Integer id) {
        User result = userService.findById(id);
        System.out.println(result);
        return result;
    }

    /**
     * 新增user
     *
     * @param u
     * @param bindingResult
     * @return
     */
//    @PostMapping(value = "/userList")
    @RequestMapping(value = "/userList")
    public String saveUser(@Valid User u, BindingResult bindingResult,HttpServletRequest request) {
        boolean b = CheckForm.checkForm(request);
        if (b){
           return "/erro/erro";
        }else{
            if (bindingResult.hasErrors()) {
                String message = bindingResult.getFieldError().getDefaultMessage();
    //            System.out.println(message);
    //            ResultJson<User> ret=new ResultJson<>();
    //            ret.setCode("400");
    //            ret.setMsg(message);
    //            ret.setData(null);
    //            return ret;
    //            return  null;
                ResultUtil.erro("500", message);
                return "错误";
            }
    //        ResultJson<User> ret = new ResultJson<>();
            //       ret.setCode("200");
            //       ret.setMsg("成功");
            //       ret.setData(userService.saveUser(u));
            //       return ret;
            ResultUtil.success(userService.saveUser(u));
            return "成功";
        }
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    @PostMapping(value = "/delUser")
    public void deleteUser(Integer id) {
        System.out.println(id);
        userService.deleteUserById(id);
    }

    @GetMapping("/check/{id}")
    public void check(@PathVariable("id") Integer id) throws Exception {
        userService.check(id);
    }

    @RequestMapping(value = "/test")
    public int testController() {
        return 2;
    }
}
