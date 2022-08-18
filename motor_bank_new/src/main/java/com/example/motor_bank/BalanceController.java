package com.example.motor_bank;

import com.example.motor_bank.model.MyTable;
import com.example.motor_bank.model.TransferBalance;
import com.example.motor_bank.model.WriteToDatabase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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
    public BigDecimal addMoney(@RequestBody TransferBalance tranferBalance) {
        System.out.println("add");
        return bankService.addMoney(tranferBalance.getTo(), tranferBalance.getAmount());
    }

    @PostMapping("/transfer")
    public void tranfer(@RequestBody TransferBalance tranferBalance) {
        System.out.println("transfer");
//
//        MyTable myTable = new MyTable();
//        //myTable.setId(7);
//        myTable.setF(10);
//        myTable.setT(11);
//        myTable.setA(12);
//        WriteToDatabase writeToDatabase = new WriteToDatabase();
//        writeToDatabase.addRecord(myTable);
        bankService.makeTransfer(tranferBalance);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e) {
        log.error(e.getMessage());
        return "Im BROKEN";
    }


}
