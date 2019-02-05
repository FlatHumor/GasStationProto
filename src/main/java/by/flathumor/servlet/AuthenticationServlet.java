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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        User firstUser = new User();
        User secondUser = new User();
        firstUser.setUsername("mark");
        firstUser.setPassword("12345");
        secondUser.setUsername("soy");
        secondUser.setPassword("12345");
        userDao.save(firstUser);
        userDao.save(secondUser);
        TransactionDao transactionDao = new TransactionDao();
//        User mark = userDao.findByUsername("markel");
//        if (mark == null)
//        {
//            out.println("<p>mark not found</p>");
//            return;
//        }
//        for (Transaction t : mark.getTransactions())
//            out.println("<p>" + t.getAmount() + "</p>");
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);
//        userDao.save(loginUser);
//        User firstUser = userDao.findByUsername("jason@woorhees");
//        User secondUser = userDao.findByUsername("michael@mayers");
        Transaction t = new Transaction();
        t.setPayer(firstUser);
        t.setRecipient(secondUser);
        t.setAmount(1000d);
        t.setDescription("if you want to be okay");
        t.setTimestamp(System.currentTimeMillis());
        transactionDao.save(t);
        firstUser.addTransaction(t);
        secondUser.addTransaction(t);
        userDao.update(firstUser);
        userDao.update(secondUser);
        for (Transaction tx : firstUser.getTransactions())
            out.println("<p>" + tx.getAmount() + "</p>");
        out.println("<h1>SAVED</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }
}
