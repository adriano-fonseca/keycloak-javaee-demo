package com.company.bookbox;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakSecurityContext;

/**
 * A filter that attempts to pull the KeycloakSecurityContext and its bearer token String from the ServletRequest. 
 * If found, it's provided to KeycloakBearerTokenAuthenticationProvider's ThreadLocal variable for use during authentication. 
 * 
 * @author Brett Meyer 
 */
@WebFilter("/*")	
public class KeyCloakBearerTokenFilter implements Filter { 
 
    @Override 
    public void init(FilterConfig filterConfig) throws ServletException { 
    } 
 
    @Override 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException { 
        HttpServletRequest httpServletRequest = (HttpServletRequest) request; 
        KeycloakSecurityContext session = (KeycloakSecurityContext) httpServletRequest.getAttribute(KeycloakSecurityContext.class.getName()); 
        String bearerToken; 
        if (session != null) { 
            bearerToken = session.getTokenString(); 
        } else { 
            bearerToken = "LOGGED_OUT"; 
        } 
        chain.doFilter(request, response); 
    } 
 
    @Override 
    public void destroy() { 
    } 
 
}