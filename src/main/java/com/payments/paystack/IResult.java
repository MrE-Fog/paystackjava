package com.payments.paystack;

import retrofit2.Callback;

public interface IResult<T> extends Callback<T> {
    public T getObject();
}
