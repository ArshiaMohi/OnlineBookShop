package com.example.project.security;

import com.example.project.model.ApplicationUser;
import com.example.project.service.ApplicationUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final ApplicationUserService applicationUserService;

    public JwtAuthenticationFilter(JwtService jwtService,@Lazy ApplicationUserService applicationUserService) {
        this.jwtService = jwtService;
        this.applicationUserService = applicationUserService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException{
        System.out.println("JWT Filter Executed");
        final String authHeader = request.getHeader("Authorization");
        System.out.println(authHeader);
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            System.out.println("Header passed");
            return;
        }
        String jwt = authHeader.substring(7);
        String username = jwtService.extractUsername(jwt);
        System.out.println("Username = " + username);
        ApplicationUser user = applicationUserService.findByUsername(username);
        System.out.println("User = " + user.getUsername());
        if(jwtService.isTokenValid(jwt, user)){
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            user,
                            null,
                            user.getAuthorities()
                    );
            System.out.println("Token valid = " + jwtService.isTokenValid(jwt, user));
            authToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );
            SecurityContextHolder.getContext().setAuthentication(authToken);
            System.out.println("Authentication set successfully");
        }
        filterChain.doFilter(request, response);
    }
}
