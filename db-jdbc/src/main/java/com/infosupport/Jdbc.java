package com.infosupport;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
    private static Jdbc INSTANCE;
    private Connection connection;

    private Jdbc() {
        connect();
    }

    public static Jdbc getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Jdbc();
        }
        return INSTANCE;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:6306", "root", "secure");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeQuery(String query) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String titleId = resultSet.getString("TITLE_ID");
                double advance = resultSet.getDouble("advance");
                String notes = resultSet.getString("notes");
                Date pubdate = resultSet.getDate("pubdate");
                String title = resultSet.getString("title");

                System.out.printf("titleId: %s, advance: %f, notes: %s, pubdate: %s, title: %s%n",
                        titleId, advance, notes, pubdate, title);
            }
            printMetadata(resultSet.getMetaData());
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void printMetadata(ResultSetMetaData metaData) throws SQLException {
        System.out.printf("Column count: %d%n", metaData.getColumnCount());

        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.printf("Column name: %s%n", metaData.getColumnName(i));
            System.out.printf("Column display size: %d%n", metaData.getColumnDisplaySize(i));
            System.out.printf("Column type name: %s%n", metaData.getColumnTypeName(i));
        }
    }
}
