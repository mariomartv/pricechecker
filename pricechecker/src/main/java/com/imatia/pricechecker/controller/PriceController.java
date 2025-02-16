package com.imatia.pricechecker.controller;

import com.imatia.pricechecker.dto.PriceDTO;
import com.imatia.pricechecker.model.Price;
import com.imatia.pricechecker.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping
    public ResponseEntity<PriceDTO> getPrice(
            @RequestParam int brandId,
            @RequestParam int productId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {

        PriceDTO price = priceService.getPrice(brandId, productId, date);
        return ResponseEntity.ok(price);
    }
}
