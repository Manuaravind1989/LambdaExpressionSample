package com.mobiledev.lambdalombok.network;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobiledev.lambdalombok.R;

/**
 * Created by manu on 12/10/2017.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {
    public final TextView titleTV;
    public final ImageView posterView;

    public MovieViewHolder(View view) {
        super(view);
        titleTV =  view.findViewById(R.id.tvMovieTitle);
        posterView =  view.findViewById(R.id.imPoster);

    }
}