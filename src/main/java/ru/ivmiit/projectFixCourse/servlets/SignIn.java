package ru.ivmiit.projectFixCourse.servlets;

import ru.ivmiit.projectFixCourse.dao.StoreUserDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signIn")
public class SignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        StoreUserDao storeUserDao = (StoreUserDao) context.getAttribute("storeUserDaoJdbc");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (storeUserDao.isExist(login, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", login);
            resp.sendRedirect(req.getContextPath() + "/get-products");
        } else
            resp.sendRedirect(req.getContextPath() + "/signIn");
    }

}
