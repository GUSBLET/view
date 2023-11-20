package com.source.viewer.view.model;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ViewController {
    private final ViewService viewService;

    @GetMapping("/")
    public String test(Model model) {
        List<ViewCardDTO> dtoList = viewService.getViewCards();

        model.addAttribute("list", dtoList);

        return "main";
    }

    @GetMapping("/item")
    public String getItem(@RequestParam("id") Long id, Model model) {
        Optional<View> view = viewService.getViewById(id);

        model.addAttribute("path", view.get().getMviewPath());
        return "item";
    }

    @GetMapping("/mview")
    public String getMview(@RequestParam("path") String path, Model model) {

        model.addAttribute("path", path.replace("mview?path=", ""));
        return "mview";
    }
}
