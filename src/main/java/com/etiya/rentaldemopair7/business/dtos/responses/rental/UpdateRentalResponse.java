package com.etiya.rentaldemopair7.business.dtos.responses.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalResponse {
    private int id;
    private int customerId;
    private int paymentId;
    private String orderDate;
    private int invoiceId;
    private int employeeId;
    private int commentId;
}
