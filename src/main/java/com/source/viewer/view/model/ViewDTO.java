package com.source.viewer.view.model;

import com.source.viewer.mapper.Mapper;
import com.source.viewer.user.User;
import com.source.viewer.view.company.Company;
import com.source.viewer.view.price.quality.PriceQuality;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewDTO implements Mapper<ViewDTO, View> {

    private Long telegramId;

    private String itemName;

    private String itemCompanyName;

    private LocalDate creatingDate;

    private String priceQuality;

    private byte[] mviewFile;

    @Override
    public ViewDTO toDto(View entity) {
        return ViewDTO.builder()
                .telegramId(entity.getUser().getTelegramId())
                .creatingDate(entity.getCreatingDate())
                .itemCompanyName(entity.getCompany().getName())
                .itemName(entity.getItemName())
                .priceQuality(entity.getPriceQuality().getName().toString())
                .build();
    }

    @Override
    public View toEntity(ViewDTO dto) {
        return View.builder()
                .user(User.builder().telegramId(dto.getTelegramId()).build())
                .creatingDate(dto.getCreatingDate())
                .company(Company.builder().name(dto.getItemCompanyName()).build())
                .itemName(dto.getItemName())
                .priceQuality(PriceQuality.builder().name(dto.getPriceQuality()).build())
                .build();
    }
}
