package by.flathumor.servlet;

import by.flathumor.model.User;
import by.flathumor.repository.DatabaseRepository;
import by.flathumor.repository.PersManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MainServlet", urlPatterns = { "/main" })
public class MainServlet extends HttpServlet
{
    private DatabaseRepository repository;

//    @Inject
//    private PersManager persManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + "| password: " + password);
        PrintWriter out = response.getWriter();
        out.println("username: " + username + "| password: " + password);
        repository = new DatabaseRepository();
        User user = new User(username, "Markel", "aaaa", password);
//        persManager.persist(user);
        Session session = repository.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        System.out.println("______doGet");
        PrintWriter out = response.getWriter();
        Session session = null;
        try
        {
            session = repository.getSession();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (session != null)
                session.close();
        }

    }
}
