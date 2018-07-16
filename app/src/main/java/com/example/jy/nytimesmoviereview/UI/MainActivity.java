package com.example.jy.nytimesmoviereview.UI;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jy.nytimesmoviereview.APIResponses.Review;
import com.example.jy.nytimesmoviereview.APIServices.APIService;
import com.example.jy.nytimesmoviereview.Adapters.ReviewListAdapter;
import com.example.jy.nytimesmoviereview.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgressBar;
    private ReviewListAdapter mAdapter;
    private List<Review> mReviewList = new ArrayList<>();
    private static String REVIEW_DATA_KEY = "reviewData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mProgressBar = findViewById(R.id.progresBar);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mAdapter = new ReviewListAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        //check if we already saved data during configuration changes, no need to make same api call
        if (savedInstanceState != null) {
            mReviewList = savedInstanceState.getParcelableArrayList(REVIEW_DATA_KEY);
            mAdapter.setReviewList(mReviewList);
            mProgressBar.setVisibility(View.GONE);
        } else {
            mProgressBar.setVisibility(View.VISIBLE);
            fetchReviewList();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(REVIEW_DATA_KEY, (ArrayList<? extends Parcelable>) mReviewList);

    }

    private void fetchReviewList(){
        APIService.getInstance().getMovieReviewService().getMovieReviews(new Callback<Review.ReviewResult>() {
            @Override
            public void success(Review.ReviewResult reviewResult, Response response) {
                mProgressBar.setVisibility(View.GONE);
                mReviewList = reviewResult.getResults();
                mAdapter.setReviewList(reviewResult.getResults());
            }

            @Override
            public void failure(RetrofitError error) {
                mProgressBar.setVisibility(View.GONE);
                Log.e("Error", error.getMessage());
                Toast.makeText(getApplicationContext(), getString(R.string.error_message), Toast.LENGTH_LONG).show();
            }
        });
    }
}
