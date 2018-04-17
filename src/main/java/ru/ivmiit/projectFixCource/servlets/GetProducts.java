package ru.ivmiit.projectFixCource.servlets;

import ru.ivmiit.projectFixCource.model.Product;
import ru.ivmiit.projectFixCource.dao.ProductDao;
import ru.ivmiit.projectFixCource.dao.ProductDaoJdbcTemplateImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/get-products")
public class GetProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        ProductDao productDao = (ProductDao) context.getAttribute("productDao");
        List<Product> productList = productDao.getAllProducts();
        req.setAttribute("productsFromServer", productList);
        req.getServletContext().getRequestDispatcher("/jsp/getProducts.jsp").forward(req, resp);
    }
}
