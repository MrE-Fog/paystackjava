package com.payments.paystack.transactions;

import com.payments.paystack.PaystackService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TransactionService extends PaystackService<TransactionAPI> {
    private static TransactionService instance;
    private TransactionAPI serviceAPI;

    private TransactionService() {
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(TransactionAPI.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).client(getHttpClient()).build();
        serviceAPI = retrofit.create(TransactionAPI.class);
    }

    static {
        try {
            instance = new TransactionService();
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    public static final TransactionService getInstance() {
        return (TransactionService) instance;
    }

    @Override
    public final TransactionAPI getServiceAPI() {
        return serviceAPI;
    }
}