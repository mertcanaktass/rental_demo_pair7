package com.etiya.rentaldemopair7.api.controllers.accessory;

import com.etiya.rentaldemopair7.business.abstracts.accessory.AccessoryService;
import com.etiya.rentaldemopair7.business.dtos.requests.accessory.AddAccessoryRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.AddAccessoryResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.ListAccessoryResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/accessories")

public class AccessoriesController {

    @Autowired
    public AccessoriesController(AccessoryService accessoryService) {
        this.accessoryService = accessoryService;
    }

    private AccessoryService accessoryService;

    @GetMapping("")
    public List<ListAccessoryResponse> getAll(){
        return accessoryService.getAll();
    }

    @PostMapping("")
    public AddAccessoryResponse add(@Valid @RequestBody AddAccessoryRequest addAccessoryRequest) {
       return accessoryService.add(addAccessoryRequest);

    }
}