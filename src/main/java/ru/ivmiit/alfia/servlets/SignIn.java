package ru.ivmiit.alfia.servlets;

import org.mindrot.jbcrypt.BCrypt;
import ru.ivmiit.alfia.repository.UserRepository;
import ru.ivmiit.alfia.repository.UserRepositoryJDBCImpl;
import ru.ivmiit.alfia.security.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signIn")
public class SignIn extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        userRepository=new UserRepositoryJDBCImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/signIn.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        if(userRepository.isExist(login, password)){
            HttpSession session=req.getSession();
            session.setAttribute("user", login);
            resp.sendRedirect(req.getContextPath()+"/get-products");
        }else
            resp.sendRedirect(req.getContextPath()+"/signIn");

    }


}
