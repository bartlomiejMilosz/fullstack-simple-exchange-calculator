package io.github.bartlomiejmilosz.currencycalculator.controllers;

import com.google.gson.Gson;
import io.github.bartlomiejmilosz.currencycalculator.service.ExchangeCalculator;
import io.github.bartlomiejmilosz.currencycalculator.model.ExchangeResult;
import io.github.bartlomiejmilosz.currencycalculator.model.ExchangeType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/convert")
public class ExchangeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            String valueString = request.getParameter("value");
            BigDecimal value = new BigDecimal(valueString);
            String exchangeString = request.getParameter("exchange");
            ExchangeType exchangeType = ExchangeType.valueOf(exchangeString);
            ExchangeResult exchangeResult = ExchangeCalculator.exchange(value, exchangeType);

            // Convert to JSON
            Gson gson = new Gson();
            String jsonResponse = gson.toJson(exchangeResult);

            // Write JSON response
            response.getWriter().write(jsonResponse);
        } catch (Exception e) {
            // Handle exception and send error as JSON
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            Gson gson = new Gson();
            String errorResponse = gson.toJson(e.getMessage());
            response.getWriter().write(errorResponse);
        }
    }
}