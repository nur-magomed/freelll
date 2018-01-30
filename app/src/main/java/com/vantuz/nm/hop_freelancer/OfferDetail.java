package com.vantuz.nm.hop_freelancer;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vantuz.nm.hop_freelancer.fragment.ApplyDialog;
import com.vantuz.nm.hop_freelancer.fragment.OpenOffersFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class OfferDetail extends AppCompatActivity {

    /** Tag for the log messages */
    public static final String LOG_TAG = OpenOffersFragment.class.getSimpleName();

    Offer offfer;

    TextView username;
    TextView firstName;
    TextView lastName;

    ProgressBar progressBar;
    LinearLayout ll;
    TextView clientName;
    TextView title;
    TextView date;
    TextView status;
    TextView amount;
    TextView address;

    Button btn_apply;

    EditText propAmount;
    EditText propDesc;

    /** URL to query the ORDER dataset for user archive */
    private static final String API_URI = "http://cn71805-wordpress-5.tw1.ru/";

    private String mockFreelanceId = "0";


    String offerId = "";
    Intent intent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_detail);
        init();
        ll.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        intent = getIntent();
        //TODO:
        // 1 progress bar
        offerId = intent.getStringExtra("offerId");

        loadOffer();

    }

    private void init() {
        progressBar = (ProgressBar) findViewById(R.id.arch_loading_indicator);
        ll          = (LinearLayout) findViewById(R.id.mainLL);
        username    = (TextView) findViewById(R.id.user_name);
        firstName   = (TextView) findViewById(R.id.first_name);
        lastName    = (TextView) findViewById(R.id.last_name);
        clientName  = (TextView) findViewById(R.id.client_name);
        title       = (TextView) findViewById(R.id.of_title);
        date        = (TextView) findViewById(R.id.of_date);
        status      = (TextView) findViewById(R.id.of_status);
        amount      = (TextView) findViewById(R.id.of_amount);
        address     = (TextView) findViewById(R.id.of_address);
        propAmount  = (EditText) findViewById(R.id.prop_amount);
        propDesc    = (EditText) findViewById(R.id.prop_desc);
        btn_apply   = (Button) findViewById(R.id.btn_apply);
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
                if(response.body() != null) {
                    List<Offer> offerList = new ArrayList<Offer>();
                    offerList.addAll(response.body());
                    if (offerList.size() > 0) {
                        showOffer(offerList.get(0));
                    }
                } else {
                    Toast.makeText(OfferDetail.this, "Что-то пошло не так. Ошибка получения информации по задаче.", Toast.LENGTH_LONG).show();
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

    /**
     * Displaying offer details
     * @param offer
     */
    private void showOffer(Offer offer) {

        offfer = offer;
        btn_apply.setOnClickListener(apply);


        progressBar.setVisibility(View.GONE);
        ll.setVisibility(View.VISIBLE);
        clientName.setText(offer.getClient_id());
        title.setText(offer.getTitle());
        date.setText(offer.getCreated_date());
        status.setText(offer.getStatus());
        amount.setText(String.valueOf(offer.getBudget()));
        address.setText(offer.getAddress());
        username.setText(offer.getUsername());
        firstName.setText(offer.getFirstName());
        lastName.setText(offer.getLastName());

        propAmount.setText(offer.getBudget()+"");
        propDesc.setText("Здравствуйте! Буду рад выполнить Ваш заказ.");

        //TODO убрать логику вьюшки из retrofita
        isApplied();
    }

    private View.OnClickListener apply = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //TODO apply dialog
//            ApplyDialog dialog = new ApplyDialog();
//            FragmentManager manager = getFragmentManager();
//            dialog.show(manager, "fff");

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_URI)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            IRetrofit service = retrofit.create(IRetrofit.class);
            Proposal proposal = new Proposal(offfer.getOrderClientId(), mockFreelanceId, propAmount.getText()+"", propDesc.getText()+"");

            Call<List<Proposal>> call = service.sendProposal(proposal);

            // Execute the call asynchronously. Get a positive or negative callback.
            call.enqueue(new Callback<List<Proposal>>() {
                @Override
                public void onResponse(Call<List<Proposal>> call, Response<List<Proposal>> response) {
                    // The network call was a success and we got a response
                    List<Proposal> props = new ArrayList<Proposal>();
                    props.addAll(response.body());
                    Toast.makeText(OfferDetail.this, "Предложение успешно отправлено." + props.get(0).getClientOrderId(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<List<Proposal>> call, Throwable t) {
                    // the network call was a failure
                    Log.e(LOG_TAG, "Error getting open offers by retrofit: ", t);
                    Toast.makeText(OfferDetail.this, "Ошибка отправки предложения", Toast.LENGTH_LONG).show();
                }
            });

        }
    };

    public boolean isApplied() {
        boolean applied = false;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         IRetrofit service = retrofit.create(IRetrofit.class);

        Call<List<Proposal>> call = service.getProposal(offfer.getOrderClientId(), mockFreelanceId);

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<List<Proposal>>() {
            @Override
            public void onResponse(Call<List<Proposal>> call, Response<List<Proposal>> response) {
                // The network call was a success and we got a response

                if(response.body() != null) {
                    List<Proposal> props = new ArrayList<Proposal>();
                    props.addAll(response.body());
                    if (props.size() > 0) {
                        btn_apply.setVisibility(View.INVISIBLE);
                        Toast.makeText(OfferDetail.this, "Предложение уже отправлено." + props.get(0).getClientOrderId(), Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    //response body null
                }
            }

            @Override
            public void onFailure(Call<List<Proposal>> call, Throwable t) {
                // the network call was a failure
                Log.e(LOG_TAG, "Error getting open offers by retrofit: ", t);
                Toast.makeText(OfferDetail.this, "Ошибка отправки предложения", Toast.LENGTH_LONG).show();
            }
        });

        return applied;
    }
}
