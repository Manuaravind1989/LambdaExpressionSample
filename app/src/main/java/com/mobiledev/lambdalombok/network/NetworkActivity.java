package com.mobiledev.lambdalombok.network;

import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mobiledev.lambdalombok.R;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by manu on 12/10/2017.
 */

public class NetworkActivity extends AppCompatActivity {

    private CompositeDisposable mCompositeDisposable;
    private RecyclerView mRecyclerView;
    private MoviesAdapter moviesAdapter;
    private SwipyRefreshLayout mSwipeRefreshLayout;
    private Integer current_page=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        setUpRecyclerView();
        loadJSON(current_page);
    }

    private void setUpRecyclerView(){
        mSwipeRefreshLayout =  findViewById(R.id.swipyrefreshlayout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefreshLayout.setOnRefreshListener(direction -> {
            loadJSON(current_page);
            mRecyclerView.post(() -> moviesAdapter.notifyDataSetChanged());
            current_page++;
            mSwipeRefreshLayout.setRefreshing(false);
        });
        mRecyclerView =  findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        moviesAdapter = new MoviesAdapter(NetworkActivity.this);
        mRecyclerView.setAdapter(moviesAdapter);
        mCompositeDisposable = new CompositeDisposable();
    }

    private void loadJSON(int page) {
        RequestInterface requestInterface = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RequestInterface.class);

        mCompositeDisposable.add(requestInterface.getPopularMovies("",page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));
    }

    private void handleResponse(PopularMovieModel popularMoviesModel) {
        if(popularMoviesModel.getData().size()>0) {
            moviesAdapter.addMovies(popularMoviesModel.getData());
            moviesAdapter.notifyDataSetChanged();
        }
    }

    private void handleError(Throwable error) {
        Toast.makeText(this, "Error "+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }


}
