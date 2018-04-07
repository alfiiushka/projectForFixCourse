package ru.ivmiit.alfia.servlets;

import ru.ivmiit.alfia.model.Product;
import ru.ivmiit.alfia.repository.ProductRepository;
import ru.ivmiit.alfia.repository.ProductRepositoryJDBCImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/get-products")
public class GetProducts extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init(){
        productRepository=new ProductRepositoryJDBCImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productRepository.getAllProducts();
        req.setAttribute("productsFromServer", productList);
        req.getServletContext().getRequestDispatcher("/jsp/getProducts.jsp").forward(req, resp);
    }
}
