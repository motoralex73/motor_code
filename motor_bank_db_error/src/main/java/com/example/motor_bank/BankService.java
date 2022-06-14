package com.example.motor_bank;

import com.example.motor_bank.model.TranferBalance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor //поля добавляются при использовании бина
public class BankService {

    private final BalanceRepository repository;

    public BigDecimal getBalance(Long accountId) {
        BigDecimal balance = repository.getBalanceForId(accountId);
        if (balance == null) {
            throw new IllegalArgumentException();
        }
        return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount) {
        BigDecimal currentBalance = repository.getBalanceForId(to);
        if (currentBalance == null) {
            repository.save(to, amount);
            return amount;
        }
        else {
            BigDecimal updateBalance = currentBalance.add(amount);
            repository.save(to, updateBalance);
            return  updateBalance;
        }
    }

    public void makeTransfer(TranferBalance tranferBalance) {
        BigDecimal fromBalance = repository.getBalanceForId(tranferBalance.getFrom());
        BigDecimal toBalance = repository.getBalanceForId(tranferBalance.getTo());
        if (fromBalance == null || toBalance == null) throw new IllegalArgumentException("no id");
        if (tranferBalance.getAmount().compareTo(fromBalance) > 0) throw new IllegalArgumentException("no money");

        BigDecimal updatedFromBalance = fromBalance.subtract(tranferBalance.getAmount());
        BigDecimal updatedToBalance = toBalance.add(tranferBalance.getAmount());

        repository.save(tranferBalance.getFrom(), updatedFromBalance);
        repository.save(tranferBalance.getTo(), updatedToBalance);
    }
}
