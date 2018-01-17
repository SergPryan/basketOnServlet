package com.test.repository;

import com.test.entity.Order;

import java.sql.PreparedStatement;


public class OrderRepository {
    public Order create(Order order) {
//        String sql = "INSERT INTO orders (full_name, telephone) VALUES (?, ?)";
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps =
//                    connection.prepareStatement(sql, new String[]{"id"});
//            ps.setString(2, String.valueOf(order.getTelephone()));
//            ps.setString(1, order.getFullName());
//            return ps;
//        }, keyHolder);
//
////    jdbcTemplate.update(sql,order.getFullName(),String.valueOf(order.getTelephone()),keyHolder);
//        System.out.println("key = " + keyHolder.getKey().intValue());
//        order.setId(keyHolder.getKey().longValue());
//        order.getList().forEach(element ->
//                {
//                    String insertProduct = "UPDATE product SET order_id=? WHERE id=?";
//                    jdbcTemplate.update(insertProduct, order.getId().intValue(), element.getId().intValue());
//                }
//        );
//
        return null;
    }
}
