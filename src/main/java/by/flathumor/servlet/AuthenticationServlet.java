package by.flathumor.servlet;

import by.flathumor.bean.ErrorBean;
import by.flathumor.dao.UserDao;
import by.flathumor.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AuthenticationServlet", urlPatterns = { "/auth" })
public class AuthenticationServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        User user = (User) request.getSession().getAttribute("user");
//        if (user != null) {
//            out.println("You logged. ID = " + user.getIdentificator());
//            out.println("request.getContextPath(): " + request.getContextPath());
//            out.println("request.getRequestURI(): " + request.getRequestURI());
//            out.println("request.getAuthType(): " + request.getAuthType());
//            return;
//        }
        UserDao userDao = new UserDao();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loggedUser = userDao.findByUsername(username);
        if (loggedUser != null && loggedUser.getPassword().equals(password))
        {
            request.getSession(true).setAttribute("user", loggedUser);
            request.getSession().setMaxInactiveInterval(30);
            response.sendRedirect("/");
        }
        else
        {
            ErrorBean errorBean = new ErrorBean();
            errorBean.setTitle("login failed");
            errorBean.setBody("Something went wrong. Login please");
            request.setAttribute("error", errorBean);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("auth.jsp").forward(request, response);
    }
}
