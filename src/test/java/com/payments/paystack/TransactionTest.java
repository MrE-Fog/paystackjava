package com.payments.paystack;

import com.payments.paystack.transactions.TransactionRequest;
import com.payments.paystack.transactions.TransactionService;

public class TransactionTest {
    public static void main(String[] args) {
        PaystackSetup.setAuthToken("sk_test_02df9413ed474f26fd3e4ba3a2289cff3f6b39ba");
        TransactionRequest request = new TransactionRequest(null, null, null, null, 0, 0);
        TransactionService.getInstance().getServiceAPI().initialize(request);
    }
}