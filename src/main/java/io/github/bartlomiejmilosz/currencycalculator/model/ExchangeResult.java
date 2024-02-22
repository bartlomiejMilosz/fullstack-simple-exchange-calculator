package io.github.bartlomiejmilosz.currencycalculator.model;

import java.math.BigDecimal;

public class ExchangeResult {
    private BigDecimal base;
    private BigDecimal result;
    private ExchangeType exchangeType;
    private String baseCurrencySymbol;
    private String targetCurrencySymbol;

    public ExchangeResult(BigDecimal base, BigDecimal result, ExchangeType exchangeType) {
        this.base = base;
        this.result = result;
        this.exchangeType = exchangeType;
        this.baseCurrencySymbol = exchangeType.getBaseCurrencySymbol();
        this.targetCurrencySymbol = exchangeType.getTargetCurrencySymbol();
    }

    public String getCurrencySymbol(boolean isBase) {
        return isBase ? baseCurrencySymbol : targetCurrencySymbol;
    }

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(ExchangeType exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getBaseCurrencySymbol() {
        return baseCurrencySymbol;
    }

    public void setBaseCurrencySymbol(String baseCurrencySymbol) {
        this.baseCurrencySymbol = baseCurrencySymbol;
    }

    public String getTargetCurrencySymbol() {
        return targetCurrencySymbol;
    }

    public void setTargetCurrencySymbol(String targetCurrencySymbol) {
        this.targetCurrencySymbol = targetCurrencySymbol;
    }
}