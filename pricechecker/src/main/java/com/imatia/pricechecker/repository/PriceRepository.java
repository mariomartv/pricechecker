package com.imatia.pricechecker.repository;

import com.imatia.pricechecker.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price,Long> {

    @Query("SELECT p FROM Price p WHERE p.brandId = :brandId AND p.productId = :productId " +
            "AND CAST(:date AS timestamp) BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC LIMIT 1")
    Optional<Price> findApplicablePrice(@Param("brandId") int brandId,
                                    @Param("productId") int productId,
                                    @Param("date") LocalDateTime date);
}
