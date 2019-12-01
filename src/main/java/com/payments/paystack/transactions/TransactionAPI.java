package com.payments.paystack.transactions;

import com.payments.paystack.Paystack;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TransactionAPI  {

	static final String baseUrl = Paystack.baseUrl;

	@POST(baseUrl + "transaction/initialize")
	public abstract Call<TransactionResponse> initialize(@Body TransactionRequest request);

	@GET(baseUrl + "transaction/verify/{reference}")
	public Call<VerifyResponse> verify(@Path("reference") String reference);
}