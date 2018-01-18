package com.test.repository;

import com.test.commons.DataSource;
import com.test.entity.Order;

import java.sql.*;


public class OrderRepository {

    private static final String INSERT_ORDER = "INSERT INTO orders (full_name, telephone) VALUES (?, ?)";
    private static final String UPDATE_PRODUCT = "UPDATE product SET order_id=? WHERE id=?";

    public static Order create(Order order) {

        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ORDER,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, order.getFullName());
            statement.setString(2, order.getTelephone());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                order.setId(resultSet.getLong(1));
            }

            for (int i = 0; i < order.getList().size(); i++) {
                try (PreparedStatement statementProduct = connection.prepareStatement(UPDATE_PRODUCT)) {
                    statementProduct.setInt(1, order.getId().intValue());
                    statementProduct.setInt(2, order.getList().get(i).getId().intValue());
                    statementProduct.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;

    }
}
