package com.example.motor_bank.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "MyTable") // сущность, название сущности
@Data
@Table(name = "mytable") //таблица, название таблицы
public class MyTable {
    @Id
    private Long id;
    private int f;
    private int t;
    private int a;

    public MyTable(Long id, int f, int t, int a) {
        this.id = id;
        this.f = f;
        this.t = t;
        this.a = a;
    }
    public MyTable() {}
}
