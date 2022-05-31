package com.example.motor_bank;

import com.example.motor_bank.model.TranferBalance;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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
        return bankService.addMoney(tranferBalance.getTo(), tranferBalance.getAmount());
    }


    @PostMapping("/transfer")
    public void tranfer(@RequestBody TranferBalance tranferBalance) {
        bankService.makeTransfer(tranferBalance);
    }

}
