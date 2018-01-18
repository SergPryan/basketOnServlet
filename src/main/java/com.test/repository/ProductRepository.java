package com.test.repository;

import com.test.commons.DatabaseUtils;
import com.test.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static final String SELECT_ALL = "SELECT * FROM product";

    public static List<Product> getAll(){
        Connection connection = DatabaseUtils.getConnection();
        List<Product> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                result.add(product);
                System.out.println(product.getName());
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        final String sql = "SELECT * FROM product WHERE order_id is NULL";
//        List<Product> result = jdbcTemplate.query(sql, (resultSet, i) -> {
//            Product product = new Product();
//            product.setId(resultSet.getLong("id"));
//            product.setName(resultSet.getString("name"));
//            product.setPrice(resultSet.getFloat("price"));
//            return product;
//        });
//        return result;
        return result;
    }
}
