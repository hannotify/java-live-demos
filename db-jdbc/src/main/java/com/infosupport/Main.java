package com.infosupport;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //testPreparedStatements(Jdbc.getInstance());
        testCustomerDao(Jdbc.getInstance());

        Jdbc.getInstance().disconnect();
    }

    private static void testCustomerDao(Jdbc jdbc) {
        CustomerDao dao = new CustomerDao(jdbc);

        dao.insert(new Customer("3", "Jesse"));
        dao.insert(new Customer("4", "Ella"));

        System.out.println(dao.getAll());

        dao.insert(new Customer("5", "Ghost Customer"));

        System.out.println(dao.getAll());

        dao.delete("5");

        System.out.println(dao.getAll());
    }

    private static void testPreparedStatements(Jdbc jdbc) {
        try {
            jdbc.execute("""
            create table customers (
                customer_id varchar(255) not null,
                name varchar(255) null
            )
            """);
        } catch (SQLException e) {
            System.err.printf("Creating table has failed: " + e.getMessage());
        }

        try {
            jdbc.execute("""
            insert into customers (customer_id, name)
            values ('%s', '%s')
            """.formatted("1", "Hanno"));
        } catch (SQLException e) {
            System.err.printf("Inserting values has failed: " + e.getMessage());
        }

        try {
            jdbc.executePreparedStatement(
                    """
                        insert into customers (customer_id, name)
                        values (?, ?)
                        """, "2", "Joep"
            );
        } catch (SQLException e) {
            System.err.printf("Inserting values has failed: " + e.getMessage());
        }

//        System.out.println("""
//            insert into customers (customer_id, name)
//            values ('%s', '%s')
//            """.formatted("2", "Robert'); DROP TABLE customers;--"));
//
//        try {
//            jdbc.execute("""
//            insert into customers (customer_id, name)
//            values ('%s', '%s')
//            """.formatted("2", "Robert'); DROP TABLE customers;-- "));
//        } catch (SQLException e) {
//            System.err.printf("Inserting values has failed: " + e.getMessage());
//        }

//
//        try {
//            jdbc.executeQuery(
//                    """
//                    select *
//                    from titles
//                    where type = 'mod_cook'
//                    """
//            );
//        } catch (SQLException e) {
//            System.err.println("Retrieve titles has failed: " + e.getMessage());
//        }
    }
}