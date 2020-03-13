package com.turkishairlines;

import java.sql.*;

public class MySqlDatabase {
    private String username;
    private String password;
    private String databaseName;
    private Connection mysqlConnection;

    public MySqlDatabase(String username, String password, String databaseName) {
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;
    }

    private void connect() throws SQLException {
        mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, username, password);
    }

    public ResultSet resultSet(String sql) throws SQLException {
        this.connect();
        Statement statement = this.mysqlConnection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        return result;
    }

    public void close() throws SQLException {
        if (!this.mysqlConnection.isClosed())
            this.mysqlConnection.close();
    }
}
