package com.etiya.rentaldemopair7.api.controllers.color;

import com.etiya.rentaldemopair7.business.abstracts.color.ColorService;
import com.etiya.rentaldemopair7.business.dtos.requests.color.AddColorRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.color.DeleteColorRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.color.UpdateColorRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.color.*;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public DataResult<List<ListColorResponse>> getAll() {
        return colorService.getAll();
    }

    @PostMapping("")
    public DataResult<AddColorResponse> add(@Valid @RequestBody AddColorRequest addColorRequest) {
        DataResult<AddColorResponse> response = colorService.add(addColorRequest);
        return response;
    }

    @PutMapping("")
    public DataResult<UpdateColorResponse> update(@Valid @RequestBody UpdateColorRequest updateColorRequest) {
        return colorService.update(updateColorRequest);
    }

    @DeleteMapping("{id}")
    public DataResult<DeleteColorResponse> delete(@Valid @RequestBody DeleteColorRequest deleteColorRequest){
        return colorService.delete(deleteColorRequest);
    }

    @GetMapping("{id}")
    public DataResult<ColorDetailResponse> getById(@PathVariable int id) {
        return colorService.getById(id);
    }

    @GetMapping("getWithPagination")
    public DataResult<Page<ListColorResponse>> getAll(@RequestParam int page,@RequestParam int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return colorService.getAllWithPagination(pageable);
    }
}