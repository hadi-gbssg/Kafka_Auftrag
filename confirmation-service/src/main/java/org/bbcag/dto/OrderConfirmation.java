package org.bbcag.dto;

public record OrderConfirmation(
        String orderId,
        String status
) {
}