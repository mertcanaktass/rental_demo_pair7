package com.etiya.rentaldemopair7.business.concretes.branch;

import com.etiya.rentaldemopair7.business.abstracts.branch.BranchService;
import com.etiya.rentaldemopair7.business.dtos.requests.branch.AddBranchRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.branch.AddBranchResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.branch.ListBrachResponse;
import com.etiya.rentaldemopair7.core.exceptions.BusinessException;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.core.utils.result.SuccessDataResult;
import com.etiya.rentaldemopair7.core.utils.result.SuccessResult;
import com.etiya.rentaldemopair7.entities.concreate.Branch;
import com.etiya.rentaldemopair7.repositories.BranchRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BranchManager implements BranchService {
    private BranchRepository branchRepository;
    private ModelMapperService modelMapperService;

    private MessageSource messageSource;

    @Autowired
    public BranchManager(BranchRepository branchRepository, ModelMapperService modelMapperService, MessageSource messageSource) {
        this.branchRepository = branchRepository;
        this.modelMapperService = modelMapperService;
        this.messageSource = messageSource;
    }

    @Override
    public List<ListBrachResponse> getAll() {
        return branchRepository.getAll();
    }

    @Override
    public DataResult<AddBranchResponse> add(AddBranchRequest addBranchRequest) {
        Branch addBranch =
                branchRepository.findByName(addBranchRequest.getName());
        if(addBranch != null)
            throw new BusinessException(messageSource.getMessage("branchExists",null, LocaleContextHolder.getLocale()));


        Branch branch = modelMapperService.forRequest().map(addBranchRequest, Branch.class);
        branchRepository.save(branch);

        AddBranchResponse response = modelMapperService.forResponse().map(branch, AddBranchResponse.class);
                return new SuccessDataResult<>(response,"şube eklendi");
    }
}
