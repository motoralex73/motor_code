package com.example.motor_bank;

import com.example.motor_bank.model.TranferBalance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor //поля добавляются при использовании бина
public class BankService {

    private final BalanceRepository repository;

    public Long getBalance(Long accountId) {
        Long balance = repository.getBalanceForId(accountId);
        if (balance == null) {
            throw new IllegalArgumentException();
        }
        return balance;
    }

    public Long addMoney(Long to, Long amount) {
        Long currentBalance = repository.getBalanceForId(to);
        if (currentBalance == null) {
            repository.save(to, amount);
            return amount;
        }
        else {
            Long updateBalance = currentBalance + amount;
            repository.save(to, updateBalance);
            return updateBalance;
        }
    }

    public void makeTransfer(TranferBalance tranferBalance) {
        Long fromBalance = repository.getBalanceForId(tranferBalance.getFromSender());
        Long toBalance = repository.getBalanceForId(tranferBalance.getToSender());
        if (fromBalance == null || toBalance == null) throw new IllegalArgumentException("no id");
        if (tranferBalance.getAmountSender().compareTo(fromBalance) > 0) throw new IllegalArgumentException("no money");

        Long updatedFromBalance = fromBalance + tranferBalance.getAmountSender();
        Long updatedToBalance = toBalance+tranferBalance.getAmountSender();

        repository.save(tranferBalance.getFromSender(), updatedFromBalance);
        repository.save(tranferBalance.getToSender(), updatedToBalance);
    }
}
