package com.example.backend.security.filter;

import com.example.backend.security.services.facad.UserService;
import com.example.backend.security.services.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthorisationFilter extends OncePerRequestFilter {


    private UserService userService;


    private JwtUtils jwtUtil;

    public JwtAuthorisationFilter(UserService userService,JwtUtils jwtUtil){
        this.userService=userService;
        this.jwtUtil=jwtUtil;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String path = request.getRequestURI();

        // Laisser passer les endpoints publics
        if (path.equals("/api_backend/auth/login/") || path.equals("/api_backend/auth/sign-in/")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authorization =request.getHeader(JwtConstant.AUTHORIZATION);
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            // PAS DE TOKEN → laisser passer si endpoint public
            filterChain.doFilter(request, response);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
