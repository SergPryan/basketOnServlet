package com.test.repository;

import com.test.commons.DatabaseUtils;
import com.test.entity.Order;

import java.sql.*;


public class OrderRepository {

    private static final String INSERT_ORDER = "INSERT INTO orders (full_name, telephone) VALUES (?, ?)";
    private static final String INSERT_PRODUCT = "UPDATE product SET order_id=? WHERE id=?";



    public static Order create(Order order) {
//
        Connection connection = DatabaseUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_ORDER,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,order.getFullName());
            statement.setString(2,order.getTelephone());
            statement.executeQuery();
            order.setId(statement.getGeneratedKeys().getLong(1));
            Statement statementProduct = connection.createStatement();
//            order.getList().forEach(element ->{
//
//            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
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
//        return null;
    }
}
