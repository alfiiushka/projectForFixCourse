package ru.ivmiit.alfia.servlets;

import ru.ivmiit.alfia.model.Product;
import ru.ivmiit.alfia.dao.ProductDao;
import ru.ivmiit.alfia.dao.ProductDaoJdbcTemplateImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/get-products")
public class GetProducts extends HttpServlet {

    private ProductDao productDao;

    @Override
    public void init() {
        productDao = new ProductDaoJdbcTemplateImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productDao.getAllProducts();
        req.setAttribute("productsFromServer", productList);
        req.getServletContext().getRequestDispatcher("/jsp/getProducts.jsp").forward(req, resp);
    }
}
