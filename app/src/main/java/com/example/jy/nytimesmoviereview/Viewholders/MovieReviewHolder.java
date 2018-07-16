package com.example.jy.nytimesmoviereview.Viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jy.nytimesmoviereview.R;

public class MovieReviewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView bylineView;
    public TextView headlineView;
    public TextView titleView;
    public TextView publicationDateView;
    public TextView mpaaRatingView;
    public TextView summaryShortView;

    public MovieReviewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        bylineView = itemView.findViewById(R.id.byline);
        headlineView = itemView.findViewById(R.id.headline);
        titleView = itemView.findViewById(R.id.display_title);
        publicationDateView = itemView.findViewById(R.id.publication_date);
        mpaaRatingView = itemView.findViewById(R.id.mpaa_rating);
        summaryShortView = itemView.findViewById(R.id.summary_short);
    }
}
