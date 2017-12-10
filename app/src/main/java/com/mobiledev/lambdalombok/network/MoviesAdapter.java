package com.mobiledev.lambdalombok.network;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobiledev.lambdalombok.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manu on 12/10/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<PopularMovieModel.DataBean> mValues = new ArrayList<>();
    private Context context;

    public MoviesAdapter(Context context){
        this.context=context;
    }

    public void addMovies(List<PopularMovieModel.DataBean> movies){
        mValues.addAll(movies);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, final int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder,final int position){
        holder.titleTV.setText(mValues.get(position).getTitle());
        Picasso.with(context)
                .load(mValues.get(position).getPoster())
                .into(holder.posterView);
    }

    @Override
    public int getItemCount(){
        return mValues.size();
    }

    public void filterList(List<PopularMovieModel.DataBean> filterdNames) {
        this.mValues = filterdNames;
        notifyDataSetChanged();
    }
}