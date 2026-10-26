package org.bbcag.dto;

import java.math.BigDecimal;

public record OrderRequest(
        String orderId,
        String customer,
        BigDecimal amount
) {
}