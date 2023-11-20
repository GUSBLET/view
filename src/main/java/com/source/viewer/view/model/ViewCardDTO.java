package com.source.viewer.view.model;

import com.source.viewer.mapper.Mapper;
import com.source.viewer.view.company.Company;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewCardDTO implements Mapper<ViewCardDTO, View> {

    private Long id;

    private String name;

    private String company;

    @Override
    public ViewCardDTO toDto(View entity) {
        return ViewCardDTO.builder()
                .id(entity.getId())
                .name(entity.getItemName())
                .company(entity.getCompany().getName())
                .build();
    }

    @Override
    public View toEntity(ViewCardDTO dto) {
        return View.builder()
                .id(dto.getId())
                .itemName(dto.getName())
                .company(Company.builder().name(dto.getCompany()).build())
                .build();
    }
}
