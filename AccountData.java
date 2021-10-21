package dev.data;

import dev.services.ConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountData {

    private ConnectionService connectionService = new ConnectionService();

    public Object getbankAccount() {
        try {
            String sql = "select * from bankAccount";
            Connection c = connectionService.establishConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("customer_name");
                String account = rs.getString("account_type");
                double balance = rs.getDouble("balance");
                System.out.println("name:"+ name+ ", account:"+account+ "balance:"+balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return getbankAccount();

    }
}
