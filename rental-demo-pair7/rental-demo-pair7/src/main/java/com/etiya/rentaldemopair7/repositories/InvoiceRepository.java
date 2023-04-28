package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.entities.concreate.Invoice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    @Query("SELECT inv FROM Invoice inv")
    List<Invoice> findAllInvoice();

    @Query("SELECT inv.id FROM Invoice inv")
    List<Integer> findAllInvoiceId();

    @Query("SELECT inv FROM Invoice inv")
    List<Invoice> sortAllInvoice(Sort sort);
}
