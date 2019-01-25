package com.Interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.logging.Logger;

public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger("AuthInterceptor");

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info(" Pre handle is called");
        logger.info("hey [preHandle][" + httpServletRequest + "]" + "[" + httpServletRequest.getMethod() + "]" + httpServletRequest.getRequestURI()+getParameters(httpServletRequest));
        if (httpServletRequest.getMethod().equals("GET")||httpServletRequest.getMethod().equals("POST"))
            return true;
        else
            return false;
    }

    private String getParameters(HttpServletRequest request) {
        StringBuffer posted = new StringBuffer();
        Enumeration<?> e = request.getParameterNames();
        if (e != null) {
            posted.append("?");
        }
        while (e.hasMoreElements()) {
            if (posted.length() > 1) {
                posted.append("&");
            }
            String curr = (String) e.nextElement();
            posted.append(curr + "=");
            if (curr.contains("password")
                    || curr.contains("pass")
                    || curr.contains("pwd")) {
                posted.append("*****");
            } else {
                posted.append(request.getParameter(curr));
            }
        }
        String ip = request.getHeader("X-FORWARDED-FOR");
        String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
        if (ipAddr!=null && !ipAddr.equals("")) {
            posted.append("&_psip=" + ipAddr);
        }
        String str=posted.toString();
        return posted.toString();
    }

    private String getRemoteAddr(HttpServletRequest request) {
        String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
        if (ipFromHeader != null && ipFromHeader.length() > 0) {
            logger.info("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
            return ipFromHeader;
        }
        return request.getRemoteAddr();
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info(" Post handle ");
        if (modelAndView.getModelMap().containsKey("status")) {
            String status = (String) modelAndView.getModelMap().get("status");
            if (status.equals("SUCCESS!")) {
                status = "Authentication " + status;
                modelAndView.getModelMap().put("status", status);
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info(" After Completion ");
    }
}