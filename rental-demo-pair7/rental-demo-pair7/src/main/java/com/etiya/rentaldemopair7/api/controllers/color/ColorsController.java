package com.etiya.rentaldemopair7.api.controllers.color;

import com.etiya.rentaldemopair7.business.abstracts.color.ColorService;
import com.etiya.rentaldemopair7.business.dtos.requests.color.AddColorRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.color.AddColorResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.ListColorResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.entities.concreate.Color;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {

    @Autowired
    public ColorsController(ColorService colorService) {
        this.colorService = colorService;
    }

    private ColorService colorService;

    @GetMapping("")
    public List<ListColorResponse> getAll() {
        return colorService.getAll();
    }

    @PostMapping("")
    public DataResult<AddColorResponse> add(@Valid @RequestBody AddColorRequest addColorRequest) {
       return colorService.add(addColorRequest);
    }
}
