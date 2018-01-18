package com.vantuz.nm.hop_freelancer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vantuz.nm.hop_freelancer.IRetrofit;
import com.vantuz.nm.hop_freelancer.Offer;
import com.vantuz.nm.hop_freelancer.R;
import com.vantuz.nm.hop_freelancer.adapter.OpenOffersListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenOffersFragment extends AbstractTabFragment {

    /** Tag for the log messages */
    public static final String LOG_TAG = OpenOffersFragment.class.getSimpleName();

    private static final int LAYOUT = R.layout.fragment_open_offers;

    /** URL to query the ORDER dataset for user archive */
    private static final String API_URI = "http://cn71805-wordpress-5.tw1.ru/";

    //rest req available_offers
    private List<Offer> offersList = new ArrayList<>();
    private ProgressBar pb;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(LAYOUT, container, false);
        loadOffers();

        pb = (ProgressBar) view.findViewById(R.id.loading_indicator);
        pb.setVisibility(View.VISIBLE);
        rv = (RecyclerView) view.findViewById(R.id.recycleView);


        return view;
    }


    public static AbstractTabFragment getInstance(Context context) {
        Bundle args = new Bundle();
        OpenOffersFragment fragment = new OpenOffersFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_in_progress));

        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private void loadOffers() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IRetrofit service = retrofit.create(IRetrofit.class);
        Call<List<Offer>> call = service.getOffers();

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<List<Offer>>() {
            @Override
            public void onResponse(Call<List<Offer>> call, Response<List<Offer>> response) {
                // The network call was a success and we got a response
                offersList.addAll(response.body());
                showOffers();
            }

            @Override
            public void onFailure(Call<List<Offer>> call, Throwable t) {
                // the network call was a failure
                Log.e(LOG_TAG, "Error getting open offers by retrofit: ", t);
                Toast.makeText(context, "Ошибка получения заказов", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void showOffers() {
        pb.setVisibility(View.GONE);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new OpenOffersListAdapter(offersList));
        rv.callOnClick();
    }

}
