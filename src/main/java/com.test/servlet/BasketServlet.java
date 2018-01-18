package com.test.servlet;

import com.test.commons.Utils;
import com.test.entity.Order;
import com.test.entity.Product;
import com.test.repository.OrderRepository;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

public class BasketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Order order = Utils.getOrderInSession(req);
        String json = mapper.writeValueAsString(order.getList());
        resp.getWriter().print(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        Order order = mapper.readValue(sb.toString(),Order.class);
        order.setList(Utils.getOrderInSession(req).getList());

        OrderRepository.create(order);
        order.getList().clear();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Order order = Utils.getOrderInSession(req);
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        Product product = mapper.readValue(sb.toString(),Product.class);
        order.getList().add(product);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = Utils.getOrderInSession(req);
        Long id = Long.valueOf(req.getParameter("id"));
        Iterator<Product> iterator = order.getList().iterator();
        while (iterator.hasNext()){
            Product product =  iterator.next();
            if(product.getId().intValue() == id){
                iterator.remove();
                break;
            }
        }

    }
}
