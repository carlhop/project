
package dev.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class ConnectionService {
        private Connection connection;

        public Connection establishConnection() {

            try {
                    String url = "jdbc:postgresql://localhost:5432/postgres";
                    String username = "postgres";
                    String password = "Reginald15!";
                   return DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
