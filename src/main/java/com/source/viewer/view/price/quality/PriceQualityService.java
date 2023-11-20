package com.source.viewer.view.price.quality;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceQualityService {
    private final PriceQualityRepository priceQualityRepository;

    public PriceQuality getPriceQuality(String priceQuality) {
        return priceQualityRepository.findByName(priceQuality).orElse(null);
    }
}
