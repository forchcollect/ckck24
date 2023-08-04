package org.zerock.ch3.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.info("Login check filter....");

        HttpServletRequest req = (HttpServletRequest) request; 
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        
        if(session.getAttribute("loginInfo") == null) {
            
            resp.sendRedirect("/login"); //필터 통과 X
            
            return;
            
        }
        
        chain.doFilter(request, response); //필터 통과 O -> 다음 필터나 목적지로

    }
}
