package ru.ivmiit.projectFixCourse.servlets;

import ru.ivmiit.projectFixCourse.model.Product;
import ru.ivmiit.projectFixCourse.dao.ProductDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save-product")
public class SaveProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/saveProducts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        ProductDao productDao = (ProductDao) context.getAttribute("productDao");
        productDao.save(new Product(request.getParameter("name")));
        doGet(request, response);
    }
}
