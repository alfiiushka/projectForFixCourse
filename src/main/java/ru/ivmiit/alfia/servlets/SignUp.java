package ru.ivmiit.alfia.servlets;

import ru.ivmiit.alfia.dao.StoreUserDaoHibernateImpl;
import ru.ivmiit.alfia.model.StoreUser;
import ru.ivmiit.alfia.dao.StoreUserDao;
import ru.ivmiit.alfia.security.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {
    private StoreUserDao storeUserDao;

    @Override
    public void init() {
        storeUserDao = new StoreUserDaoHibernateImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (storeUserDao.findbylogin(login) == null) {
            StoreUser user = new StoreUser(login, SecurityService.hashPassword(password));
            storeUserDao.save(user);
            req.getServletContext().getRequestDispatcher("/jsp/signIn.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "User with the same login is exist! Retry please.");
            doGet(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp").forward(req, resp);
    }
}
