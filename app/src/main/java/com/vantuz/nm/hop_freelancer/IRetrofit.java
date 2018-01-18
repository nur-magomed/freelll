package com.vantuz.nm.hop_freelancer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by NM on 05.12.2017.
 */

public interface IRetrofit {

    @GET("order.php?action=client_id")
    Call<List<Offer>> getOfferByClientId(@Query("client_id") String id);

    @GET("order.php?action=select")
    Call<List<Offer>> getOffers();

    @GET("order.php?action=offer_id")
    Call<List<Offer>> getOfferById(@Query("offer_id") String id);

    @GET("order.php?action=test_id")
    Call<List<Offer>> getOfferByTestId(@Query("test_id") String id);
}
