package com.example.jy.nytimesmoviereview.APIServices;

import com.example.jy.nytimesmoviereview.APIResponses.Review;

import retrofit.Callback;
import retrofit.http.GET;

import static com.example.jy.nytimesmoviereview.APIServices.APIConstants.MOVIE_REVIEW_LIST;

public interface ReviewListService {
    @GET(MOVIE_REVIEW_LIST)
    void getMovieReviews(Callback<Review.ReviewResult> cb);

}
