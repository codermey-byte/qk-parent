//package com.qk.filter;
//
//import com.qk.utils.JwtUtils;
//import io.jsonwebtoken.Claims;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//
//@Slf4j
//@WebFilter(urlPatterns = "/*")
//public class TokenFilter implements Filter {
//
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        // 获取请求路径，/login 直接放行
//        String path = httpServletRequest.getRequestURI();
//        if (path.contains("/login")) {
//            log.info("用户登录");
//            chain.doFilter(request, response);
//            return;
//        }
//        // 获取请求头中的token
//        String token = httpServletRequest.getHeader("Authorization");
//        if (token != null) {
//            token = token.replaceFirst("(?i)^Bearer\\s+", "");
//        }
//        // token 不存在，响应401
//        if (token == null || token.isEmpty()) {
//            log.error("token 不存在");
//            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }
//        try {
//            // 解析token
//            Claims claims = JwtUtils.parseToken(token);
//        } catch (Exception e) {
//            // token解析失败
//            log.error("token 解析失败");
//            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
