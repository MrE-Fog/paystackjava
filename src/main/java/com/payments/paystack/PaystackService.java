package com.payments.paystack;

import retrofit2.Call;

public class PaystackService {
    protected static PaystackService instance;

    public static final PaystackService getInstance() {
        return instance;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static final IResult<?> enqueue(final Call<?> call, final IResult resultCallback) {
        call.enqueue(resultCallback);
        return resultCallback;
    }

}