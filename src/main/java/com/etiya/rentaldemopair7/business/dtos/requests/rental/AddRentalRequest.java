package com.etiya.rentaldemopair7.business.dtos.requests.rental;

import com.etiya.rentaldemopair7.entities.concreate.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class AddRentalRequest {

    public AddRentalRequest(int customerId, int paymentId, Date orderDate, int invoiceId, int employeeId, int commentId) {
        this.customerId = customerId;
        this.paymentId = paymentId;
        this.orderDate = orderDate;
        this.invoiceId = invoiceId;
        this.employeeId = employeeId;
        this.commentId = commentId;
    }

    private int customerId;
    private int paymentId;
    private Date orderDate;
    private int invoiceId;
    private int employeeId;
    private int commentId;
}
