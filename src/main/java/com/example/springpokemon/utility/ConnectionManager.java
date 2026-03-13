package com.example.springpokemon.utility;

import java.sql.*;

public class ConnectionManager {
    private Connection conn;

    public ConnectionManager() {
        try {
            this.conn = DriverManager.getConnection("");
        }
        catch (Exception e){
            System.out.println("Could not connect to database");
        }
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
