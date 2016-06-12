package br.com.utils;

import br.com.controller.LoginController;
import java.io.IOException;
import javax.servlet.Filter;
import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author barizon
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/app/*"})
public class LoginFilter implements Filter {
    
    @Inject
    private LoginController loginController;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (loginController.getLogado()) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse res = (HttpServletResponse) response;
            HttpServletRequest req = (HttpServletRequest) request;
            res.sendRedirect(req.getContextPath()+"/restricao.xhtml");
        }
    }
    
    @Override
    public void destroy() {
        
    }
}
