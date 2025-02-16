package com.imatia.pricechecker.dto;

import java.time.LocalDateTime;

public class PriceDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private int productId;
    private int brandId;
    private double price;

    public PriceDTO(LocalDateTime startDate, LocalDateTime endDate, int priceList, int productId, int brandId, double price) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.brandId = brandId;
        this.price = price;
    }

    public LocalDateTime getStartDate() { return startDate; }
    public LocalDateTime getEndDate() { return endDate; }
    public int getPriceList() { return priceList; }
    public int getProductId() { return productId; }
    public int getBrandId() { return brandId; }
    public double getPrice() { return price; }
}
