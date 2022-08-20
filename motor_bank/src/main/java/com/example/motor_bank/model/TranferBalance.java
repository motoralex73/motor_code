package com.example.motor_bank.model;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "transfer")
public class TranferBalance {
    @Id
    private Long id;
    private Long fromSender;
    private Long toSender;
    private Long amountSender;

    public TranferBalance(Long id, Long fromSender, Long toSender, Long amountSender) {
        this.id = id;
        this.fromSender = fromSender;
        this.toSender = toSender;
        this.amountSender = amountSender;
    }
    public TranferBalance() {}
}
