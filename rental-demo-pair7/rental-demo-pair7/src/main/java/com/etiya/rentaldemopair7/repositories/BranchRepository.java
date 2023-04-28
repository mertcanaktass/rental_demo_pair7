package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.business.dtos.responses.branch.ListBrachResponse;
import com.etiya.rentaldemopair7.entities.concreate.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch,Integer> {

    Branch findByName (String name);

    @Query(value = "select new " +
            "com.etiya.rentaldemopair7.business.dtos.responses.branch.ListBrachResponse(b.id, b.name, b.city) " +
            "from Branch b")
    List<ListBrachResponse> getAll();

}
