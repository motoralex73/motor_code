package com.example.motor_bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {
//
//    BankServiceTest() throws SQLException {
//    }

    private BalanceRepository balanceRepository = new BalanceRepository();
    private BankService bankService = new BankService(balanceRepository);

    void connectionBase() throws SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "alex", "123");

            if (conn == null) {
                System.out.println("Нет соединения с БД!");
                System.exit(0);
            }

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM motor_table");

            while (rs.next()) {
                System.out.println(rs.getString("id") + ". " + rs.getString("f")
                        + ". " + rs.getString("t")+". " + rs.getString("a"));
            }

            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null){conn.close();}
        }
    }

    @Test
    void getBalance() throws SQLException {
        BigDecimal balance = bankService.getBalance(1L);
        assertEquals(balance, BigDecimal.TEN);

        connectionBase();

        System.out.println("Get Balance count money = "+balance);
    }

    @Test
    void addMoney() {
        BigDecimal balance = bankService.addMoney(1L, BigDecimal.ONE);
        assertEquals(balance, BigDecimal.valueOf(11));
        System.out.println("addMoney balance = "+balance);
    }
}