package com.source.viewer.view.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.source.viewer.user.UserService;
import com.source.viewer.view.company.CompanyService;
import com.source.viewer.view.price.quality.PriceQualityService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ViewService {
    private final ViewRepository viewRepository;
    private final CompanyService companyService;
    private final PriceQualityService priceQualityService;
    private final UserService userService;


    public List<ViewCardDTO> getViewCards() {
        List<View> views = viewRepository.findAll();
        ViewCardDTO dto = new ViewCardDTO();
        return dto.toDtoList(views);
    }

    public boolean saveView(ViewDTO dto) {
        try {
            View view = dto.toEntity(dto);
            String fileName = dto.getItemCompanyName() + dto.getItemName() + dto.getPriceQuality().toString() + dto.getCreatingDate();
            view.setMviewPath(saveMviewFile(dto.getMviewFile(), fileName));

            view.setUser(userService.getUserByTelegramId(dto.getTelegramId()));
            view.setCompany(companyService.getCompanyOrCreate(dto.getItemCompanyName()));
            view.setPriceQuality(priceQualityService.getPriceQuality(dto.getPriceQuality()));

            viewRepository.save(view);

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean findViewByName(String name) {
        return viewRepository.findByItemName(name).isPresent();
    }

    public Optional<View> getViewById(Long id) {
        return viewRepository.findById(id);
    }

    private String saveMviewFile(byte[] file, String fileName) throws IOException {
        Resource resource = new ClassPathResource("static\\mviews\\");

        if (!resource.exists()) {
            resource.getFile().mkdirs();
        }

        String filePath = resource.getFile().getAbsolutePath() + "/" + fileName + ".mview";

        Files.write(Path.of(filePath), file);

        return "/mviews/" + fileName + ".mview";
    }

    public ViewDTO convertJSONToViewDTO(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.readValue(json, ViewDTO.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
