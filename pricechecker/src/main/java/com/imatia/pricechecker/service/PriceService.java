package com.imatia.pricechecker.service;

import com.imatia.pricechecker.dto.PriceDTO;
import com.imatia.pricechecker.exception.PriceNotFoundException;
import com.imatia.pricechecker.model.Price;
import com.imatia.pricechecker.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public PriceDTO getPrice(int brandId, int productId, LocalDateTime date) {

        Price price = priceRepository.findApplicablePrice(brandId, productId, date)
                .orElseThrow(() -> new PriceNotFoundException(brandId, productId, date));

        return new PriceDTO(
                price.getStartDate(),
                price.getEndDate(),
                price.getPriceList(),
                price.getProductId(),
                price.getBrandId(),
                price.getPrice()
        );
    }
}
