package io.github.bartlomiejmilosz.currencycalculator.service;

import io.github.bartlomiejmilosz.currencycalculator.model.ExchangeResult;
import io.github.bartlomiejmilosz.currencycalculator.model.ExchangeType;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeCalculator {
    public static ExchangeResult exchange(BigDecimal base, ExchangeType exchangeType) {
        BigDecimal exchangeRate = exchangeType.getExchangeRate();
        BigDecimal result = base.multiply(exchangeRate).setScale(2, RoundingMode.HALF_UP);
        return new ExchangeResult(base, result, exchangeType);
    }
}