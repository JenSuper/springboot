package com.rd.utils;

import javax.servlet.http.HttpServletRequest;

public class CheckForm {

    /**
     * 判断是否重复提交
     * @param request
     * @return
     */
    public static boolean checkForm(HttpServletRequest request) {
        boolean b = isRepeatSubmit(request);//判断用户是否是重复提交
        if (b == true) {
            System.out.println("请不要重复提交");
            return true;
        }
        request.getSession().removeAttribute("token");//移除session中的token
        System.out.println("处理用户提交请求！！");
        return false;
    }

    /**
     * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
     *
     * @param request
     * @return true 用户重复提交了表单
     * false 用户没有重复提交表单
     */
    private static boolean isRepeatSubmit(HttpServletRequest request) {
        String client_token = request.getParameter("token");
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        if (client_token == null) {
            return true;
        }
        //取出存储在Session中的token
        String server_token = (String) request.getSession().getAttribute("token");
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if (server_token == null) {
            return true;
        }
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
        if (!client_token.equals(server_token)) {
            return true;
        }
        return false;
    }
}
