package com.example.motor_bank.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //генерация новых значений внутри поля, автоматически
    private Long id;
    private Long f;//from;
    private Long t;//to;
    private Long a;//amount;


}
