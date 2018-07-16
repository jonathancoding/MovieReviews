package com.example.jy.nytimesmoviereview.APIServices;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

import static com.example.jy.nytimesmoviereview.APIServices.APIConstants.API_KEY;

public class APIService {
    private static APIService mInstance;
    private APIService() {

    }
    public static APIService getInstance() {
        if (mInstance != null) {
            return mInstance;
        } else {
            return new APIService();
        }
    }
    public ReviewListService getMovieReviewService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(APIConstants.END_POINT)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addEncodedQueryParam("api-key", API_KEY);
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        return restAdapter.create(ReviewListService.class);
    }
}
