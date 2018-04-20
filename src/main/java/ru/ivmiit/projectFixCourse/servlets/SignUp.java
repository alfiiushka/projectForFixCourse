package ru.ivmiit.projectFixCourse.servlets;

import ru.ivmiit.projectFixCourse.model.StoreUser;
import ru.ivmiit.projectFixCourse.dao.StoreUserDao;
import ru.ivmiit.projectFixCourse.security.SecurityService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=getServletContext();
        StoreUserDao storeUserDao=(StoreUserDao)context.getAttribute("storeUserDaoHibernate");
        SecurityService securityService=(SecurityService) context.getAttribute("securityService");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (storeUserDao.findbylogin(login) == null) {
            StoreUser user = new StoreUser(login, securityService.hashPassword(password));
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
