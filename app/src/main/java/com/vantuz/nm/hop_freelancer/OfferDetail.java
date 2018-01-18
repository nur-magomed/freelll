package com.vantuz.nm.hop_freelancer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vantuz.nm.hop_freelancer.fragment.OpenOffersFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.Collections.addAll;

public class OfferDetail extends AppCompatActivity {

    /** Tag for the log messages */
    public static final String LOG_TAG = OpenOffersFragment.class.getSimpleName();

//    ProgressBar progressBar;
    LinearLayout ll;
    TextView clientName;
    TextView title;
    TextView date;
    TextView status;
    TextView amount;
    TextView username;
    TextView firstName;
    TextView lastName;

    /** URL to query the ORDER dataset for user archive */
    private static final String API_URI = "http://cn71805-wordpress-5.tw1.ru/";

    String offerId = "";
    Intent intent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_detail);
        init();
//        progressBar.setVisibility(View.VISIBLE);
        intent = getIntent();
        //TODO:
        // 1 progress bar
        offerId = intent.getStringExtra("offerId");

        loadOffer();

    }

    private void init() {
//         progressBar = (ProgressBar) findViewById(R.id.arch_loading_indicator);
         ll = (LinearLayout) findViewById(R.id.mainLL);
         clientName = (TextView) findViewById(R.id.client_name);
         title = (TextView) findViewById(R.id.of_tite);
         date = (TextView) findViewById(R.id.of_date);
         status = (TextView) findViewById(R.id.of_status);
         amount = (TextView) findViewById(R.id.of_amount);
         username = (TextView) findViewById(R.id.user_name);
         firstName = (TextView) findViewById(R.id.first_name);
         lastName = (TextView) findViewById(R.id.last_name);
    }

    private void loadOffer() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IRetrofit service = retrofit.create(IRetrofit.class);
        Call<List<Offer>> call = service.getOfferByTestId(offerId);

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<List<Offer>>() {
            @Override
            public void onResponse(Call<List<Offer>> call, Response<List<Offer>> response) {
                // The network call was a success and we got a response
                List<Offer> offerList = new ArrayList<Offer>();
                offerList.addAll(response.body());
                if (offerList.size()>0){
                    showOffer(offerList.get(0));
                }
            }

            @Override
            public void onFailure(Call<List<Offer>> call, Throwable t) {
                // the network call was a failure
                Log.e(LOG_TAG, "Error getting offers by id: ", t);
                Toast.makeText(OfferDetail.this, "Ошибка получения заказа через ID.", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void showOffer(Offer offer) {
//        Toast.makeText(this, "Message "+ offer.getTitle(), Toast.LENGTH_LONG).show();
//        Toast.makeText(this, "Img "+ offer.getPath(), Toast.LENGTH_LONG).show();
//        progressBar.setVisibility(View.GONE);
//        ll.setVisibility(View.VISIBLE);
        clientName.setText(offer.getClient_id());
        title.setText(offer.getTitle());
        date.setText(offer.getCreated_date());
        status.setText(offer.getStatus());
        amount.setText(String.valueOf(offer.getBudget()));
        username.setText(offer.getUsername());
        firstName.setText(offer.getFirstName());
        lastName.setText(offer.getLastName());
    }

}
