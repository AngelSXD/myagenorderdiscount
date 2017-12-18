package com.agen.interceptpr;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewInterceptpr implements HandlerInterceptor {

    /**
     * 预处理方法,handler执行之前调用
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return  true/false  true即可执行之后的方法 否则 中断
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        User user = (User) httpServletRequest.getSession().getAttribute("user");
//        boolean flag = false;
//        if(user != null){
//            flag = true;
//        }else{
//            flag = false;
//            httpServletResponse.sendRedirect("/toLogin");
//        }

        return false;
    }

    /**
     *handler执行之后调用
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     *本次request完成后调用
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
