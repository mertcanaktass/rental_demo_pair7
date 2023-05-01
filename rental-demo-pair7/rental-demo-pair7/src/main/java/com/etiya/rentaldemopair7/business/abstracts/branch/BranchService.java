package com.etiya.rentaldemopair7.business.abstracts.branch;

import com.etiya.rentaldemopair7.business.dtos.requests.branch.AddBranchRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.branch.AddBranchResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.branch.ListBrachResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;

import java.util.List;

public interface BranchService {

    List<ListBrachResponse> getAll();

    DataResult<AddBranchResponse> add(AddBranchRequest addBranchRequest);
}
