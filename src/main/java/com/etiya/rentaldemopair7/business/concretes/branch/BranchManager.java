package com.etiya.rentaldemopair7.business.concretes.branch;

import com.etiya.rentaldemopair7.business.abstracts.branch.BranchService;
import com.etiya.rentaldemopair7.business.constants.Messages;
import com.etiya.rentaldemopair7.business.dtos.requests.branch.AddBranchRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.branch.UpdateBranchRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.branch.AddBranchResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.branch.ListBrachResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.branch.UpdateBranchResponse;
import com.etiya.rentaldemopair7.core.exceptions.types.BusinessException;
import com.etiya.rentaldemopair7.core.internationalization.MessageService;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.core.utils.result.SuccessDataResult;
import com.etiya.rentaldemopair7.entities.concreate.Branch;
import com.etiya.rentaldemopair7.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BranchManager implements BranchService {
    private BranchRepository branchRepository;
    private ModelMapperService modelMapperService;
    private MessageService messageService;

    @Autowired
    public BranchManager(BranchRepository branchRepository, ModelMapperService modelMapperService, MessageService messageService) {
        this.branchRepository = branchRepository;
        this.modelMapperService = modelMapperService;
        this.messageService = messageService;
    }

    @Override
    public List<ListBrachResponse> getAll() {
        return branchRepository.getAll();
    }

    @Override
    public DataResult<AddBranchResponse> add(AddBranchRequest addBranchRequest) {
        Branch addBranch =
                branchRepository.findByName(addBranchRequest.getName());
        if (addBranch != null)
            throw new BusinessException(messageService.getMessage(Messages.Branch.BranchExists));


        Branch branch = modelMapperService.forRequest().map(addBranchRequest, Branch.class);
        branchRepository.save(branch);

        AddBranchResponse response = modelMapperService.forResponse().map(branch, AddBranchResponse.class);
        return new SuccessDataResult<>(response, messageService.getMessage(Messages.Branch.SuccessAddBranch));
    }

    @Override
    public DataResult<UpdateBranchResponse> update(UpdateBranchRequest updateBranchRequest) {
        Branch branch = modelMapperService.forRequest().map(updateBranchRequest, Branch.class);
        branchRepository.save(branch);

        UpdateBranchResponse response = modelMapperService.forResponse().map(branch, UpdateBranchResponse.class);
        return new SuccessDataResult<>(response, Messages.Branch.BranchUpdated);
    }
}