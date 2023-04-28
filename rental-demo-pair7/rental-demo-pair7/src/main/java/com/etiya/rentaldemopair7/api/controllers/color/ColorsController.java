package com.etiya.rentaldemopair7.api.controllers.color;

import com.etiya.rentaldemopair7.business.abstracts.color.ColorService;
import com.etiya.rentaldemopair7.entities.concreate.Color;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
@AllArgsConstructor
public class ColorsController {

    private ColorService colorService;

    @GetMapping("")
    public List<Color> getAll() {
        return colorService.getAll();
    }

    @PostMapping("")
    public void add(Color color){
        colorService.add(color);
    }
}
