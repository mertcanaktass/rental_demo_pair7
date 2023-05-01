package com.etiya.rentaldemopair7.api.controllers.branch;

import com.etiya.rentaldemopair7.business.abstracts.branch.BranchService;
import com.etiya.rentaldemopair7.business.dtos.requests.accessory.UpdateAccessoryRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.branch.AddBranchRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.branch.UpdateBranchRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.UpdateAccessoryResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.branch.AddBranchResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.branch.ListBrachResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.branch.UpdateBranchResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchesController {

    @Autowired
    public BranchesController(BranchService branchService) {
        this.branchService = branchService;
    }

    private BranchService branchService;

    @GetMapping("")
    public List<ListBrachResponse> getAll(){
        return branchService.getAll();
    }

    @PostMapping("")
    public DataResult<AddBranchResponse> add(@Valid @RequestBody AddBranchRequest addBranchRequest)  {
      return branchService.add(addBranchRequest);
    }

    @PutMapping("")
    public DataResult<UpdateBranchResponse> update(@Valid @RequestBody UpdateBranchRequest updateBranchRequest){
        return branchService.update(updateBranchRequest);
    }
}
