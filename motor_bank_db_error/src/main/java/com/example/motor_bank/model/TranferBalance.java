package com.example.motor_bank.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TranferBalance {
    private Long from;
    private Long to;
    private BigDecimal amount;
}
