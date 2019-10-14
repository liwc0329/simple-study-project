package com.g7go.stream.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * 交易类
 *
 * @author lwc
 */
@Data
@ToString
public class Transaction {

    private Trader trader;
    private int year;
    private int value;

    public Transaction() {
    }

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
}
