package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import jakarta.persistence.Embeddable;

@Embeddable
public final class Money implements ValueObject{
    private Double amount;
    private String currencyCode; // USD, GBP, EUR etc.

    public Money(Double amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public Money() {
        this(null, null);
    }

    public Double getAmount() {
        return amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
