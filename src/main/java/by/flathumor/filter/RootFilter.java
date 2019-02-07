package by.flathumor.filter;

import by.flathumor.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class RootFilter implements Filter
{
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = httpRequest.getRequestURI().equals(httpRequest.getContextPath() + "/auth");
        if (loggedIn || loginRequest)
            chain.doFilter(request, response);
        else
            httpResponse.sendRedirect("/auth");
    }

    public void init(FilterConfig config) { }

    public void destroy() { }
}
