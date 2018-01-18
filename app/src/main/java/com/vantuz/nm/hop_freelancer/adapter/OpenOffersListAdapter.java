package com.vantuz.nm.hop_freelancer.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vantuz.nm.hop_freelancer.MainActivity;
import com.vantuz.nm.hop_freelancer.Offer;
import com.vantuz.nm.hop_freelancer.OfferDetail;
import com.vantuz.nm.hop_freelancer.R;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by NM on 26/10/17.
 */
public class OpenOffersListAdapter extends RecyclerView.Adapter<OpenOffersListAdapter.OfferViewHolder>  {

    //Tag name for logging
    public static final String LOG_TAG = OpenOffersListAdapter.class.getName();

    private List<Offer> offerData;

    public OpenOffersListAdapter(List<Offer> offerData) {
        this.offerData = offerData;
    }

    @Override
    public OfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_item, parent, false);
        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OfferViewHolder holder, int position) {
        Offer offer = offerData.get(position);
        holder.title.setText(offer.getTitle());
        DateFormat strToDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date created = new Date();
        try {
             created = strToDate.parse(offer.getCreated_date());
        } catch (ParseException e) {
            Log.e(LOG_TAG, "Error parsing created_date: ", e);
        }
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String dateStr = df.format(created); //change to create_dl
        holder.deadline.setText(dateStr);
        String priceStr = offer.getBudget() + ",00";
        holder.price.setText(priceStr);
        holder.status.setText(offer.getStatus());
        holder.offerId = offer.getOffer_id();
    }

    @Override
    public int getItemCount() {
        return offerData.size();
    }

    public static class OfferViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView category;
        TextView status;
        TextView deadline;
        TextView price;
        String offerId;

        public OfferViewHolder(final View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "id: " + offerId + "   position: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), OfferDetail.class);
                    intent.putExtra("offerId", offerId);
                    view.getContext().startActivity(intent);
                }
            });
            title       = (TextView) itemView.findViewById(R.id.offer_title_tv);
            category    = (TextView) itemView.findViewById(R.id.offer_category_tv);
            status      = (TextView) itemView.findViewById(R.id.offer_status_tv);
            deadline    = (TextView) itemView.findViewById(R.id.offer_deadline_tv);
            price       = (TextView) itemView.findViewById(R.id.offer_price_tv);
        }


    }


}