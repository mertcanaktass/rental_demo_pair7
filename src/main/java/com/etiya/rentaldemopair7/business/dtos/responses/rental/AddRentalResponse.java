package com.etiya.rentaldemopair7.business.dtos.responses.rental;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalResponse {
    private int id;
    private int customerId;
    private int paymentId;
    private Date orderDate;
    private int invoiceId;
    private int employeeId;
    private int commentId;
}
