package com.test.commons;

import com.test.entity.Order;

import javax.servlet.http.HttpServletRequest;

public class Utils {
    public static final String orderAttribute = "myOrder";

    public static Order getOrderInSession(HttpServletRequest request){
        Order order = (Order) request.getSession().getAttribute(orderAttribute);
        if(order == null){
            order = new Order();
        }
        request.getSession().setAttribute(orderAttribute, order);
        return order;
    }
}
