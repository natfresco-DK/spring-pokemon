package com.example.springpokemon.utility;

import java.sql.*;

public class ConnectionManager {
    private Connection conn;
    private final String url = System.getenv("DB_URL");
    private final String user = System.getenv("DB_USER");
    private final String password = System.getenv("DB_PASSWORD");

    public ConnectionManager() throws SQLException {
        if(url == null || user == null || password == null){
            throw new RuntimeException("missing database variables");
        }
        this.conn = DriverManager.getConnection(url,user,password);
    }

    public Connection getConnection (){
        return this.conn;
    }

    public void closeConnection(){
        try{
            this.conn.close();
        }
        catch(Exception E){
            System.out.println("Could not close connection");
        }
    }
}
