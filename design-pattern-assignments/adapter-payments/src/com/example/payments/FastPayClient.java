package com.example.payments;

public class FastPayClient {
    public String payNow(String custId, int amountCents) {
        return "FP#"+ custId + ":" + amountCents;
    }
}
