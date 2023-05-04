package com.etiya.rentaldemopair7.api.controllers.accessory;

import com.etiya.rentaldemopair7.business.abstracts.accessory.AccessoryService;
import com.etiya.rentaldemopair7.business.dtos.requests.accessory.AddAccessoryRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.accessory.UpdateAccessoryRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.AddAccessoryResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.ListAccessoryResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.UpdateAccessoryResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
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
    public DataResult<List<ListAccessoryResponse>> getAll(){
        return accessoryService.getAll();
    }

    @PostMapping("")
    public DataResult<AddAccessoryResponse> add(@Valid @RequestBody AddAccessoryRequest addAccessoryRequest) {
        DataResult<AddAccessoryResponse> response = accessoryService.add(addAccessoryRequest);
        return response;
    }

    @PutMapping("")
    public DataResult<UpdateAccessoryResponse> update(@Valid @RequestBody UpdateAccessoryRequest updateAccessoryRequest){
        return accessoryService.update(updateAccessoryRequest);
    }
}
