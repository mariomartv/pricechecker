package com.imatia.pricechecker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PriceNotFoundException extends RuntimeException{
    public PriceNotFoundException(int brandId, int productId, LocalDateTime date) {
        super("No price found for brandId: " + brandId + ", productId: " + productId + ", date: " + date);
    }
}
