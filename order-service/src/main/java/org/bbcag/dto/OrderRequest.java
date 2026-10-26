package org.bbcag.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record OrderRequest(

        @NotBlank(message = "Order-ID darf nicht leer sein")
        String orderId,

        @NotBlank(message = "Kunde darf nicht leer sein")
        String customer,

        @NotNull(message = "Betrag darf nicht leer sein")
        @Positive(message = "Betrag muss grösser als 0 sein")
        BigDecimal amount

) {
}