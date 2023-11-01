package com.infosupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CustomerDao implements Dao<Customer, String> {
    private final Jdbc jdbc;

    public CustomerDao(Jdbc jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Customer get(String customerId) {
        try (var resultset = jdbc.executeSelect(
                "select * from customers where customer_id=" + customerId)) {

            resultset.next();

            return new Customer(customerId, resultset.getString("name"));
        } catch (SQLException e) {
            System.err.println("Failed to parse result set: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Customer> getAll() {
        Set<Customer> customers = new HashSet<>();

        ResultSet resultSet = jdbc.executeSelect("select * from customers");

        try {
            while (resultSet.next()) {
                    customers.add(new Customer(
                            resultSet.getString("customer_id"),
                            resultSet.getString("name")));
            }
        } catch (SQLException e) {
            System.err.println("Failed to parse result set: " + e.getMessage());
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return customers;
    }

    @Override
    public boolean insert(Customer customer) {
        try {
            jdbc.executePreparedStatement(
                    "insert into customers (customer_id, name) values (?, ?)",
                    customer.id(), customer.name());
        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean update(Customer newCustomer) {
        try {
            jdbc.executePreparedStatement(
                    "update customers set name=? where customer_id=?",
                    newCustomer.name(), newCustomer.id());
        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(String customerId) {
        try {
            jdbc.executePreparedStatement(
                    "delete from customers where customer_id=?", customerId);
        } catch (SQLException e) {
            return false;
        }

        return true;
    }
}
