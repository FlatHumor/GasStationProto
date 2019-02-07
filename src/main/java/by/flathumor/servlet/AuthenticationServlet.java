package by.flathumor.servlet;

import by.flathumor.dao.TransactionDao;
import by.flathumor.dao.UserDao;
import by.flathumor.entity.Transaction;
import by.flathumor.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "AuthenticationServlet", urlPatterns = { "/auth" })
public class AuthenticationServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        User user = (User)request.getSession().getAttribute("user");
        if (user != null)
        {
            out.println("You logged. ID = " + user.getIdentificator());
            return;
        }
        UserDao userDao = new UserDao();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loggedUser = userDao.findByUsername(username);
        if (loggedUser != null && loggedUser.getPassword().equals(password))
        {
            out.println("<h1>Welcome " + loggedUser.getRealName() + "</h1>");
            request.getSession(true).setAttribute("user", loggedUser);
        }
        else
        {
            request.setAttribute("title", "login failed");
            request.setAttribute("body", "Something went wrong");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("auth.jsp").forward(request, response);
    }
}
