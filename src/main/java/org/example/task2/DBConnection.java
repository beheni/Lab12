package org.example.task2;


import lombok.SneakyThrows;

import java.sql.*;

public class DBConnection {
    private static DBConnection dbconnection;

    private Connection connection;

    @SneakyThrows
    private DBConnection() {
        connection = DriverManager.getConnection("jdbc:sqlite:db.sqlite3");
    }

    @SneakyThrows
    public void executeQuery(String query) {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
    }

    public static DBConnection getInstance() {
        if (dbconnection == null) {
            dbconnection = new DBConnection();
        }
        return dbconnection;
    }

    @SneakyThrows
    public String searchQuery(String query){
        PreparedStatement p;
        ResultSet rs;
        p = connection.prepareStatement(query);
        rs = p.executeQuery();
        if(rs!=null){
            return rs.getString("docText");
        }
        return null;
    }
}
