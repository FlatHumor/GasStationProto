package by.flathumor.filter;

import by.flathumor.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class RootFilter implements Filter
{
    private List<String> excludedUrls;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        for (String excludedUrl : excludedUrls)
            if (httpRequest.getRequestURI().startsWith(excludedUrl)) {
                chain.doFilter(request, response);
                return;
            }
        HttpSession session = httpRequest.getSession();
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = httpRequest.getRequestURI().equals(httpRequest.getContextPath() + "/auth");
        if (loggedIn || loginRequest) {
            chain.doFilter(request, response);
        }
        else {
            httpResponse.sendRedirect("/auth");
        }
    }

    public void init(FilterConfig config)
    {
        excludedUrls = new ArrayList<>();
        excludedUrls.add("/static");
        excludedUrls.add("/help.jsp");
        excludedUrls.add("/error.jsp");
    }

    public void destroy() { }
}
