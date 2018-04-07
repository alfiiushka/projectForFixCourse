package ru.ivmiit.alfia.servlets;

import ru.ivmiit.alfia.model.Product;
import ru.ivmiit.alfia.repository.ProductRepository;
import ru.ivmiit.alfia.repository.ProductRepositoryInMemoryImpl;
import ru.ivmiit.alfia.repository.ProductRepositoryJDBCImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/save-product")
public class SaveProduct extends HttpServlet{

    private ProductRepository productRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/saveProducts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productRepository.saveProduct(new Product(request.getParameter("name")));
        doGet(request, response);
        }

    @Override
    public void init() throws ServletException {
        productRepository=new ProductRepositoryJDBCImpl();
    }
}
