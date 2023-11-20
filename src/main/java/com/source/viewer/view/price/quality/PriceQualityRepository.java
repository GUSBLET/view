package com.source.viewer.view.price.quality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceQualityRepository extends JpaRepository<PriceQuality, Long> {

    @Query("SELECT p FROM PriceQuality p WHERE p.name = 'Q0'")
    Optional<PriceQuality> findByName(@Param("name") String  name);
}
