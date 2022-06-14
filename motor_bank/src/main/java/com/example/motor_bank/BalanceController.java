package com.example.motor_bank;

import com.example.motor_bank.model.TranferBalance;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j //логгирование через Ломбок
@RestController("/balance")
@AllArgsConstructor //будут созданы конструкторы по-умолчанию
public class BalanceController {

    private final BankService bankService;

    @Bean
    public String getOne() {
        return "You enter One number";
    }

    @GetMapping("two")
    public String getTwo() {
        return "You enter Two number";
    }

    @GetMapping
    public String getThree() {
        return "You enter Three number";
    }

    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId) { //метод будет получать на вход объект, который будет взят из пути
        return bankService.getBalance(accountId);
    }

    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TranferBalance tranferBalance) {
        System.out.println("add");
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
