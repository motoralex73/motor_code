package com.example.motor_bank;

import com.example.motor_bank.model.TranferBalance;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j //логгирование через Ломбок
@RestController("/balance")
@AllArgsConstructor //будут созданы конструкторы по-умолчанию
public class BalanceController {

    private final BankService bankService;

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
