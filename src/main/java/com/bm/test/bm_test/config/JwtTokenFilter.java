package com.bm.test.bm_test.config;

import com.auth0.jwt.JWT;
import com.bm.test.bm_test.constants.Security;
import com.bm.test.bm_test.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends GenericFilterBean {
    private final JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter() {
        this.jwtTokenProvider = new JwtTokenProvider();
    }

    private boolean checkFilterRequired(HttpServletRequest req) {
        return !Security.PUBLIC_URLS.contains(req.getRequestURI());
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {
        if (!this.checkFilterRequired((HttpServletRequest) req)) {
            filterChain.doFilter(req, res);
            return;
        }

        try {
            Cookie cookie =  WebUtils.getCookie((HttpServletRequest) req, "bm_test");

            if(cookie == null) {
                ((HttpServletResponse) res).sendRedirect("/login");
                return;
            }

            String token = cookie.getValue();
            jwtTokenProvider.validateToken(token);
            String userName = jwtTokenProvider.getUsernameFromToken(token);
            req.setAttribute("user-name", userName);
        } catch(Exception e) {
            ((HttpServletResponse) res).sendRedirect("/login");
            return;
        }

        filterChain.doFilter(req, res);
    }
}