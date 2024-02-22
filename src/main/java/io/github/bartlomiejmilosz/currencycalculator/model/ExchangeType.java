package io.github.bartlomiejmilosz.currencycalculator.model;

import java.math.BigDecimal;

public enum ExchangeType {
    EURPLN("eur", "zł", new BigDecimal("4.3"), "€", "zł"),
    PLNEUR("zł", "eur", new BigDecimal("0.23"), "zł", "€");

    private String baseCurrency;
    private String targetCurrency;
    private BigDecimal exchangeRate;
    private String baseCurrencySymbol;
    private String targetCurrencySymbol;


    ExchangeType(String baseCurrency, String targetCurrency, BigDecimal exchangeRate, String baseCurrencySymbol, String targetCurrencySymbol) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangeRate = exchangeRate;
        this.baseCurrencySymbol = baseCurrencySymbol;
        this.targetCurrencySymbol = targetCurrencySymbol;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public String getBaseCurrencySymbol() {
        return baseCurrencySymbol;
    }

    public String getTargetCurrencySymbol() {
        return targetCurrencySymbol;
    }
}