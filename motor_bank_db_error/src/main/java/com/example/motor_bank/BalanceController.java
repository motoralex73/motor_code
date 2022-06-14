package com.example.motor_bank;

import com.example.motor_bank.model.TranferBalance;
import com.example.motor_bank.repo.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.*;

@Slf4j //логгирование через Ломбок
@RestController("/balance")
@AllArgsConstructor //будут созданы конструкторы по-умолчанию
public class BalanceController {

    void addRecordToDatabase(int amount) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "alex", "123");

            if (conn == null) {
                System.out.println("Нет соединения с БД!");
                System.exit(0);
            }

            Statement stmt = conn.createStatement();

            long id = 12;
            String sql = "INSERT INTO motor_table VALUES ("+id+",12,15,"+amount+");";

            stmt.executeUpdate(sql);

            ResultSet rs = stmt.executeQuery("SELECT * FROM motor_table");

            while (rs.next()) {
                System.out.println("id="+rs.getString("id") + " from=" + rs.getString("f")
                        + " to=" + rs.getString("t")+" amount=" + rs.getString("a"));
                try {
                    System.out.println("balance="+bankService.getBalance(id));
                }
                catch (Exception e) {
                    //System.out.println(e);
                }
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

    private final BankService bankService;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/setbd")
    public String setData() {
        //база
        return "This page of record to database";
    }

    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId) { //метод будет получать на вход объект, который будет взят из пути
        System.out.println("balance==="+bankService.getBalance(accountId));
        return bankService.getBalance(accountId);
    }

    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TranferBalance tranferBalance) throws SQLException {
        System.out.println("add");

        addRecordToDatabase(tranferBalance.getAmount().intValue());

        return bankService.addMoney(tranferBalance.getTo(), tranferBalance.getAmount());
    }

    @PostMapping("/transfer")
    public void tranfer(@RequestBody TranferBalance tranferBalance) {
        System.out.println("transfer");
        bankService.makeTransfer(tranferBalance);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e) {
        log.error(e.getMessage());
        return "Im BROKEN";
    }


}
