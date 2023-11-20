package com.source.viewer.view.model;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("view")
public class ViewRestController {

    private final ViewService viewService;

    @PostMapping(path = "/add-view")
    public ResponseEntity<Boolean> addNewView(@RequestBody String json) throws IOException {
        ViewDTO dto = viewService.convertJSONToViewDTO(json);

        if(dto == null)
            return ResponseEntity.status(HttpStatus.OK).body(false);

        if(viewService.findViewByName(dto.getItemName()))
            return ResponseEntity.status(HttpStatus.OK).body(false);

        viewService.saveView(dto);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
