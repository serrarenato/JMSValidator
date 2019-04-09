package com.memorynotfound.integration;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable {

    @NotNull
    private String from;
    @NotNull
    private String to;
    @Min(100)
    private BigDecimal amount;
    @NotNull
    private String test;

    public Order() {
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    public Order(String from, String to, BigDecimal amount, String teste) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.test = teste;
    }

    public Order(String from, String to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                ", teste= "+ test +
                '}';
    }
}
