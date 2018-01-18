package com.test.servlet;

import com.test.entity.Product;
import com.test.repository.ProductRepository;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = ProductRepository.getAll();
        ObjectMapper mapper = new ObjectMapper();
        String json =  mapper.writeValueAsString(list);
        resp.getWriter().print(json);
    }
}
