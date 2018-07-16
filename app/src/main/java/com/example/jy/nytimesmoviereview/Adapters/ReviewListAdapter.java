package com.example.jy.nytimesmoviereview.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jy.nytimesmoviereview.APIResponses.Review;
import com.example.jy.nytimesmoviereview.R;
import com.example.jy.nytimesmoviereview.Viewholders.MovieReviewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ReviewListAdapter extends RecyclerView.Adapter<MovieReviewHolder> {

    private List<Review> mReviewList;
    private LayoutInflater mInflater;
    private Context mContext;

    public ReviewListAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        mReviewList = new ArrayList<>();
    }

    @Override
    public MovieReviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.review_item, parent, false);
        return new MovieReviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieReviewHolder holder, int position) {
        Review review = mReviewList.get(position);

        if (TextUtils.isEmpty(review.getMpaa_rating())) {
            holder.mpaaRatingView.setVisibility(View.GONE);
        } else {
            holder.mpaaRatingView.setVisibility(View.VISIBLE);
            holder.mpaaRatingView.setText(review.getMpaa_rating());
            if (review.getMpaa_rating().equals("R")) {
                holder.mpaaRatingView.setTextColor(Color.RED);
            }
        }

        holder.publicationDateView.setText(review.getPublication_date());
        holder.titleView.setText(review.getDisplay_title());
        holder.bylineView.setText(review.getByline());
        holder.headlineView.setText(review.getHeadline());
        holder.summaryShortView.setText(review.getSummary_short());
        Picasso.with(mContext)
                .load(review.getMultimedia().getSrc())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return (mReviewList == null) ? 0 : mReviewList.size();
    }

    public void setReviewList(List<Review> reviewList) {
        if (mReviewList != null) {
            this.mReviewList.clear();
            this.mReviewList.addAll(reviewList);
            notifyDataSetChanged();
        }
    }
}