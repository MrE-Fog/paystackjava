package com.payments.paystack.transactions;

import com.payments.paystack.PaystackService;

public class TrasactionService extends PaystackService {
    
    private TrasactionService() {
        
    }

    static {
        try {
            instance = new TrasactionService();
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}